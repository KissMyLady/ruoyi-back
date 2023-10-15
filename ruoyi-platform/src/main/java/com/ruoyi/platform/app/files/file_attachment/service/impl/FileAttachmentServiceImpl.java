package com.ruoyi.platform.app.files.file_attachment.service.impl;

import cn.hutool.core.util.ObjectUtil;

import java.util.Map;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.EncryptDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.files.file_attachment.mapper.FileAttachmentMapper;
import com.ruoyi.platform.app.files.file_attachment.domain.FileAttachment;
import com.ruoyi.platform.app.files.file_attachment.service.IFileAttachmentService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 附件Service业务层处理
 *
 * @author mylady
 * @date 2023-10-15
 */
@Service
public class FileAttachmentServiceImpl implements IFileAttachmentService {

    private static final Logger logger = LoggerFactory.getLogger(FileAttachmentServiceImpl.class);

    @Autowired
    private FileAttachmentMapper fileAttachmentMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectFileAttachmentById(Long id) {
        return fileAttachmentMapper.selectFileAttachmentById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<FileAttachment> selectFileAttachmentList(FileAttachment dto) {
        return fileAttachmentMapper.selectFileAttachmentList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertFileAttachment(FileAttachment fileAttachment) {
        fileAttachment.setCreateTime(DateUtils.getNowDate());
        return fileAttachmentMapper.insertFileAttachment(fileAttachment);
    }

    /**
     * 修改
     */
    @Override
    public int updateFileAttachment(FileAttachment fileAttachment) {
        fileAttachment.setUpdateTime(DateUtils.getNowDate());
        return fileAttachmentMapper.updateFileAttachment(fileAttachment);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteFileAttachmentByIds(Long[] ids) {
        return fileAttachmentMapper.deleteFileAttachmentByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleteFileAttachmentById(Long id) {
        return fileAttachmentMapper.deleteFileAttachmentById(id);
    }
}
