package com.ruoyi.common.security;

import java.io.Serializable;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/11 22:55
 * @Description:
 */
public class BaseEncrypt implements Serializable{

    private static final long serialVersionUID = 1L;


    //加密数据
    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }


}
