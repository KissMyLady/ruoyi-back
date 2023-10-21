package com.ruoyi.platform.app.openApi.request_api_key_log.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * api请求记录对象 request_api_key_log
 *
 * @author mylady
 * @date 2023-10-21
 */
public class request_api_key_log extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 记录标题
     */
    @Excel(name = "记录标题")
    private String logTitle;

    /**
     * 操作IP
     */
    @Excel(name = "操作IP")
    private String reqIp;

    /**
     * IP地址
     */
    @Excel(name = "IP地址")
    private String reqAddress;

    /**
     * 请求头
     */
    @Excel(name = "请求头")
    private String reqAgent;

    /**
     * 浏览器
     */
    @Excel(name = "浏览器")
    private String reqBrowser;

    /**
     * 操作系统
     */
    @Excel(name = "操作系统")
    private String reqSystem;

    /**
     * 请求URI
     */
    @Excel(name = "请求URI")
    private String reqUrl;

    /**
     * 操作方式
     */
    @Excel(name = "操作方式")
    private String reqMethod;

    /**
     * 请求的key
     */
    @Excel(name = "请求的key")
    private String reqKey;

    /**
     * 操作提交的数据
     */
    @Excel(name = "操作提交的数据")
    private String reqParams;

    /**
     * 是否成功
     */
    @Excel(name = "是否成功")
    private Integer isSuccess;

    /**
     * 影响行数
     */
    @Excel(name = "影响行数")
    private String effectRows;

    /**
     * 执行时间
     */
    @Excel(name = "执行时间")
    private Long timeOut;

    /**
     * 异常信息
     */
    @Excel(name = "异常信息")
    private String exception;

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

    public void setLogTitle(String logTitle) {
        this.logTitle = logTitle;
    }

    public String getLogTitle() {
        return logTitle;
    }

    public void setReqIp(String reqIp) {
        this.reqIp = reqIp;
    }

    public String getReqIp() {
        return reqIp;
    }

    public void setReqAddress(String reqAddress) {
        this.reqAddress = reqAddress;
    }

    public String getReqAddress() {
        return reqAddress;
    }

    public void setReqAgent(String reqAgent) {
        this.reqAgent = reqAgent;
    }

    public String getReqAgent() {
        return reqAgent;
    }

    public void setReqBrowser(String reqBrowser) {
        this.reqBrowser = reqBrowser;
    }

    public String getReqBrowser() {
        return reqBrowser;
    }

    public void setReqSystem(String reqSystem) {
        this.reqSystem = reqSystem;
    }

    public String getReqSystem() {
        return reqSystem;
    }

    public void setReqUrl(String reqUrl) {
        this.reqUrl = reqUrl;
    }

    public String getReqUrl() {
        return reqUrl;
    }

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public void setReqKey(String reqKey) {
        this.reqKey = reqKey;
    }

    public String getReqKey() {
        return reqKey;
    }

    public void setReqParams(String reqParams) {
        this.reqParams = reqParams;
    }

    public String getReqParams() {
        return reqParams;
    }

    public void setIsSuccess(Integer isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getIsSuccess() {
        return isSuccess;
    }

    public void setEffectRows(String effectRows) {
        this.effectRows = effectRows;
    }

    public String getEffectRows() {
        return effectRows;
    }

    public void setTimeOut(Long timeOut) {
        this.timeOut = timeOut;
    }

    public Long getTimeOut() {
        return timeOut;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getException() {
        return exception;
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
                .append("logTitle", getLogTitle())
                .append("reqIp", getReqIp())
                .append("reqAddress", getReqAddress())
                .append("reqAgent", getReqAgent())
                .append("reqBrowser", getReqBrowser())
                .append("reqSystem", getReqSystem())
                .append("reqUrl", getReqUrl())
                .append("reqMethod", getReqMethod())
                .append("reqKey", getReqKey())
                .append("reqParams", getReqParams())
                .append("isSuccess", getIsSuccess())
                .append("effectRows", getEffectRows())
                .append("timeOut", getTimeOut())
                .append("exception", getException())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
