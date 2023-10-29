package com.ruoyi.platform.app.zblog.ideal.ideal_detail.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 详情对象 ideal_detail
 *
 * @author mylady
 * @date 2023-10-29
 */
public class IdealDetail extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 关联类别id
     */
    @Excel(name = "关联类别id")
    private Long projectId;

    /**
     * 创建用户id
     */
    @Excel(name = "创建用户id")
    private Long userId;

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
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

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
     * 封面图
     */
    @Excel(name = "封面图")
    private String indexImgStatic;

    /**
     * 资源类型,1音频
     */
    @Excel(name = "资源类型,1音频")
    private String srcType;

    /**
     * 音频地址
     */
    @Excel(name = "音频地址")
    private String srcUrl;

    /**
     * 浏览次数
     */
    @Excel(name = "浏览次数")
    private Long visitor;

    /**
     * 当前是否允许评论
     */
    @Excel(name = "当前是否允许评论")
    private Integer isAllowComment;

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

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
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

    public void setIndexImgStatic(String indexImgStatic) {
        this.indexImgStatic = indexImgStatic;
    }

    public String getIndexImgStatic() {
        return indexImgStatic;
    }

    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }

    public String getSrcType() {
        return srcType;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setVisitor(Long visitor) {
        this.visitor = visitor;
    }

    public Long getVisitor() {
        return visitor;
    }

    public void setIsAllowComment(Integer isAllowComment) {
        this.isAllowComment = isAllowComment;
    }

    public Integer getIsAllowComment() {
        return isAllowComment;
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
                .append("title", getTitle())
                .append("descNote", getDescNote())
                .append("editorMode", getEditorMode())
                .append("content", getContent())
                .append("preContent", getPreContent())
                .append("sort", getSort())
                .append("authorityCode", getAuthorityCode())
                .append("authorityValue", getAuthorityValue())
                .append("indexImgStatic", getIndexImgStatic())
                .append("srcType", getSrcType())
                .append("srcUrl", getSrcUrl())
                .append("visitor", getVisitor())
                .append("isAllowComment", getIsAllowComment())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
