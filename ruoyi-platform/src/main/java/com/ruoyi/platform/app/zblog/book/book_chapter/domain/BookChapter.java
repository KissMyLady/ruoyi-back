package com.ruoyi.platform.app.zblog.book.book_chapter.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 章节对象 book_chapter
 *
 * @author mylady
 * @date 2023-10-30
 */
public class BookChapter extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建用户id
     */
    @Excel(name = "创建用户id")
    private Long userId;

    /**
     * 关联类别
     */
    @Excel(name = "关联类别")
    private Long bookId;

    /**
     * 父级文档
     */
    @Excel(name = "父级文档")
    private Long parentId;

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
     * 封面图
     */
    @Excel(name = "封面图")
    private String coverImg;

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
     * 浏览次数
     */
    @Excel(name = "浏览次数")
    private Long visitor;

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
     * 当前是否允许评论
     */
    @Excel(name = "当前是否允许评论")
    private Integer allowComment;

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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
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

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getCoverImg() {
        return coverImg;
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

    public void setVisitor(Long visitor) {
        this.visitor = visitor;
    }

    public Long getVisitor() {
        return visitor;
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
                .append("userId", getUserId())
                .append("bookId", getBookId())
                .append("parentId", getParentId())
                .append("title", getTitle())
                .append("descNote", getDescNote())
                .append("coverImg", getCoverImg())
                .append("editorMode", getEditorMode())
                .append("content", getContent())
                .append("preContent", getPreContent())
                .append("editOpenChildren", getEditOpenChildren())
                .append("showOpenChildren", getShowOpenChildren())
                .append("visitor", getVisitor())
                .append("authorityCode", getAuthorityCode())
                .append("authorityValue", getAuthorityValue())
                .append("allowComment", getAllowComment())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
