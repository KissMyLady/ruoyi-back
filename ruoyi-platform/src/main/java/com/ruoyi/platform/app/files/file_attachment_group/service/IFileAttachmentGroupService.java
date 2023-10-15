package com.ruoyi.platform.app.files.file_attachment_group.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.platform.app.files.file_attachment_group.domain.FileAttachmentGroup;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 附件分组Service接口
 *
 * @author mylady
 * @date 2023-10-14
 */
public interface IFileAttachmentGroupService {

    /**
     * 查询
     */
    Map<String, Object> selectFileAttachmentGroupById(Long id);

    /**
     * 查询列表
     */
    List<FileAttachmentGroup> selectFileAttachmentGroupList(FileAttachmentGroup fileAttachmentGroup);

    // 查询列表, SQL分页查询
    TableDataInfo queryFileAttachmentGroupList_BySQL(FileAttachmentGroup fileAttachmentGroup);

    /**
     * 新增
     */
    int insertFileAttachmentGroup(FileAttachmentGroup fileAttachmentGroup);

    /**
     * 修改
     */
    int updateFileAttachmentGroup(FileAttachmentGroup fileAttachmentGroup);

    /**
     * 批量删除
     */
    int deleteFileAttachmentGroupByIds(Long[] ids);

    /**
     * 删除
     */
    int deleteFileAttachmentGroupById(Long id);
}
