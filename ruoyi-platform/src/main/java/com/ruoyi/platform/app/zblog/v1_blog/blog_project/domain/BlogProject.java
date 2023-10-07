package com.ruoyi.platform.app.zblog.v1_blog.blog_project.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章分类对象 blog_project
 *
 * @author mylady
 * @date 2023-10-07
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
    private Integer createUserId;

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
     * 浏览次数
     */
    @Excel(name = "浏览次数")
    private Integer visitor;

    /**
     * 排序
     */
    @Excel(name = "排序")
    private Integer sort;

    /**
     * 子类排序方式(sql字段)
     */
    @Excel(name = "子类排序方式(sql字段)")
    private String sortField;

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

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getCreateUserId() {
        return createUserId;
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

    public void setVisitor(Integer visitor) {
        this.visitor = visitor;
    }

    public Integer getVisitor() {
        return visitor;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getSort() {
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
                .append("name", getName())
                .append("intro", getIntro())
                .append("icon", getIcon())
                .append("coverImg", getCoverImg())
                .append("role", getRole())
                .append("roleValue", getRoleValue())
                .append("isWatermark", getIsWatermark())
                .append("watermarkType", getWatermarkType())
                .append("watermarkValue", getWatermarkValue())
                .append("isTop", getIsTop())
                .append("visitor", getVisitor())
                .append("sort", getSort())
                .append("sortField", getSortField())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("modifyTime", getModifyTime())
                .toString();
    }

}
