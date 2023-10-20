package com.ruoyi.platform.app.files.file_image.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 素材图片对象 file_image
 *
 * @author mylady
 * @date 2023-10-20
 */
public class file_image extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 创建用户id
     */
    @Excel(name = "创建用户id")
    private Long userId;

    /**
     * 图片分组
     */
    @Excel(name = "图片分组")
    private Long groupId;

    /**
     * 名称,描述
     */
    @Excel(name = "名称,描述")
    private String title;

    /**
     * 图片名称
     */
    @Excel(name = "图片名称")
    private String fileName;

    /**
     * 图片路径
     */
    @Excel(name = "图片路径")
    private String filePath;

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

    @Excel(name = "url")
    private String url;

    @Excel(name = "绝对路径")
    private String absPath;

    /**
     * md5校验值
     */
    @Excel(name = "md5校验值")
    private String md5;

    /**
     * 图片后缀
     */
    @Excel(name = "图片后缀")
    private String fileSuffix;

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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
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

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getMd5() {
        return md5;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAbsPath() {
        return absPath;
    }

    public void setAbsPath(String absPath) {
        this.absPath = absPath;
    }


    @Override
    public String toString() {
        return "file_image{" +
                "id=" + id +
                ", userId=" + userId +
                ", groupId=" + groupId +
                ", title='" + title + '\'' +
                ", fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", upMethod='" + upMethod + '\'' +
                ", url='" + url + '\'' +
                ", absPath='" + absPath + '\'' +
                ", md5='" + md5 + '\'' +
                ", fileSuffix='" + fileSuffix + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
