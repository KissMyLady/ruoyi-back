package com.ruoyi.framework.web.service;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.exception.user.BlackListException;
import com.ruoyi.common.exception.user.CaptchaException;
import com.ruoyi.common.exception.user.CaptchaExpireException;
import com.ruoyi.common.exception.user.UserNotExistsException;
import com.ruoyi.common.exception.user.UserPasswordNotMatchException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.MessageUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.ip.IpUtils;
import com.ruoyi.framework.manager.AsyncManager;
import com.ruoyi.framework.manager.factory.AsyncFactory;
import com.ruoyi.framework.security.context.AuthenticationContextHolder;
import com.ruoyi.system.service.ISysConfigService;
import com.ruoyi.system.service.ISysUserService;

import java.util.TimerTask;

/**
 * 登录校验方法
 *
 * @author ruoyi
 */
@Component
public class SysLoginService {

    private static final Logger logger = LoggerFactory.getLogger(SysLoginService.class);

    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysConfigService configService;

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid) {
        // 验证码校验
        // validateCaptcha(username, code, uuid);
        logger.warn("当前dev开发环境关闭了验证码校验, 部署环境请打开");
        // 登录前置校验
        loginPreCheck(username, password);
        // 用户验证
        Authentication authentication = null;

        try {
            UsernamePasswordAuthenticationToken aToken = new UsernamePasswordAuthenticationToken(username, password);
            AuthenticationContextHolder.setContext(aToken);
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername
            authentication = authenticationManager.authenticate(aToken);
        } catch (Exception e) {
            if (e instanceof BadCredentialsException) {
                String msg = MessageUtils.message("user.password.not.match");
                //记录登录信息
                TimerTask timerTask = AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, msg);
                AsyncManager.me().execute(timerTask);
                throw new UserPasswordNotMatchException();
            } else {
                //记录登录信息
                TimerTask timerTask = AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, e.getMessage());
                AsyncManager.me().execute(timerTask);
                throw new ServiceException(e.getMessage());
            }
        } finally {
            AuthenticationContextHolder.clearContext();
        }

        //消息
        String message = MessageUtils.message("user.login.success");

        //任务, 调用方法 recordLogininfor, 记录登录过程信息
        TimerTask timerTask = AsyncFactory.recordLogininfor(
                username,
                Constants.LOGIN_SUCCESS,
                message
        );

        //异步任务执行, 执行
        AsyncManager.me().execute(timerTask);

        LoginUser loginUser = (LoginUser) authentication.getPrincipal();

        //刷新用户表的登录信息
        recordLoginInfo(loginUser.getUserId());

        // 生成token
        String token = tokenService.createToken(loginUser);
        return token;
    }

    /**
     * 校验验证码
     *
     * @param username 用户名
     * @param code     验证码
     * @param uuid     唯一标识
     * @return 结果
     */
    public void validateCaptcha(String username, String code, String uuid) {
        boolean captchaEnabled = configService.selectCaptchaEnabled();

        if (captchaEnabled) {
            String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
            String captcha = redisCache.getCacheObject(verifyKey);
            redisCache.deleteObject(verifyKey);

            if (captcha == null) {
                String message = MessageUtils.message("user.jcaptcha.expire");
                TimerTask timerTask = AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, message);
                AsyncManager.me().execute(timerTask);
                //验证码失效
                throw new CaptchaExpireException();
            }
            if (!code.equalsIgnoreCase(captcha)) {
                String message = MessageUtils.message("user.jcaptcha.error");
                TimerTask timerTask = AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, message);
                AsyncManager.me().execute(timerTask);
                //验证码错误
                throw new CaptchaException();
            }
        }
    }

    /**
     * 登录前置校验
     *
     * @param username 用户名
     * @param password 用户密码
     */
    public void loginPreCheck(String username, String password) {
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("not.null")));
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }
        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.password.not.match")));
            throw new UserPasswordNotMatchException();
        }
        // IP黑名单校验
        String blackStr = configService.selectConfigByKey("sys.login.blackIPList");
        if (IpUtils.isMatchedIp(blackStr, IpUtils.getIpAddr())) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("login.blocked")));
            throw new BlackListException();
        }
    }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId) {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setLoginIp(IpUtils.getIpAddr());
        sysUser.setLoginDate(DateUtils.getNowDate());
        // logger.info("记录用户登录信息: {}", sysUser);
        userService.updateUserProfile(sysUser);
    }
}
