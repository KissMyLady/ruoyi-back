package com.ruoyi.framework.aspectj;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.TypeUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.annotation.ReturnAESEncrypt;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.security.EncryptUtilsService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruoyi.common.annotation.AESEncrypt;
import com.ruoyi.common.security.BaseEncrypt;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/11 22:57
 * @Description:
 */
@Aspect
@Component
public class AESEncryptAop {

    private static final Logger logger = LoggerFactory.getLogger(AESEncryptAop.class);
    @Autowired
    private EncryptUtilsService encryptUtilsService;

    /**
     * 返回值加密
     */
    @Pointcut("@annotation(com.ruoyi.common.annotation.ReturnAESEncrypt)")
    public void encryptReturnData() {
    }

    //切入
    @Around("encryptReturnData()")
    public Object encryptAndDecryptHandle(ProceedingJoinPoint point) throws Throwable {
        // 获得请求参数 TimeDto()
        Object[] args = point.getArgs();
        //logger.info("获取请求参数: {}", args);
        MethodSignature signature = (MethodSignature) point.getSignature();
        //方法获取
        Method method = signature.getMethod();
        // 获得方法注解
        ReturnAESEncrypt annotation = method.getAnnotation(ReturnAESEncrypt.class);
        // 入参, 请求参数解密
//        if (annotation != null && annotation.enable()) {
//            this.decryptParams(args, method);
//        }
        // 等待返回结果
        Object returnValue = point.proceed(args);
        // 返回值出参, 执行加密操作
        if (annotation != null && annotation.enable()) {
            // logger.info("返回值出参, 执行加密操作: {}", annotation);
            returnValue = this.resultEncrypt(returnValue);
        }
        // logger.info("返回值加密: {}", returnValue);
        return returnValue;
    }


    //请求参数解密, 并反射赋值
    private void decryptParams(Object[] args, Method method) {
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];

            //强转args对象
            BaseEncrypt baseEncrypt = (BaseEncrypt) arg;
            String s1 = baseEncrypt.getS();

            //解密对象
            String decrypt = encryptUtilsService.aesDecrypt(s1);

            // 根据方法类型转化对象
            Type type = TypeUtil.getParamType(method, i);
            //转换为集合
            Object parse = JSONUtil.parse(decrypt);
            Object obj = Convert.convert(type, parse);

            // 修改缓存中设备数据 空值不覆盖
            Map<String, Object> modelBeanMap = BeanUtil.beanToMap(obj);
            modelBeanMap.entrySet().removeIf(entry -> entry.getValue() == null);

            // 反射赋值
            Field[] fields = ReflectUtil.getFields(arg.getClass());
            for (Field f : fields) {
                Object val = modelBeanMap.get(f.getName());
                if (val == null) {
                    continue;
                }
                BeanUtil.setProperty(arg, f.getName(), val);
            }
        }
    }

    //返回值加密方法
    private Object resultEncrypt(Object returnValue) {
        if (ObjectUtil.isEmpty(returnValue) || returnValue == null) {
            return returnValue;
        }
        try {
            /**
             * AjaxResult 加密
             */
            if (returnValue instanceof AjaxResult) {
                // 重新赋值 data
                AjaxResult ret = (AjaxResult) returnValue;
                //调用加密 Object 对象
                List<Map<String, Object>> content = ret.getContent();
                Object data = ret.getData();

                //优先加密 data
                if(ObjectUtil.isNotEmpty(data) && data != null && !data.toString().equals("")){
                    String sData = encryptUtilsService.aesEncryptObject(data);
                    ret.put("text", sData);
                    ret.setContent(null);
                }
                // if (ObjectUtil.isNotEmpty(content) && content != null && !content.toString().equals(""))
                else {
                    String sData = encryptUtilsService.aesEncryptListMap(content);
                    ret.put("text", sData);
                    ret.setContent(null);
                }
            }
            /**
             * TableDataInfo 加密
             */
            else if (returnValue instanceof TableDataInfo) {
                TableDataInfo ret = (TableDataInfo) returnValue;
                List<?> rows = ret.getRows();
                if (ObjectUtil.isNotEmpty(rows) && rows != null && !rows.toString().equals("")) {
                    String sData = encryptUtilsService.aesEncryptListMap((List<Map<String, Object>>) rows);
                    ret.setText(sData);
                    ret.setRows(null);
                }
            }
            /**
             * ResultVo 加密
             */
            else if (returnValue instanceof ResultVo) {
                ResultVo<Object> ret = (ResultVo<Object>) returnValue;
                //调用加密 Object 对象
                Object data = ret.getData();
                Object msg = ret.getMsg();
                if(data != null && !data.toString().equals("")){
                    //这里不确定加密的方式, 不再这里进行加密
                    String sData = encryptUtilsService.aesEncryptObject(data);
                    ret.setData(sData);
                }
            }
            //其他情况
            else {
                logger.warn("返回值不是AjaxResult类型, 直接 aesEncryptObject 对Object进行 加密");
                //否则直接加密对象
                returnValue = encryptUtilsService.aesEncryptObject(returnValue);
            }
        } catch (Exception e) {
            // 非对称加密失败
            throw new ServiceException("Encrypt加密失败: " + e, 500);
        }
        return returnValue;
    }

}
