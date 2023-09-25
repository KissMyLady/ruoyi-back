package com.ruoyi.platform.chip.chip_version.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 硬件版本对象 chip_version
 *
 * @author mylady
 * @date 2023-09-25
 */
public class ChipVersion extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 版本名称
     */
    @Excel(name = "版本名称")
    private String versionName;

    /**
     * 版本号
     */
    @Excel(name = "版本号")
    private String version;

    /**
     * url地址
     */
    @Excel(name = "url地址")
    private String url;

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

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
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
                .append("versionName", getVersionName())
                .append("version", getVersion())
                .append("url", getUrl())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
