package com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 看理想-类别对象 ideal_category
 *
 * @author mylady
 * @date 2023-10-07
 */
public class IdealCategory extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

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
     * 浏览次数
     */
    @Excel(name = "浏览次数")
    private Long visitor;

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
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 子类的排序字段
     */
    @Excel(name = "子类的排序字段")
    private String childSortField;

    /**
     * 置顶
     */
    @Excel(name = "置顶")
    private Integer isTop;

    /**
     * 当前分类是否允许评论
     */
    @Excel(name = "当前分类是否允许评论")
    private Integer isComment;

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

    public void setVisitor(Long visitor) {
        this.visitor = visitor;
    }

    public Long getVisitor() {
        return visitor;
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

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setChildSortField(String childSortField) {
        this.childSortField = childSortField;
    }

    public String getChildSortField() {
        return childSortField;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Integer getIsComment() {
        return isComment;
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
                .append("name", getName())
                .append("coverImage", getCoverImage())
                .append("editorMode", getEditorMode())
                .append("content", getContent())
                .append("preContent", getPreContent())
                .append("visitor", getVisitor())
                .append("role", getRole())
                .append("roleValue", getRoleValue())
                .append("sort", getSort())
                .append("childSortField", getChildSortField())
                .append("isTop", getIsTop())
                .append("isComment", getIsComment())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
