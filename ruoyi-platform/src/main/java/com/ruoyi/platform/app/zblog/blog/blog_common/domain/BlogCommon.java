package com.ruoyi.platform.app.zblog.blog.blog_common.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 博客评论对象 blog_common
 *
 * @author mylady
 * @date 2023-10-24
 */
public class BlogCommon extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 关联到具体内容
     */
    @Excel(name = "关联到具体内容")
    private Long blogIt;

    /**
     * 父评论id
     */
    @Excel(name = "父评论id")
    private String parentId;

    /**
     * 评论人id
     */
    @Excel(name = "评论人id")
    private String author;

    /**
     * 评论内容
     */
    @Excel(name = "评论内容")
    private String content;

    /**
     * 主机地址
     */
    @Excel(name = "主机地址")
    private String operIp;

    /**
     * 操作地点
     */
    @Excel(name = "操作地点")
    private String operLocation;

    /**
     * 请求头
     */
    @Excel(name = "请求头")
    private String reqAgent;

    /**
     * 浏览器
     */
    @Excel(name = "浏览器")
    private String reqBrowser;

    /**
     * 操作系统
     */
    @Excel(name = "操作系统")
    private String reqSystem;

    /**
     * 点赞数
     */
    @Excel(name = "点赞数")
    private Long likeNum;

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

    public void setBlogIt(Long blogIt) {
        this.blogIt = blogIt;
    }

    public Long getBlogIt() {
        return blogIt;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setReqAgent(String reqAgent) {
        this.reqAgent = reqAgent;
    }

    public String getReqAgent() {
        return reqAgent;
    }

    public void setReqBrowser(String reqBrowser) {
        this.reqBrowser = reqBrowser;
    }

    public String getReqBrowser() {
        return reqBrowser;
    }

    public void setReqSystem(String reqSystem) {
        this.reqSystem = reqSystem;
    }

    public String getReqSystem() {
        return reqSystem;
    }

    public void setLikeNum(Long likeNum) {
        this.likeNum = likeNum;
    }

    public Long getLikeNum() {
        return likeNum;
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
                .append("blogIt", getBlogIt())
                .append("parentId", getParentId())
                .append("author", getAuthor())
                .append("content", getContent())
                .append("operIp", getOperIp())
                .append("operLocation", getOperLocation())
                .append("reqAgent", getReqAgent())
                .append("reqBrowser", getReqBrowser())
                .append("reqSystem", getReqSystem())
                .append("likeNum", getLikeNum())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
