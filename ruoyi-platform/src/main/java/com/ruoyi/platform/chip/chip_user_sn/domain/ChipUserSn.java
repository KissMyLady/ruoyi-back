package com.ruoyi.platform.chip.chip_user_sn.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户芯片-序列号对象 chip_user_sn
 *
 * @author mylady
 * @date 2023-09-25
 */
public class ChipUserSn extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private Long id;

    @Excel(name = "关联用户ID")
    private Long userId;

    @Excel(name = "手机")
    private String phone;

    @Excel(name = "昵称")
    private String nickname;

    @Excel(name = "sn序列号")
    private String sn;

    @Excel(name = "产品缩略图")
    private String thumbnail;

    @Excel(name = "状态")
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expiredTime;

    @Excel(name = "删除标记")
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

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSn() {
        return sn;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    public Date getExpiredTime() {
        return expiredTime;
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
                .append("phone", getPhone())
                .append("nickname", getNickname())
                .append("sn", getSn())
                .append("thumbnail", getThumbnail())
                .append("status", getStatus())
                .append("expiredTime", getExpiredTime())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
