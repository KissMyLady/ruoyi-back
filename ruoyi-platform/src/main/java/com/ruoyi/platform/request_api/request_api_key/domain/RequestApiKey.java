package com.ruoyi.platform.request_api.request_api_key.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * api请求-key对象 request_api_key
 *
 * @author mylady
 * @date 2023-09-26
 */
public class RequestApiKey extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 关联用户表
     */
    @Excel(name = "关联用户表")
    private String userId;

    /**
     * 分配的key
     */
    @Excel(name = "分配的key")
    private String respKey;

    /**
     * 请求参数
     */
    @Excel(name = "请求参数")
    private String reqParams;

    /**
     * key过期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "key过期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date keyOverdue;

    /**
     * 发送总数量限制
     */
    @Excel(name = "发送总数量限制")
    private Long keySmsCount;

    /**
     * 当前key已经发送数
     */
    @Excel(name = "当前key已经发送数")
    private Long sendCount;

    /**
     * 允许的ip地址
     */
    @Excel(name = "允许的ip地址")
    private String ipAllowList;

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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setRespKey(String respKey) {
        this.respKey = respKey;
    }

    public String getRespKey() {
        return respKey;
    }

    public void setReqParams(String reqParams) {
        this.reqParams = reqParams;
    }

    public String getReqParams() {
        return reqParams;
    }

    public void setKeyOverdue(Date keyOverdue) {
        this.keyOverdue = keyOverdue;
    }

    public Date getKeyOverdue() {
        return keyOverdue;
    }

    public void setKeySmsCount(Long keySmsCount) {
        this.keySmsCount = keySmsCount;
    }

    public Long getKeySmsCount() {
        return keySmsCount;
    }

    public void setSendCount(Long sendCount) {
        this.sendCount = sendCount;
    }

    public Long getSendCount() {
        return sendCount;
    }

    public void setIpAllowList(String ipAllowList) {
        this.ipAllowList = ipAllowList;
    }

    public String getIpAllowList() {
        return ipAllowList;
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
                .append("respKey", getRespKey())
                .append("reqParams", getReqParams())
                .append("keyOverdue", getKeyOverdue())
                .append("keySmsCount", getKeySmsCount())
                .append("sendCount", getSendCount())
                .append("ipAllowList", getIpAllowList())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
