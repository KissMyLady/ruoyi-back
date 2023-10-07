package com.ruoyi.platform.app.zblog.v1_blog.blog_doc.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章对象 blog_doc
 *
 * @author mylady
 * @date 2023-10-07
 */
public class BlogDoc extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建用户id
     */
    @Excel(name = "创建用户id")
    private Long createUserId;

    /**
     * 所属文集id
     */
    @Excel(name = "所属文集id")
    private Long projectId;

    /**
     * 父级文档
     */
    @Excel(name = "父级文档")
    private Long parentDoc;

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
     * 状态码.0表示草稿状态,1表示发布状态,2表示删除状态
     */
    @Excel(name = "状态码.0表示草稿状态,1表示发布状态,2表示删除状态")
    private Long status;

    /**
     * 打开下级
     */
    @Excel(name = "打开下级")
    private Integer openChildren;

    /**
     * 显示下级
     */
    @Excel(name = "显示下级")
    private Integer showChildren;

    /**
     * 数据行权限
     */
    @Excel(name = "数据行权限")
    private Long dataRowAuth;

    /**
     * 水印状态
     */
    @Excel(name = "水印状态")
    private Integer isWatermark;

    /**
     * 水印类型
     */
    @Excel(name = "水印类型")
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

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setParentDoc(Long parentDoc) {
        this.parentDoc = parentDoc;
    }

    public Long getParentDoc() {
        return parentDoc;
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

    public void setOpenChildren(Integer openChildren) {
        this.openChildren = openChildren;
    }

    public Integer getOpenChildren() {
        return openChildren;
    }

    public void setShowChildren(Integer showChildren) {
        this.showChildren = showChildren;
    }

    public Integer getShowChildren() {
        return showChildren;
    }

    public void setDataRowAuth(Long dataRowAuth) {
        this.dataRowAuth = dataRowAuth;
    }

    public Long getDataRowAuth() {
        return dataRowAuth;
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

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createUserId", getCreateUserId())
                .append("projectId", getProjectId())
                .append("parentDoc", getParentDoc())
                .append("name", getName())
                .append("editorMode", getEditorMode())
                .append("content", getContent())
                .append("preContent", getPreContent())
                .append("sort", getSort())
                .append("status", getStatus())
                .append("openChildren", getOpenChildren())
                .append("showChildren", getShowChildren())
                .append("dataRowAuth", getDataRowAuth())
                .append("isWatermark", getIsWatermark())
                .append("watermarkType", getWatermarkType())
                .append("watermarkValue", getWatermarkValue())
                .append("visitor", getVisitor())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("modifyTime", getModifyTime())
                .toString();
    }

}
