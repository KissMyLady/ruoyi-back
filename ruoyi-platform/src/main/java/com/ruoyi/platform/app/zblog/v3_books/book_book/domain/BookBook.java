package com.ruoyi.platform.app.zblog.v3_books.book_book.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 书籍信息对象 book_book
 *
 * @author mylady
 * @date 2023-10-07
 */
public class BookBook extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * UUID
     */
    @Excel(name = "UUID")
    private String uuid;

    /**
     * 书籍名称
     */
    @Excel(name = "书籍名称")
    private String bookName;

    /**
     * 书籍封面图
     */
    @Excel(name = "书籍封面图")
    private String bookCover;

    /**
     * 作者
     */
    @Excel(name = "作者")
    private String bAuthor;

    /**
     * 出版社
     */
    @Excel(name = "出版社")
    private String bPublisher;

    /**
     * 出版时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "出版时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date bPublicData;

    /**
     * 翻译人
     */
    @Excel(name = "翻译人")
    private String bTranslate;

    /**
     * 开始阅读时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "开始阅读时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date bReadStartTime;

    /**
     * 阅读完毕时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "阅读完毕时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date bReadEndTime;

    /**
     * 是否读完
     */
    @Excel(name = "是否读完")
    private Integer bIsOver;

    /**
     * 编辑器模式.1md,2富文本
     */
    @Excel(name = "编辑器模式.1md,2富文本")
    private Long editorMode;

    /**
     * 介绍内容_含html格式
     */
    @Excel(name = "介绍内容_含html格式")
    private String content;

    /**
     * 介绍内容_预览_纯文本
     */
    @Excel(name = "介绍内容_预览_纯文本")
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
     * 子类的排序字段
     */
    @Excel(name = "子类的排序字段")
    private String sortField;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 当前分类是否允许评论
     */
    @Excel(name = "当前分类是否允许评论")
    private Integer isComment;

    /**
     * 置顶
     */
    @Excel(name = "置顶")
    private Integer isTop;

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

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setbAuthor(String bAuthor) {
        this.bAuthor = bAuthor;
    }

    public String getbAuthor() {
        return bAuthor;
    }

    public void setbPublisher(String bPublisher) {
        this.bPublisher = bPublisher;
    }

    public String getbPublisher() {
        return bPublisher;
    }

    public void setbPublicData(Date bPublicData) {
        this.bPublicData = bPublicData;
    }

    public Date getbPublicData() {
        return bPublicData;
    }

    public void setbTranslate(String bTranslate) {
        this.bTranslate = bTranslate;
    }

    public String getbTranslate() {
        return bTranslate;
    }

    public void setbReadStartTime(Date bReadStartTime) {
        this.bReadStartTime = bReadStartTime;
    }

    public Date getbReadStartTime() {
        return bReadStartTime;
    }

    public void setbReadEndTime(Date bReadEndTime) {
        this.bReadEndTime = bReadEndTime;
    }

    public Date getbReadEndTime() {
        return bReadEndTime;
    }

    public void setbIsOver(Integer bIsOver) {
        this.bIsOver = bIsOver;
    }

    public Integer getbIsOver() {
        return bIsOver;
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

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsTop() {
        return isTop;
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
                .append("bookName", getBookName())
                .append("bookCover", getBookCover())
                .append("bAuthor", getbAuthor())
                .append("bPublisher", getbPublisher())
                .append("bPublicData", getbPublicData())
                .append("bTranslate", getbTranslate())
                .append("bReadStartTime", getbReadStartTime())
                .append("bReadEndTime", getbReadEndTime())
                .append("bIsOver", getbIsOver())
                .append("editorMode", getEditorMode())
                .append("content", getContent())
                .append("preContent", getPreContent())
                .append("visitor", getVisitor())
                .append("role", getRole())
                .append("roleValue", getRoleValue())
                .append("sortField", getSortField())
                .append("sort", getSort())
                .append("isComment", getIsComment())
                .append("isTop", getIsTop())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
