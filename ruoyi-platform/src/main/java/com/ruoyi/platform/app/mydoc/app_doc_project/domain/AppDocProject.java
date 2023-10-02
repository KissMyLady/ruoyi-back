package com.ruoyi.platform.app.mydoc.app_doc_project.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文集对象 app_doc_project
 *
 * @author mylady
 * @date 2023-10-02
 */
public class AppDocProject extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Excel(name = "主键")
    private Long id;

    /**
     * 创建用户id
     */
    @Excel(name = "创建用户id")
    private Long createUserId;

    /**
     * 角色权限
     */
    @Excel(name = "角色权限")
    private Long role;

    /**
     * 角色权限值
     */
    @Excel(name = "角色权限值")
    private String roleValue;

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
    private Long visitor;

    /**
     * 逻辑删除
     */
    @Excel(name = "逻辑删除")
    private Integer isDelete;

    /**
     * 排序方式(sql字段)
     */
    @Excel(name = "排序方式(sql字段)")
    private String sortField;

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

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() {
        return createUserId;
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

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortField() {
        return sortField;
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
                .append("role", getRole())
                .append("roleValue", getRoleValue())
                .append("name", getName())
                .append("intro", getIntro())
                .append("icon", getIcon())
                .append("isWatermark", getIsWatermark())
                .append("watermarkType", getWatermarkType())
                .append("watermarkValue", getWatermarkValue())
                .append("isTop", getIsTop())
                .append("visitor", getVisitor())
                .append("isDelete", getIsDelete())
                .append("sortField", getSortField())
                .append("createTime", getCreateTime())
                .append("modifyTime", getModifyTime())
                .toString();
    }

}
