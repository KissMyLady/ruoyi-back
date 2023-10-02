package com.ruoyi.platform.app.mydoc.app_doc_doc.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * app_doc_doc对象 app_doc_doc
 *
 * @author mylady
 * @date 2023-10-02
 */
public class AppDocDoc extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Excel(name = "主键")
    private Long id;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String name;

    /**
     * 文档内容
     */
    @Excel(name = "文档内容")
    private String content;

    /**
     * 文档内容_预览
     */
    @Excel(name = "文档内容_预览")
    private String preContent;

    /**
     * 所属文集id
     */
    @Excel(name = "所属文集id")
    private Long topDoc;

    /**
     * 创建用户id
     */
    @Excel(name = "创建用户id")
    private Long createUserId;

    /**
     * 父级文档
     */
    @Excel(name = "父级文档")
    private Long parentDoc;

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
     * 编辑器模式.1表示Editormd编辑器,2表示Vditor编辑器,3表示iceEditor编辑器,5表示Tinymce富文本
     */
    @Excel(name = "编辑器模式.1表示Editormd编辑器,2表示Vditor编辑器,3表示iceEditor编辑器,5表示Tinymce富文本")
    private Long editorMode;

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
     * 浏览次数
     */
    @Excel(name = "浏览次数")
    private Long visitor;

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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void setTopDoc(Long topDoc) {
        this.topDoc = topDoc;
    }

    public Long getTopDoc() {
        return topDoc;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setParentDoc(Long parentDoc) {
        this.parentDoc = parentDoc;
    }

    public Long getParentDoc() {
        return parentDoc;
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

    public void setEditorMode(Long editorMode) {
        this.editorMode = editorMode;
    }

    public Long getEditorMode() {
        return editorMode;
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

    public void setVisitor(Long visitor) {
        this.visitor = visitor;
    }

    public Long getVisitor() {
        return visitor;
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
                .append("name", getName())
                .append("content", getContent())
                .append("preContent", getPreContent())
                .append("topDoc", getTopDoc())
                .append("createUserId", getCreateUserId())
                .append("parentDoc", getParentDoc())
                .append("sort", getSort())
                .append("status", getStatus())
                .append("editorMode", getEditorMode())
                .append("openChildren", getOpenChildren())
                .append("showChildren", getShowChildren())
                .append("visitor", getVisitor())
                .append("createTime", getCreateTime())
                .append("modifyTime", getModifyTime())
                .toString();
    }

}
