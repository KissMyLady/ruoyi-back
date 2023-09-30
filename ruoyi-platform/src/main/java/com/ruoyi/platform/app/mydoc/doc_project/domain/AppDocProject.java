package com.ruoyi.platform.app.mydoc.doc_project.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * doc_project对象 app_doc_project
 *
 * @author mylady
 * @date 2023-09-30
 */
public class AppDocProject extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

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
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Date modifyTime;

    /**
     * 创建人
     */
    @Excel(name = "创建人")
    private Long createUserId;

    /**
     * 文集权限
     */
    @Excel(name = "文集权限")
    private Long role;

    /**
     * 文集权限值
     */
    @Excel(name = "文集权限值")
    private String roleValue;

    /**
     * 文集图标
     */
    @Excel(name = "文集图标")
    private String icon;

    /**
     * 水印状态
     */
    @Excel(name = "水印状态")
    private Integer isWatermark;

    /**
     * 水印类型
     */
    @Excel(name = "水印类型")
    private Long watermarkType;

    /**
     * 水印内容
     */
    @Excel(name = "水印内容")
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

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getIntro() {
        return intro;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() {
        return modifyTime;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("intro", getIntro())
                .append("createTime", getCreateTime())
                .append("modifyTime", getModifyTime())
                .append("createUserId", getCreateUserId())
                .append("role", getRole())
                .append("roleValue", getRoleValue())
                .append("icon", getIcon())
                .append("isWatermark", getIsWatermark())
                .append("watermarkType", getWatermarkType())
                .append("watermarkValue", getWatermarkValue())
                .append("isTop", getIsTop())
                .append("visitor", getVisitor())
                .append("isDelete", getIsDelete())
                .append("sortField", getSortField())
                .toString();
    }

}
