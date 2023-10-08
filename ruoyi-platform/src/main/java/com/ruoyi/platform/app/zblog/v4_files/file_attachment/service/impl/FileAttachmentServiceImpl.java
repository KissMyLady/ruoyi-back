package com.ruoyi.platform.app.zblog.v4_files.file_attachment.service.impl;

import java.util.List;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.domain.FileAttachment;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.mapper.FileAttachmentMapper;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.service.IFileAttachmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * file_attachmentService业务层处理
 *
 * @author mylady
 * @date 2023-10-07
 */
@Service
public class FileAttachmentServiceImpl implements IFileAttachmentService {

    private static final Logger logger = LoggerFactory.getLogger(FileAttachmentServiceImpl.class);

    @Autowired
    private FileAttachmentMapper fileAttachmentMapper;

    /**
     * 查询file_attachment
     *
     * @param id file_attachment主键
     * @return file_attachment
     */
    @Override
    public FileAttachment selectFileAttachmentById(Long id) {
        return fileAttachmentMapper.selectFileAttachmentById(id);
    }

    /**
     * 查询file_attachment列表
     *
     * @param fileAttachment file_attachment
     * @return file_attachment
     */
    @Override
    public List<FileAttachment> selectFileAttachmentList(FileAttachment fileAttachment) {
        return fileAttachmentMapper.selectFileAttachmentList(fileAttachment);
    }

    /**
     * 新增file_attachment
     *
     * @param fileAttachment file_attachment
     * @return 结果
     */
    @Override
    public int insertFileAttachment(FileAttachment fileAttachment) {
        fileAttachment.setCreateTime(DateUtils.getNowDate());
        return fileAttachmentMapper.insertFileAttachment(fileAttachment);
    }

    /**
     * 修改file_attachment
     *
     * @param fileAttachment file_attachment
     * @return 结果
     */
    @Override
    public int updateFileAttachment(FileAttachment fileAttachment) {
        fileAttachment.setUpdateTime(DateUtils.getNowDate());
        return fileAttachmentMapper.updateFileAttachment(fileAttachment);
    }

    /**
     * 批量删除file_attachment
     *
     * @param ids 需要删除的file_attachment主键
     * @return 结果
     */
    @Override
    public int deleteFileAttachmentByIds(Long[] ids) {
        return fileAttachmentMapper.deleteFileAttachmentByIds(ids);
    }

    /**
     * 删除file_attachment信息
     *
     * @param id file_attachment主键
     * @return 结果
     */
    @Override
    public int deleteFileAttachmentById(Long id) {
        return fileAttachmentMapper.deleteFileAttachmentById(id);
    }
}
