package com.ruoyi.framework.aspectj;

import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eu.bitwalker.useragentutils.UserAgent;
import net.dreamlu.mica.ip2region.core.Ip2regionSearcher;
import net.dreamlu.mica.ip2region.core.IpInfo;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson2.JSON;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.enums.BusinessStatus;
import com.ruoyi.common.enums.HttpMethod;
import com.ruoyi.common.filter.PropertyPreExcludeFilter;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.ip.IpUtils;
import com.ruoyi.framework.manager.AsyncManager;
import com.ruoyi.framework.manager.factory.AsyncFactory;
import com.ruoyi.system.domain.SysOperLog;

/**
 * 操作日志记录处理
 *
 * @author ruoyi
 */
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private Ip2regionSearcher ip2regionSearcher;

    /**
     * 排除敏感属性字段
     */
    public static final String[] EXCLUDE_PROPERTIES = {"password", "oldPassword", "newPassword", "confirmPassword"};

    /**
     * 计算操作消耗时间
     */
    private static final ThreadLocal<Long> TIME_THREADLOCAL = new NamedThreadLocal<Long>("Cost Time");

    /**
     * 处理请求前执行
     */
    @Before(value = "@annotation(controllerLog)")
    public void boBefore(JoinPoint joinPoint, Log controllerLog) {
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }

    /**
     * 处理完请求后执行
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "@annotation(controllerLog)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint,
                                 Log controllerLog,
                                 Object jsonResult
    ) {
        handleLog(joinPoint, controllerLog, null, jsonResult);
    }

    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(value = "@annotation(controllerLog)", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Log controllerLog, Exception e) {
        handleLog(joinPoint, controllerLog, e, null);
    }

    protected void handleLog(final JoinPoint joinPoint,
                             Log controllerLog,
                             final Exception e,
                             Object jsonResult
    ) {
        try {
            // 获取当前的用户
            LoginUser loginUser = SecurityUtils.getLoginUser();

            // *========数据库日志=========*//
            SysOperLog operLog = new SysOperLog();
            operLog.setStatus(BusinessStatus.SUCCESS.ordinal());

            // 请求的地址
            String ip = IpUtils.getIpAddr();
            operLog.setOperIp(ip);

            HttpServletRequest request = ServletUtils.getRequest();  // 获取request
            String requestURI = request.getRequestURI();  // 请求url

            operLog.setOperUrl(StringUtils.substring(requestURI, 0, 255));

            String header = request.getHeader("User-Agent");

            //请求
            //设置浏览器, 访问ip
            final UserAgent userAgent = UserAgent.parseUserAgentString(header);

            // 获取客户端操作系统
            String os = userAgent.getOperatingSystem().getName();
            // 获取客户端浏览器
            String browser = userAgent.getBrowser().getName();

            operLog.setReqAgent(userAgent.toString());
            operLog.setReqBrowser(browser);
            operLog.setReqSystem(os);

            // logger.info("获取到的浏览器请求头: {}, os: {}, browser: {}", userAgent.toString(), os, browser);

            if (loginUser != null) {
                operLog.setOperName(loginUser.getUsername());
            }

            if (e != null) {
                operLog.setStatus(BusinessStatus.FAIL.ordinal());
                String eMsg = e.getMessage();  //StringUtils.substring(e.getMessage(), 0, 2000);
                operLog.setErrorMsg(eMsg);
            }

            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            operLog.setMethod(className + "." + methodName + "()");
            // 设置请求方式
            operLog.setRequestMethod(ServletUtils.getRequest().getMethod());
            // 处理设置注解上的参数
            getControllerMethodDescription(joinPoint, controllerLog, operLog, jsonResult);
            // 设置消耗时间
            operLog.setCostTime(System.currentTimeMillis() - TIME_THREADLOCAL.get());

            //查询ip地址
            IpInfo ipInfo = ip2regionSearcher.memorySearch(ip);
            String address = ipInfo.getAddress();
            operLog.setOperLocation(address);

            // 保存数据库
            AsyncManager.me().execute(
                    AsyncFactory.recordOper(operLog)
            );
        } catch (Exception exp) {
            // 记录本地异常日志
            logger.error("LOG日志注解AOP异常信息:{}", exp.getMessage());
            exp.printStackTrace();
        } finally {
            TIME_THREADLOCAL.remove();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param log     日志
     * @param operLog 操作日志
     * @throws Exception
     */
    public void getControllerMethodDescription(JoinPoint joinPoint,
                                               Log log,
                                               SysOperLog operLog,
                                               Object jsonResult
    ) throws Exception {
        // 设置action动作
        operLog.setBusinessType(log.businessType().ordinal());
        // 设置标题
        operLog.setTitle(log.title());
        // 设置操作人类别
        operLog.setOperatorType(log.operatorType().ordinal());
        // 是否需要保存request，参数和值
        if (log.isSaveRequestData()) {
            // 获取参数的信息，传入到数据库中。
            setRequestValue(
                    joinPoint,
                    operLog,
                    log.excludeParamNames()
            );
        }
        // 是否需要保存response，参数和值
        if (log.isSaveResponseData() && StringUtils.isNotNull(jsonResult)) {
            String jsonString = JSON.toJSONString(jsonResult);
            // String substring = StringUtils.substring(JSON.toJSONString(jsonResult), 0, 2000);
            operLog.setJsonResult(jsonString);
        }
    }

    /**
     * 获取请求的参数，放到log中
     *
     * @param operLog 操作日志
     * @throws Exception 异常
     */
    private void setRequestValue(JoinPoint joinPoint,
                                 SysOperLog operLog,
                                 String[] excludeParamNames
    ) throws Exception {
        Map<?, ?> paramsMap = ServletUtils.getParamMap(ServletUtils.getRequest());
        String requestMethod = operLog.getRequestMethod();

        if (StringUtils.isEmpty(paramsMap)
                && (HttpMethod.PUT.name().equals(requestMethod)
                || HttpMethod.POST.name().equals(requestMethod)))
        {
            String params = argsArrayToString(joinPoint.getArgs(), excludeParamNames);
            operLog.setOperParam(params); //StringUtils.substring(params, 0, 2000));

        } else {
            String jsonString = JSON.toJSONString(paramsMap, excludePropertyPreFilter(excludeParamNames));
            // String substring = StringUtils.substring(jsonString, 0, 2000);  //保留2000个字符
            operLog.setOperParam(jsonString);
        }
    }

    /**
     * 参数拼装
     */
    private String argsArrayToString(Object[] paramsArray, String[] excludeParamNames) {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0) {
            for (Object o : paramsArray) {
                if (StringUtils.isNotNull(o) && !isFilterObject(o)) {
                    try {
                        String jsonObj = JSON.toJSONString(o, excludePropertyPreFilter(excludeParamNames));
                        params += jsonObj.toString() + " ";
                    } catch (Exception e) {
                        logger.warn("日志Log注解AOP参数拼装错误, 原因是: {}", e.toString());
                    }
                }
            }
        }
        return params.trim();
    }

    /**
     * 忽略敏感属性
     */
    public PropertyPreExcludeFilter excludePropertyPreFilter(String[] excludeParamNames) {
        //敏感属性字段
        String[] strings = ArrayUtils.addAll(EXCLUDE_PROPERTIES, excludeParamNames);
        PropertyPreExcludeFilter pro = new PropertyPreExcludeFilter();
        pro.addExcludes(strings);
        return pro;
    }

    /**
     * 判断是否需要过滤的对象。
     *
     * @param o 对象信息。
     * @return 如果是需要过滤的对象，则返回true；否则返回false。
     */
    @SuppressWarnings("rawtypes")
    public boolean isFilterObject(final Object o) {
        Class<?> clazz = o.getClass();
        if (clazz.isArray()) {
            return clazz.getComponentType().isAssignableFrom(MultipartFile.class);
        } else if (Collection.class.isAssignableFrom(clazz)) {
            Collection collection = (Collection) o;
            for (Object value : collection) {
                return value instanceof MultipartFile;
            }
        } else if (Map.class.isAssignableFrom(clazz)) {
            Map map = (Map) o;
            for (Object value : map.entrySet()) {
                Map.Entry entry = (Map.Entry) value;
                return entry.getValue() instanceof MultipartFile;
            }
        }

        boolean b = o instanceof MultipartFile
                || o instanceof HttpServletRequest
                || o instanceof HttpServletResponse
                || o instanceof BindingResult;
        return b;
    }
}
