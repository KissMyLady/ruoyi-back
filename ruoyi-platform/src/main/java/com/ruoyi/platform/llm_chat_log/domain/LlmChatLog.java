package com.ruoyi.platform.llm_chat_log.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 语言模型聊天记录对象 llm_chat_log
 *
 * @author mylady
 * @date 2023-09-23
 */
public class LlmChatLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 聊天用户
     */
    @Excel(name = "聊天用户")
    private String user;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @Excel(name = "操作类别", readConverterExp = "0=其它,1=后台用户,2=手机端用户")
    private Long userDeviceType;

    /**
     * ip地址
     */
    @Excel(name = "ip地址")
    private String userIp;

    /**
     * 聊天用户地址
     */
    @Excel(name = "聊天用户地址")
    private String userAddress;

    /**
     * 请求头
     */
    @Excel(name = "请求头")
    private String userAgent;

    /**
     * 浏览器
     */
    @Excel(name = "浏览器")
    private String userBrowser;

    /**
     * 操作系统
     */
    @Excel(name = "操作系统")
    private String userSystem;

    /**
     * 角色名称
     */
    @Excel(name = "角色名称")
    private String roleName;

    /**
     * 当前聊天角色
     */
    @Excel(name = "当前聊天角色")
    private String currentRoleName;

    /**
     * 当前聊天语言模型
     */
    @Excel(name = "当前聊天语言模型")
    private String llm;

    /**
     * 输入内容
     */
    @Excel(name = "输入内容")
    private String prompt;

    /**
     * 输出内容
     */
    @Excel(name = "输出内容")
    private String response;

    /**
     * 计算耗时
     */
    @Excel(name = "计算耗时")
    private String consumeTime;

    /**
     * 当前聊天的历史内容
     */
    @Excel(name = "当前聊天的历史内容")
    private String history;

    /**
     * 操作提交的数据
     */
    @Excel(name = "操作提交的数据")
    private String reqParams;

    /**
     * 历史记录
     */
    @Excel(name = "历史记录")
    private Integer isDelete;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUserDeviceType(Long userDeviceType) {
        this.userDeviceType = userDeviceType;
    }

    public Long getUserDeviceType() {
        return userDeviceType;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserBrowser(String userBrowser) {
        this.userBrowser = userBrowser;
    }

    public String getUserBrowser() {
        return userBrowser;
    }

    public void setUserSystem(String userSystem) {
        this.userSystem = userSystem;
    }

    public String getUserSystem() {
        return userSystem;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setCurrentRoleName(String currentRoleName) {
        this.currentRoleName = currentRoleName;
    }

    public String getCurrentRoleName() {
        return currentRoleName;
    }

    public void setLlm(String llm) {
        this.llm = llm;
    }

    public String getLlm() {
        return llm;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setConsumeTime(String consumeTime) {
        this.consumeTime = consumeTime;
    }

    public String getConsumeTime() {
        return consumeTime;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setReqParams(String reqParams) {
        this.reqParams = reqParams;
    }

    public String getReqParams() {
        return reqParams;
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
                .append("user", getUser())
                .append("userDeviceType", getUserDeviceType())
                .append("userIp", getUserIp())
                .append("userAddress", getUserAddress())
                .append("userAgent", getUserAgent())
                .append("userBrowser", getUserBrowser())
                .append("userSystem", getUserSystem())
                .append("roleName", getRoleName())
                .append("currentRoleName", getCurrentRoleName())
                .append("llm", getLlm())
                .append("prompt", getPrompt())
                .append("response", getResponse())
                .append("consumeTime", getConsumeTime())
                .append("history", getHistory())
                .append("reqParams", getReqParams())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
