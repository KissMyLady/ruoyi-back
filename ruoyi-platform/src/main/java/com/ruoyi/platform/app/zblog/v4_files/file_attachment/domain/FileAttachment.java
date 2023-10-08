package com.ruoyi.platform.app.zblog.v4_files.file_attachment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * file_attachment对象 file_attachment
 *
 * @author mylady
 * @date 2023-10-07
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
     * 名称,描述
     */
    @Excel(name = "名称,描述")
    private String title;

    /**
     * 文件路径
     */
    @Excel(name = "文件路径")
    private String filePath;

    @Excel(name = "上传方式")
    private String upMethod;

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
     * 文件后缀
     */
    @Excel(name = "文件后缀")
    private String fileSuffix;


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

    public String getUpMethod() {
        return upMethod;
    }

    public void setUpMethod(String upMethod) {
        this.upMethod = upMethod;
    }

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

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getFileSuffix() {
        return fileSuffix;
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
                .append("title", getTitle())
                .append("filePath", getFilePath())
                .append("fileName", getFileName())
                .append("fileSize", getFileSize())
                .append("fileSuffix", getFileSuffix())
                .append("md5", getMd5())
                .append("isDelete", getIsDelete())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .toString();
    }

}
