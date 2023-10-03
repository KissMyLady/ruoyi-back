package com.ruoyi.platform.app.userAuth.sys_table_authority_row.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 数据权限对象 sys_table_authority_row
 *
 * @author mylady
 * @date 2023-10-03
 */
public class SysTableAuthorityRow extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Excel(name = "主键")
    private Long id;

    /**
     * 表名称
     */
    @Excel(name = "表名称")
    private String tableName;

    /**
     * 主键id名称
     */
    @Excel(name = "主键id名称")
    private String dbIdName;

    /**
     * 主键id号
     */
    @Excel(name = "主键id号")
    private String dbId;

    /**
     * 部门id
     */
    @Excel(name = "部门id")
    private String needDeptId;

    /**
     * 仅自己可见
     */
    @Excel(name = "仅自己可见")
    private Integer isPrivate;

    /**
     * 开放
     */
    @Excel(name = "开放")
    private Integer isPublic;

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

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setDbIdName(String dbIdName) {
        this.dbIdName = dbIdName;
    }

    public String getDbIdName() {
        return dbIdName;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public String getDbId() {
        return dbId;
    }

    public void setNeedDeptId(String needDeptId) {
        this.needDeptId = needDeptId;
    }

    public String getNeedDeptId() {
        return needDeptId;
    }

    public void setIsPrivate(Integer isPrivate) {
        this.isPrivate = isPrivate;
    }

    public Integer getIsPrivate() {
        return isPrivate;
    }

    public void setIsPublic(Integer isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getIsPublic() {
        return isPublic;
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
                .append("tableName", getTableName())
                .append("dbIdName", getDbIdName())
                .append("dbId", getDbId())
                .append("needDeptId", getNeedDeptId())
                .append("isPrivate", getIsPrivate())
                .append("isPublic", getIsPublic())
                .append("createBy", getCreateBy())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
