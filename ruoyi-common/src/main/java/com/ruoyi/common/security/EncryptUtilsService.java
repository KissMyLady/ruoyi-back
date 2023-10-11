package com.ruoyi.common.security;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.core.domain.EncryptDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.utils.GetDefault;
import org.springframework.stereotype.Service;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/11 22:55
 * @Description:
 */
@Service
public class EncryptUtilsService {

    private static final Logger logger = LoggerFactory.getLogger(EncryptUtilsService.class);

    //进一步封装, 返回解密后的json字符串
    public String getJsonObj(String dtoJsonObj) {
        //切割
        String substring = dtoJsonObj.substring(3, dtoJsonObj.length() - 1);
        // logger.info("substring: {}", substring);

        //解密
        String secretKey = GetDefault.getFormData();
        String publicData = this.aesDecrypt(substring, secretKey);
        // logger.info("解密后的对象打印: {}", publicData);

        String replace = publicData.replace("\r", "").replace("\n", "");
        return replace;
    }

    //将json对象加密为字符串, 传递给前端
    public String jsonEncryptToString(JSONObject jsonPageObj) {
        //加密
        String secretKey = GetDefault.getFormData();
        return this.aesEncrypt(jsonPageObj.toString(), secretKey);
    }


    //将json对象加密为字符串, 传递给后端
    public String jsonEncryptToString(String cipherText) {
        //加密
        String secretKey = GetDefault.getFormData();
        return this.aesEncrypt(cipherText, secretKey);
    }

    //AES解密
    public String aesDecrypt(String encryptStr, String secretKey) {
        try {
            byte[] encryptByte = Base64.getDecoder().decode(encryptStr);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secretKey.getBytes(), "AES"));
            byte[] decryptBytes = cipher.doFinal(encryptByte);
            return new String(decryptBytes);
        } catch (Exception e) {
            logger.error("AES解密失败, 原因是: {}", "" + e);
            return "";
        }
    }

    //AES解密2
    public String aesDecrypt(String encryptStr) {
        String secretKey = GetDefault.getFormData();
        try {
            byte[] encryptByte = Base64.getDecoder().decode(encryptStr);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(secretKey.getBytes(), "AES"));
            byte[] decryptBytes = cipher.doFinal(encryptByte);
            return new String(decryptBytes);
        } catch (Exception e) {
            logger.error("AES解密失败, 原因是: {}", "" + e);
            return "";
        }
    }

    //AES加密
    public String aesEncrypt(String content, String secretKey) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(secretKey.getBytes(), "AES"));
            byte[] encryptStr = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptStr);
        } catch (Exception e) {
            logger.error("AES加密, 原因是: {}", "" + e);
            return "";
        }
    }

    public String aesEncryptObject(Object object) {
        String secretKey = GetDefault.getFormData();
        try {
            //转换
            String jsonStr = JSONUtil.toJsonStr(object);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(secretKey.getBytes(), "AES"));
            byte[] encryptStr = cipher.doFinal(jsonStr.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptStr);
        } catch (Exception e) {
            logger.error("aesEncryptMap, AES加密失败" + e);
            return "";
        }
    }

    //加密Map 查询
    public String aesEncryptMap(Map<String, Object> content) {
        // logger.info("content: {}", content);
        // 打印map对象 content: {ac_is_bool_1=0, is_superuser=0, ... }
        String secretKey = GetDefault.getFormData();
        try {
            //转换
            String jsonStr = JSONUtil.toJsonStr(content);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(secretKey.getBytes(), "AES"));
            byte[] encryptStr = cipher.doFinal(jsonStr.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptStr);
        } catch (Exception e) {
            logger.error("aesEncryptMap, 对Map进行AES加密失败" + e);
            return "加密失败." + e;
        }
    }

    /**
     * AES加密数组
     */
    public String aesEncryptListMap(List<Map<String, Object>> content) {
        String secretKey = GetDefault.getFormData();
        try {
            //转换
            String jsonStr = JSONUtil.toJsonStr(content);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(secretKey.getBytes(), "AES"));
            byte[] encryptStr = cipher.doFinal(jsonStr.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(encryptStr);
        } catch (Exception e) {
            logger.error("aesEncryptMap, 对List进行AES加密失败" + e);
            return "";
        }
    }

    /**
     * 获取加密字符串, 解密, 返回对象类型
     */
    public EncryptDto decryptString2Dto(EncryptDto dto) {
        if (ObjectUtil.isNotEmpty(dto.getA())) {
            dto.setA(aesDecrypt(dto.getA()));
        }
        if (ObjectUtil.isNotEmpty(dto.getB())) {
            dto.setB(aesDecrypt(dto.getB()));
        }
        if (ObjectUtil.isNotEmpty(dto.getC())) {
            dto.setC(aesDecrypt(dto.getC()));
        }
        if (ObjectUtil.isNotEmpty(dto.getD())) {
            dto.setD(aesDecrypt(dto.getD()));
        }
        if (ObjectUtil.isNotEmpty(dto.getE())) {
            dto.setE(aesDecrypt(dto.getE()));
        }
        return dto;
    }

}
