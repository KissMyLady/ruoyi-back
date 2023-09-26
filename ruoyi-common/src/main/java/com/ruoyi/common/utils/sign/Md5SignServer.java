package com.ruoyi.common.utils.sign;

import java.util.TreeMap;
import com.ruoyi.common.utils.http.RequestEncoder;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 14:12
 * @Description:
 */
public class Md5SignServer {

    TreeMap<String, String> requestData = new TreeMap<>();

    /** md5的一般加密 */
    public String md5_sign_v1(String... args){
        StringBuilder sb = new StringBuilder();
        int a = 0;
        for(String item : args){
            requestData.put("v_" + a, item);
            sb.append(item);
            a ++;
        }
        //结尾加上md5
        String encoderRequestDto = RequestEncoder.formatRequest(requestData);
        sb.append(encoderRequestDto);
        String encodeMd5 = RequestEncoder.encode(sb.toString());
        return encodeMd5;
    }

}
