package com.ruoyi.platform.app.zblog.blog.blog_blog.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 博客文档对象 blog_blog
 *
 * @author mylady
 * @date 2023-10-24
 */
public class BlogBlog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 所属文集
     */
    @Excel(name = "所属文集")
    private Long projectId;

    /**
     * 创建用户id
     */
    @Excel(name = "创建用户id")
    private Long userId;

    /**
     * 父级文档
     */
    @Excel(name = "父级文档")
    private Long parentBlog;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String name;

    /**
     * 编辑器模式.1md,2富文本
     */
    @Excel(name = "编辑器模式.1md,2富文本")
    private Long editorMode;

    /**
     * 文档内容
     */
    @Excel(name = "文档内容")
    private String content;

    /**
     * 文档内容_预览_纯文本
     */
    @Excel(name = "文档内容_预览_纯文本")
    private String preContent;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 状态码.0草稿,1发布,2删除
     */
    @Excel(name = "状态码.0草稿,1发布,2删除")
    private Long status;

    /**
     * 编辑状态,打开下级
     */
    @Excel(name = "编辑状态,打开下级")
    private Integer editOpenChildren;

    /**
     * 浏览状态,打开下级
     */
    @Excel(name = "浏览状态,打开下级")
    private Integer showOpenChildren;

    /**
     * 权限代号
     */
    @Excel(name = "权限代号")
    private String authorityCode;

    /**
     * 权限具体限定内容
     */
    @Excel(name = "权限具体限定内容")
    private String authorityValue;

    /**
     * 水印状态
     */
    @Excel(name = "水印状态")
    private Integer isWatermark;

    /**
     * 水印类型 1表示文字水印 2表示图片水印
     */
    @Excel(name = "水印类型 1表示文字水印 2表示图片水印")
    private Long watermarkType;

    /**
     * 水印内容
     */
    @Excel(name = "水印内容")
    private String watermarkValue;

    /**
     * 浏览次数
     */
    @Excel(name = "浏览次数")
    private Long visitor;

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

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setParentBlog(Long parentBlog) {
        this.parentBlog = parentBlog;
    }

    public Long getParentBlog() {
        return parentBlog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEditorMode(Long editorMode) {
        this.editorMode = editorMode;
    }

    public Long getEditorMode() {
        return editorMode;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setPreContent(String preContent) {
        this.preContent = preContent;
    }

    public String getPreContent() {
        return preContent;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return status;
    }

    public void setEditOpenChildren(Integer editOpenChildren) {
        this.editOpenChildren = editOpenChildren;
    }

    public Integer getEditOpenChildren() {
        return editOpenChildren;
    }

    public void setShowOpenChildren(Integer showOpenChildren) {
        this.showOpenChildren = showOpenChildren;
    }

    public Integer getShowOpenChildren() {
        return showOpenChildren;
    }

    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode;
    }

    public String getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityValue(String authorityValue) {
        this.authorityValue = authorityValue;
    }

    public String getAuthorityValue() {
        return authorityValue;
    }

    public void setIsWatermark(Integer isWatermark) {
        this.isWatermark = isWatermark;
    }

    public Integer getIsWatermark() {
        return isWatermark;
    }

    public void setWatermarkType(Long watermarkType) {
        this.watermarkType = watermarkType;
    }

    public Long getWatermarkType() {
        return watermarkType;
    }

    public void setWatermarkValue(String watermarkValue) {
        this.watermarkValue = watermarkValue;
    }

    public String getWatermarkValue() {
        return watermarkValue;
    }

    public void setVisitor(Long visitor) {
        this.visitor = visitor;
    }

    public Long getVisitor() {
        return visitor;
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
                .append("projectId", getProjectId())
                .append("userId", getUserId())
                .append("parentBlog", getParentBlog())
                .append("name", getName())
                .append("editorMode", getEditorMode())
                .append("content", getContent())
                .append("preContent", getPreContent())
                .append("sort", getSort())
                .append("status", getStatus())
                .append("editOpenChildren", getEditOpenChildren())
                .append("showOpenChildren", getShowOpenChildren())
                .append("authorityCode", getAuthorityCode())
                .append("authorityValue", getAuthorityValue())
                .append("isWatermark", getIsWatermark())
                .append("watermarkType", getWatermarkType())
                .append("watermarkValue", getWatermarkValue())
                .append("visitor", getVisitor())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
