package com.ruoyi.platform.llm_claude_key.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 语言模型,api,claude连接池对象 llm_claude_key
 *
 * @author mylady
 * @date 2023-09-23
 */
public class LlmClaudeKey extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 类别名称
     */
    @Excel(name = "类别名称")
    private String apiType;

    /**
     * 备注信息
     */
    @Excel(name = "备注信息")
    private String info;

    /**
     * org_uuid
     */
    @Excel(name = "org_uuid")
    private String orgUuid;

    /**
     * sessionKey
     */
    @Excel(name = "sessionKey")
    private String sessionKey;

    /**
     * conversation_uuid
     */
    @Excel(name = "conversation_uuid")
    private String conversationUuid;

    /**
     * 创建人
     */
    @Excel(name = "创建人")
    private String createUser;

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

    public void setApiType(String apiType) {
        this.apiType = apiType;
    }

    public String getApiType() {
        return apiType;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setOrgUuid(String orgUuid) {
        this.orgUuid = orgUuid;
    }

    public String getOrgUuid() {
        return orgUuid;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setConversationUuid(String conversationUuid) {
        this.conversationUuid = conversationUuid;
    }

    public String getConversationUuid() {
        return conversationUuid;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateUser() {
        return createUser;
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
                .append("apiType", getApiType())
                .append("info", getInfo())
                .append("orgUuid", getOrgUuid())
                .append("sessionKey", getSessionKey())
                .append("conversationUuid", getConversationUuid())
                .append("createUser", getCreateUser())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
