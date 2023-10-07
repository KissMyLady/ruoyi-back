package com.ruoyi.platform.app.zblog.v4_files.file_attachment.mapper;

import java.util.List;

import com.ruoyi.platform.app.zblog.v4_files.file_attachment.domain.FileAttachment;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
 * file_attachmentMapper接口
 *
 * @author mylady
 * @date 2023-10-07
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface FileAttachmentMapper {
    /**
     * 查询file_attachment
     *
     * @param id file_attachment主键
     * @return file_attachment
     */
    FileAttachment selectFileAttachmentById(Long id);

    /**
     * 查询file_attachment列表
     *
     * @param fileAttachment file_attachment
     * @return file_attachment集合
     */
    List<FileAttachment> selectFileAttachmentList(FileAttachment fileAttachment);

    /**
     * 新增file_attachment
     *
     * @param fileAttachment file_attachment
     * @return 结果
     */
    int insertFileAttachment(FileAttachment fileAttachment);

    /**
     * 修改file_attachment
     *
     * @param fileAttachment file_attachment
     * @return 结果
     */
    int updateFileAttachment(FileAttachment fileAttachment);

    /**
     * 删除file_attachment
     *
     * @param id file_attachment主键
     * @return 结果
     */
    int deleteFileAttachmentById(Long id);

    /**
     * 批量删除file_attachment
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFileAttachmentByIds(Long[] ids);
}
