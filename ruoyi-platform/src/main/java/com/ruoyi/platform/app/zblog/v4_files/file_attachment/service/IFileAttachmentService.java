package com.ruoyi.platform.app.zblog.v4_files.file_attachment.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.v4_files.file_attachment.domain.FileAttachment;

/**
 * file_attachmentService接口
 *
 * @author mylady
 * @date 2023-10-07
 */
public interface IFileAttachmentService {
    /**
     * 查询file_attachment
     *
     * @param id file_attachment主键
     * @return file_attachment
     */
    public FileAttachment selectFileAttachmentById(Long id);

    /**
     * 查询file_attachment列表
     *
     * @param fileAttachment file_attachment
     * @return file_attachment集合
     */
    public List<FileAttachment> selectFileAttachmentList(FileAttachment fileAttachment);

    /**
     * 新增file_attachment
     *
     * @param fileAttachment file_attachment
     * @return 结果
     */
    public int insertFileAttachment(FileAttachment fileAttachment);

    /**
     * 修改file_attachment
     *
     * @param fileAttachment file_attachment
     * @return 结果
     */
    public int updateFileAttachment(FileAttachment fileAttachment);

    /**
     * 批量删除file_attachment
     *
     * @param ids 需要删除的file_attachment主键集合
     * @return 结果
     */
    public int deleteFileAttachmentByIds(Long[] ids);

    /**
     * 删除file_attachment信息
     *
     * @param id file_attachment主键
     * @return 结果
     */
    public int deleteFileAttachmentById(Long id);
}
