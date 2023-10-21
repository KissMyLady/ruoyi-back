package com.ruoyi.platform.app.msg.tb_msg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息对象 tb_msg
 *
 * @author mylady
 * @date 2023-10-21
 */
public class tb_msg extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 消息UUID
     */
    @Excel(name = "消息UUID")
    private String msgUuid;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private String userId;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 消息级别代号(字典)
     */
    @Excel(name = "消息级别代号(字典)")
    private String lvCode;

    /**
     * 消息发送人代号(字典)
     */
    @Excel(name = "消息发送人代号(字典)")
    private String sendCode;

    /**
     * 消息类型代号(字典)
     */
    @Excel(name = "消息类型代号(字典)")
    private String typeCode;

    /**
     * 是否已读
     */
    @Excel(name = "是否已读")
    private Integer isRead;

    /**
     * 是否已发送
     */
    @Excel(name = "是否已发送")
    private Integer isSend;

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

    public void setMsgUuid(String msgUuid) {
        this.msgUuid = msgUuid;
    }

    public String getMsgUuid() {
        return msgUuid;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setLvCode(String lvCode) {
        this.lvCode = lvCode;
    }

    public String getLvCode() {
        return lvCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    public String getSendCode() {
        return sendCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public Integer getIsSend() {
        return isSend;
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
                .append("id", getId())
                .append("msgUuid", getMsgUuid())
                .append("userId", getUserId())
                .append("title", getTitle())
                .append("content", getContent())
                .append("lvCode", getLvCode())
                .append("sendCode", getSendCode())
                .append("typeCode", getTypeCode())
                .append("isRead", getIsRead())
                .append("isSend", getIsSend())
                .append("note", getNote())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
