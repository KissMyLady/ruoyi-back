package com.ruoyi.platform.app.zblog.blog.blog_project.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 博客文集对象 blog_project
 *
 * @author mylady
 * @date 2023-10-24
 */
public class BlogProject extends BaseEntity {

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
     * 文集类型(博客,文档,等)/实验字段
     */
    @Excel(name = "文集类型(博客,文档,等)/实验字段")
    private String blogType;

    /**
     * 文集名称
     */
    @Excel(name = "文集名称")
    private String name;

    /**
     * 介绍
     */
    @Excel(name = "介绍")
    private String intro;

    /**
     * 图标
     */
    @Excel(name = "图标")
    private String icon;

    /**
     * 封面图
     */
    @Excel(name = "封面图")
    private String coverImg;

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
     * 水印
     */
    @Excel(name = "水印")
    private Integer isWatermark;

    /**
     * 水印类型
     */
    @Excel(name = "水印类型")
    private Long watermarkType;

    /**
     * 水印值
     */
    @Excel(name = "水印值")
    private String watermarkValue;

    /**
     * 是否置顶
     */
    @Excel(name = "是否置顶")
    private Integer isTop;

    /**
     * 项目浏览次数
     */
    @Excel(name = "项目浏览次数")
    private Long visitor;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Long sort;

    /**
     * 排序方式(sql字段)
     */
    @Excel(name = "排序方式(sql字段)")
    private String sortField;

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

    public void setBlogType(String blogType) {
        this.blogType = blogType;
    }

    public String getBlogType() {
        return blogType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIntro() {
        return intro;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getCoverImg() {
        return coverImg;
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
                .append("blogType", getBlogType())
                .append("name", getName())
                .append("intro", getIntro())
                .append("icon", getIcon())
                .append("coverImg", getCoverImg())
                .append("authorityCode", getAuthorityCode())
                .append("authorityValue", getAuthorityValue())
                .append("isWatermark", getIsWatermark())
                .append("watermarkType", getWatermarkType())
                .append("watermarkValue", getWatermarkValue())
                .append("isTop", getIsTop())
                .append("visitor", getVisitor())
                .append("sort", getSort())
                .append("sortField", getSortField())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
