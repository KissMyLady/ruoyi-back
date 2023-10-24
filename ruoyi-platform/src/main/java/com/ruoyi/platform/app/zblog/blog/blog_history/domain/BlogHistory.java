package com.ruoyi.platform.app.zblog.blog.blog_history.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 博客文档历史记录对象 blog_history
 *
 * @author mylady
 * @date 2023-10-24
 */
public class BlogHistory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 文档id
     */
    @Excel(name = "文档id")
    private Long blogId;

    /**
     * 文档历史编辑内容
     */
    @Excel(name = "文档历史编辑内容")
    private String preContent;

    /**
     * 创建用户
     */
    @Excel(name = "创建用户")
    private Long userId;

    /**
     * 逻辑删除
     */
    @Excel(name = "逻辑删除")
    private Integer isDelete;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setPreContent(String preContent) {
        this.preContent = preContent;
    }

    public String getPreContent() {
        return preContent;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("blogId", getBlogId())
                .append("preContent", getPreContent())
                .append("userId", getUserId())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
