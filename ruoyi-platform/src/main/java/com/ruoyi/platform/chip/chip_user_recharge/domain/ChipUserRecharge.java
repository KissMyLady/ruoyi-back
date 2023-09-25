package com.ruoyi.platform.chip.chip_user_recharge.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户芯片-用户充值对象 chip_user_recharge
 *
 * @author mylady
 * @date 2023-09-25
 */
public class ChipUserRecharge extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户
     */
    @Excel(name = "用户")
    private Long userId;

    /**
     * 手机
     */
    @Excel(name = "手机")
    private String phone;

    /**
     * 充值金额
     */
    @Excel(name = "充值金额")
    private BigDecimal rechargeMoney;

    /**
     * 有效时间(单位:秒)
     */
    @Excel(name = "有效时间(单位:秒)")
    private String effectiveTime;

    /**
     * 充值时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "充值时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date rechargeTime;

    /**
     * 删除标记
     */
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

    public void setRechargeMoney(BigDecimal rechargeMoney) {
        this.rechargeMoney = rechargeMoney;
    }

    public BigDecimal getRechargeMoney() {
        return rechargeMoney;
    }

    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public String getEffectiveTime() {
        return effectiveTime;
    }

    public void setRechargeTime(Date rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public Date getRechargeTime() {
        return rechargeTime;
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
                .append("rechargeMoney", getRechargeMoney())
                .append("effectiveTime", getEffectiveTime())
                .append("rechargeTime", getRechargeTime())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
