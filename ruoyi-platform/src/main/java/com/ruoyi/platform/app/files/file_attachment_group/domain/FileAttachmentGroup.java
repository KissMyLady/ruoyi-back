package com.ruoyi.platform.app.files.file_attachment_group.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 附件分组对象 file_attachment_group
 *
 * @author mylady
 * @date 2023-10-14
 */
public class FileAttachmentGroup extends BaseEntity {

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
     * 分组id
     */
    @Excel(name = "分组id")
    private Long groupId;

    /**
     * 组名
     */
    @Excel(name = "组名")
    private String groupName;

    /**
     * 备注
     */
    @Excel(name = "备注")
    private String note;

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

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
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
                .append("id" , getId())
                .append("userId" , getUserId())
                .append("groupId" , getGroupId())
                .append("groupName" , getGroupName())
                .append("note" , getNote())
                .append("isDelete" , getIsDelete())
                .append("createTime" , getCreateTime())
                .append("updateTime" , getUpdateTime())
                .toString();
    }

}
