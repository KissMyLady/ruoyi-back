package com.ruoyi.platform.app.zblog.do_spu.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * do_spu对象 do_spu
 *
 * @author mylady
 * @date 2023-09-30
 */
public class DoSpu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    private Long id;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isDelete;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isSuperuser;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer isLoginView;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String simpleName;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String simpleText;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String detail;

    /**
     * $column.columnComment
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String imgUpload;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsSuperuser(Integer isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    public Integer getIsSuperuser() {
        return isSuperuser;
    }

    public void setIsLoginView(Integer isLoginView) {
        this.isLoginView = isLoginView;
    }

    public Integer getIsLoginView() {
        return isLoginView;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleText(String simpleText) {
        this.simpleText = simpleText;
    }

    public String getSimpleText() {
        return simpleText;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDetail() {
        return detail;
    }

    public void setImgUpload(String imgUpload) {
        this.imgUpload = imgUpload;
    }

    public String getImgUpload() {
        return imgUpload;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDelete", getIsDelete())
                .append("isSuperuser", getIsSuperuser())
                .append("isLoginView", getIsLoginView())
                .append("simpleName", getSimpleName())
                .append("simpleText", getSimpleText())
                .append("detail", getDetail())
                .append("imgUpload", getImgUpload())
                .toString();
    }

}
