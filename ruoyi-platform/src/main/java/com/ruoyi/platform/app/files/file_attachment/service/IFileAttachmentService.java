package com.ruoyi.platform.app.files.file_attachment.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.files.file_attachment.domain.FileAttachment;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
/**
 * 附件Service接口
 *
 * @author mylady
 * @date 2023-10-15
 */
public interface IFileAttachmentService {
    /**
     * 查询详情
     */
    Map<String, Object> selectFileAttachmentById(Long id);

    /**
     * 查询列表
     */
    List<FileAttachment> selectFileAttachmentList(FileAttachment dto);

    /**
     * ++新增++
     */
    int insertFileAttachment(FileAttachment dto);

    /**
     * 修改
     */
    int updateFileAttachment(FileAttachment dto);

    /**
     * --批量删除--
     */
    int deleteFileAttachmentByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleteFileAttachmentById(Long id);

}
