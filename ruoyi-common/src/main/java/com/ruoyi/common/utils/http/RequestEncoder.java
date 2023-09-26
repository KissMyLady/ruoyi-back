package com.ruoyi.common.utils.http;

import org.springframework.util.DigestUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 14:14
 * @Description:
 */
public class RequestEncoder {

    public static String encode(String str) {
        String s = DigestUtils.md5DigestAsHex(str.getBytes());
        return s;
    }

    /** 将请求的参数拼接起来 */
    public static String formatRequest(Map<String, String> data) {
        Set<String> keySet = data.keySet();
        Iterator<String> it = keySet.iterator();
        StringBuffer stringBuffer = new StringBuffer();

        while (it.hasNext()) {
            String key = it.next();
            Object value = data.get(key);
            if (value != null) {
                stringBuffer.append(key + "=" + value + "&");
            }
        }
        if (stringBuffer.length() != 0) {
            return stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        return null;
    }

}
