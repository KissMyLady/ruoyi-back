package com.ruoyi.platform.app.zblog.do_sku.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * do_sku对象 do_sku
 *
 * @author mylady
 * @date 2023-10-02
 */
public class DoSku extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 删除标记
     */
    @Excel(name = "删除标记")
    private Integer isDelete;

    /**
     * 超级管理员可见
     */
    @Excel(name = "超级管理员可见")
    private Integer isSuperuser;

    /**
     * 超级管理员
     */
    @Excel(name = "超级管理员")
    private Integer isLoginView;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String blogTitle;

    /**
     * 作者
     */
    @Excel(name = "作者")
    private String blogAuth;

    /**
     * 摘要
     */
    @Excel(name = "摘要")
    private String blogSummary;

    /**
     * 静态文章封面图片
     */
    @Excel(name = "静态文章封面图片")
    private String imageStaticUrl;

    /**
     * tinymce
     */
    @Excel(name = "tinymce")
    private String comArticleTinymce;

    /**
     * markdown
     */
    @Excel(name = "markdown")
    private String comBody;

    /**
     * 静态的链接式文章
     */
    @Excel(name = "静态的链接式文章")
    private String articleStatic;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long indexNum;

    /**
     * 置顶
     */
    @Excel(name = "置顶")
    private Integer isTop;

    /**
     * 文章浏览量
     */
    @Excel(name = "文章浏览量")
    private Long seeCount;

    /**
     * 点赞数
     */
    @Excel(name = "点赞数")
    private Long likeCount;

    /**
     * 文章SPU分类
     */
    @Excel(name = "文章SPU分类")
    private Long forCategoryId;

    /**
     * 父Id
     */
    @Excel(name = "父Id")
    private Long pid;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 编辑器模式,1富文本,2md
     */
    @Excel(name = "编辑器模式,1富文本,2md")
    private String modifyModel;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsSuperuser(Integer isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public Integer getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsLoginView(Integer isLoginView) {
        this.isLoginView = isLoginView;
    }

    public Integer getIsLoginView() {
        return isLoginView;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogAuth(String blogAuth) {
        this.blogAuth = blogAuth;
    }

    public String getBlogAuth() {
        return blogAuth;
    }

    public void setBlogSummary(String blogSummary) {
        this.blogSummary = blogSummary;
    }

    public String getBlogSummary() {
        return blogSummary;
    }

    public void setImageStaticUrl(String imageStaticUrl) {
        this.imageStaticUrl = imageStaticUrl;
    }

    public String getImageStaticUrl() {
        return imageStaticUrl;
    }

    public void setComArticleTinymce(String comArticleTinymce) {
        this.comArticleTinymce = comArticleTinymce;
    }

    public String getComArticleTinymce() {
        return comArticleTinymce;
    }

    public void setComBody(String comBody) {
        this.comBody = comBody;
    }

    public String getComBody() {
        return comBody;
    }

    public void setArticleStatic(String articleStatic) {
        this.articleStatic = articleStatic;
    }

    public String getArticleStatic() {
        return articleStatic;
    }

    public void setIndexNum(Long indexNum) {
        this.indexNum = indexNum;
    }

    public Long getIndexNum() {
        return indexNum;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setSeeCount(Long seeCount) {
        this.seeCount = seeCount;
    }

    public Long getSeeCount() {
        return seeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setForCategoryId(Long forCategoryId) {
        this.forCategoryId = forCategoryId;
    }

    public Long getForCategoryId() {
        return forCategoryId;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getPid() {
        return pid;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getSort() {
        return sort;
    }

    public void setModifyModel(String modifyModel) {
        this.modifyModel = modifyModel;
    }

    public String getModifyModel() {
        return modifyModel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .append("isSuperuser", getIsSuperuser())
                .append("isLoginView", getIsLoginView())
                .append("blogTitle", getBlogTitle())
                .append("blogAuth", getBlogAuth())
                .append("blogSummary", getBlogSummary())
                .append("imageStaticUrl", getImageStaticUrl())
                .append("comArticleTinymce", getComArticleTinymce())
                .append("comBody", getComBody())
                .append("articleStatic", getArticleStatic())
                .append("indexNum", getIndexNum())
                .append("isTop", getIsTop())
                .append("seeCount", getSeeCount())
                .append("likeCount", getLikeCount())
                .append("forCategoryId", getForCategoryId())
                .append("pid", getPid())
                .append("sort", getSort())
                .append("modifyModel", getModifyModel())
                .toString();
    }

}
