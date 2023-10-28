package com.ruoyi.platform.app.zblog.blog.blog_blog.domain;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/28 20:13
 * @Description:
 */
public class BatchChangeAuthCodeDto {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private List<Integer> ids;

    /**
     * 权限代号
     */
    private String code;

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
