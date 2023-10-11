package com.ruoyi.common.utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/11 22:56
 * @Description:
 */
public class GetDefault {

    public static void main(String[] args) {
        String dateStr = getFormData();
        System.out.println("dateStr: " + dateStr);
    }

    /**
     * 获取格式化时间
     */
    public static String getFormData() {
        String format = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
        return format;  //2022-04-30_10:42
    }


    public static String getSslKey() {

        return "";
    }

    public static String getTime() {
        DateTime date = DateUtil.date();  ////2021-11-24 18:51:33
        return "" + date;
    }

    public static String getUuidFileName(String suffixName) {
        UUID uuid = UUID.randomUUID();
        return uuid.toString() + "." + suffixName;
    }

    public static String getDefault(String something, String defaultStr) {
        if (something == null || something == "") {
            return defaultStr;
        }
        return something;
    }

    public static String getDefault(String something) {
        if (something == null || something == "") {
            return "空";
        }
        return something;
    }

    public static Integer getDefault(Integer something, Integer defaultStr) {
        if (something == null) {
            return defaultStr;
        }
        return something;
    }

    public static Integer getDefault(String something, Integer defaultStr) {
        if (something != null) {
            try {
                return Integer.valueOf(something);
            } catch (Exception e) {
                return defaultStr;
            }
        }
        return defaultStr;
    }

    public static Integer getDefault(Integer something) {
        if (something == null) {
            return 0;
        }
        return something;
    }

    /**
     * 获取纯粹的UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
