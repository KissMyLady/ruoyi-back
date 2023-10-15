package com.ruoyi.platform.app.files.file_attachment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 附件对象 file_attachment
 *
 * @author mylady
 * @date 2023-10-15
 */
public class FileAttachment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户ID
     */
    @Excel(name = "用户ID")
    private Long userId;

    /**
     * 分组id
     */
    @Excel(name = "分组id")
    private Long groupId;

    /**
     * 名称,描述
     */
    @Excel(name = "名称,描述")
    private String title;

    /**
     * 文件路径
     */
    @Excel(name = "文件路径")
    private String filePath;

    /**
     * 文件名
     */
    @Excel(name = "文件名")
    private String fileName;

    /**
     * 文件大小
     */
    @Excel(name = "文件大小")
    private String fileSize;

    /**
     * 上传方式
     */
    @Excel(name = "上传方式")
    private String upMethod;

    /**
     * 文件后缀
     */
    @Excel(name = "文件后缀")
    private String fileSuffix;

    /**
     * url链接
     */
    @Excel(name = "url链接")
    private String url;

    /**
     * 在存储地址的真实绝对路径
     */
    @Excel(name = "在存储地址的真实绝对路径")
    private String absPath;

    /**
     * md5校验值
     */
    @Excel(name = "md5校验值")
    private String md5;

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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setUpMethod(String upMethod) {
        this.upMethod = upMethod;
    }

    public String getUpMethod() {
        return upMethod;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setAbsPath(String absPath) {
        this.absPath = absPath;
    }

    public String getAbsPath() {
        return absPath;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getMd5() {
        return md5;
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
                .append("groupId", getGroupId())
                .append("title", getTitle())
                .append("filePath", getFilePath())
                .append("fileName", getFileName())
                .append("fileSize", getFileSize())
                .append("upMethod", getUpMethod())
                .append("fileSuffix", getFileSuffix())
                .append("url", getUrl())
                .append("absPath", getAbsPath())
                .append("md5", getMd5())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
