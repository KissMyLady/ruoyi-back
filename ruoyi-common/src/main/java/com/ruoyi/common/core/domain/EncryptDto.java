package com.ruoyi.common.core.domain;
import cn.hutool.json.JSONObject;
import lombok.Data;


/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/11 22:54
 * @Description:
 */
@Data
public class EncryptDto {

    /**
     * id主键
     */
    private String a;

    /**
     * 主要参数, 较短的
     */
    private String b;

    /**
     * 长文本内容
     */
    private String c;

    /**
     * 其他 1
     */
    private String d;

    /**
     * 其他 2
     */
    private String e;

    private JSONObject jsonObject;

}
