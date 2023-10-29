package com.ruoyi.platform.app.zblog.ideal.ideal_project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 分类对象 ideal_project
 *
 * @author mylady
 * @date 2023-10-29
 */
public class IdealProject extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 类别代号
     */
    @Excel(name = "类别代号")
    private String typeCode;

    /**
     * 创建用户id
     */
    @Excel(name = "创建用户id")
    private Long userId;

    /**
     * 分类名称
     */
    @Excel(name = "分类名称")
    private String name;

    /**
     * 封面图
     */
    @Excel(name = "封面图")
    private String coverImage;

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
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 子类的排序字段
     */
    @Excel(name = "子类的排序字段")
    private String sortField;

    /**
     * 当前分类是否允许评论
     */
    @Excel(name = "当前分类是否允许评论")
    private Integer isAllowComment;

    /**
     * 置顶
     */
    @Excel(name = "置顶")
    private Integer isTop;

    /**
     * 项目浏览次数
     */
    @Excel(name = "项目浏览次数")
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

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getCoverImage() {
        return coverImage;
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

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortField() {
        return sortField;
    }

    public void setIsAllowComment(Integer isAllowComment) {
        this.isAllowComment = isAllowComment;
    }

    public Integer getIsAllowComment() {
        return isAllowComment;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsTop() {
        return isTop;
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
                .append("typeCode", getTypeCode())
                .append("userId", getUserId())
                .append("name", getName())
                .append("coverImage", getCoverImage())
                .append("editorMode", getEditorMode())
                .append("content", getContent())
                .append("preContent", getPreContent())
                .append("authorityCode", getAuthorityCode())
                .append("authorityValue", getAuthorityValue())
                .append("sort", getSort())
                .append("sortField", getSortField())
                .append("isAllowComment", getIsAllowComment())
                .append("isTop", getIsTop())
                .append("visitor", getVisitor())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
