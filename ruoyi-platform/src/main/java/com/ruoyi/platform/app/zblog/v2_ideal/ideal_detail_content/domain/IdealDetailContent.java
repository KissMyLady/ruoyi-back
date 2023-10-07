package com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 看理想-详情对象 ideal_detail_content
 *
 * @author mylady
 * @date 2023-10-07
 */
public class IdealDetailContent extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * uuid
     */
    @Excel(name = "uuid")
    private String uuid;

    /**
     * 关联类别
     */
    @Excel(name = "关联类别")
    private Long forIdealCategoryId;

    /**
     * 上级文档
     */
    @Excel(name = "上级文档")
    private Long parentDoc;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 简单描述
     */
    @Excel(name = "简单描述")
    private String descNote;

    /**
     * 编辑器模式.1md,2富文本
     */
    @Excel(name = "编辑器模式.1md,2富文本")
    private Long editorMode;

    /**
     * 文档内容_含html格式
     */
    @Excel(name = "文档内容_含html格式")
    private String content;

    /**
     * 文档内容_预览_纯文本
     */
    @Excel(name = "文档内容_预览_纯文本")
    private String preContent;

    /**
     * 权限值0表示公开，1表示私密,2表示指定用户可见,3表示访问码可见
     */
    @Excel(name = "权限值0表示公开，1表示私密,2表示指定用户可见,3表示访问码可见")
    private Long role;

    /**
     * 权限值
     */
    @Excel(name = "权限值")
    private String roleValue;

    /**
     * 封面图
     */
    @Excel(name = "封面图")
    private String indexImgStatic;

    /**
     * 音频地址
     */
    @Excel(name = "音频地址")
    private String dtlMusic;

    /**
     * 浏览次数
     */
    @Excel(name = "浏览次数")
    private Long visitor;

    /**
     * 当前是否允许评论
     */
    @Excel(name = "当前是否允许评论")
    private Integer allowComment;

    /**
     * 删除标记
     */
    @Excel(name = "删除标记")
    private Integer isDelete;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setForIdealCategoryId(Long forIdealCategoryId) {
        this.forIdealCategoryId = forIdealCategoryId;
    }

    public Long getForIdealCategoryId() {
        return forIdealCategoryId;
    }

    public void setParentDoc(Long parentDoc) {
        this.parentDoc = parentDoc;
    }

    public Long getParentDoc() {
        return parentDoc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescNote(String descNote) {
        this.descNote = descNote;
    }

    public String getDescNote() {
        return descNote;
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

    public void setRole(Long role) {
        this.role = role;
    }

    public Long getRole() {
        return role;
    }

    public void setRoleValue(String roleValue) {
        this.roleValue = roleValue;
    }

    public String getRoleValue() {
        return roleValue;
    }

    public void setIndexImgStatic(String indexImgStatic) {
        this.indexImgStatic = indexImgStatic;
    }

    public String getIndexImgStatic() {
        return indexImgStatic;
    }

    public void setDtlMusic(String dtlMusic) {
        this.dtlMusic = dtlMusic;
    }

    public String getDtlMusic() {
        return dtlMusic;
    }

    public void setVisitor(Long visitor) {
        this.visitor = visitor;
    }

    public Long getVisitor() {
        return visitor;
    }

    public void setAllowComment(Integer allowComment) {
        this.allowComment = allowComment;
    }

    public Integer getAllowComment() {
        return allowComment;
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
                .append("uuid", getUuid())
                .append("forIdealCategoryId", getForIdealCategoryId())
                .append("parentDoc", getParentDoc())
                .append("title", getTitle())
                .append("descNote", getDescNote())
                .append("editorMode", getEditorMode())
                .append("content", getContent())
                .append("preContent", getPreContent())
                .append("role", getRole())
                .append("roleValue", getRoleValue())
                .append("indexImgStatic", getIndexImgStatic())
                .append("dtlMusic", getDtlMusic())
                .append("visitor", getVisitor())
                .append("allowComment", getAllowComment())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
