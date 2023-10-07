package com.ruoyi.platform.app.zblog.v4_files.file_image.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 素材图片对象 file_image
 *
 * @author mylady
 * @date 2023-10-07
 */
public class FileImage extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 创建用户id */
        @Excel(name = "创建用户id")
    private Long userId;

    /** 图片分组 */
        @Excel(name = "图片分组")
    private Long groupId;

    /** 名称,描述 */
        @Excel(name = "名称,描述")
    private String title;

    /** 图片名称 */
        @Excel(name = "图片名称")
    private String fileName;

    /** 图片路径 */
        @Excel(name = "图片路径")
    private String filePath;

    /** md5校验值 */
        @Excel(name = "md5校验值")
    private String md5;

    /** 图片后缀 */
        @Excel(name = "图片后缀")
    private String fileSuffix;

    /** 逻辑删除 */
        @Excel(name = "逻辑删除")
    private Integer isDelete;

    public void setId(Long id){
        this.id = id;
    }

    public Long getId(){
        return id;
    }
    public void setUserId(Long userId){
        this.userId = userId;
    }

    public Long getUserId(){
        return userId;
    }
    public void setGroupId(Long groupId){
        this.groupId = groupId;
    }

    public Long getGroupId(){
        return groupId;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return title;
    }
    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

    public String getFilePath(){
        return filePath;
    }
    public void setMd5(String md5){
        this.md5 = md5;
    }

    public String getMd5(){
        return md5;
    }
    public void setFileSuffix(String fileSuffix){
        this.fileSuffix = fileSuffix;
    }

    public String getFileSuffix(){
        return fileSuffix;
    }
    public void setIsDelete(Integer isDelete){
        this.isDelete = isDelete;
    }

    public Integer getIsDelete(){
        return isDelete;
    }

        @Override
        public String toString() {
            return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                    .append("id", getId())
                    .append("userId", getUserId())
                    .append("groupId", getGroupId())
                    .append("title", getTitle())
                    .append("fileName", getFileName())
                    .append("filePath", getFilePath())
                    .append("md5", getMd5())
                    .append("fileSuffix", getFileSuffix())
                    .append("isDelete", getIsDelete())
                    .append("createTime", getCreateTime())
                    .append("updateTime", getUpdateTime())
                .toString();
        }

}
