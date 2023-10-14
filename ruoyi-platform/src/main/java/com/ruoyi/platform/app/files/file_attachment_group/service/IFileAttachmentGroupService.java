package com.ruoyi.platform.app.files.file_attachment_group.service;

import java.util.List;

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
     * 查询附件分组
     *
     * @param id 附件分组主键
     * @return 附件分组
     */
    public FileAttachmentGroup selectFileAttachmentGroupById(Long id);

    /**
     * 查询附件分组列表
     *
     * @param fileAttachmentGroup 附件分组
     * @return 附件分组集合
     */
    public List<FileAttachmentGroup> selectFileAttachmentGroupList(FileAttachmentGroup fileAttachmentGroup);

    // 查询列表, SQL分页查询
    TableDataInfo queryFileAttachmentGroupList_BySQL(FileAttachmentGroup fileAttachmentGroup);

    /**
     * 新增附件分组
     *
     * @param fileAttachmentGroup 附件分组
     * @return 结果
     */
    public int insertFileAttachmentGroup(FileAttachmentGroup fileAttachmentGroup);

    /**
     * 修改附件分组
     *
     * @param fileAttachmentGroup 附件分组
     * @return 结果
     */
    public int updateFileAttachmentGroup(FileAttachmentGroup fileAttachmentGroup);

    /**
     * 批量删除附件分组
     *
     * @param ids 需要删除的附件分组主键集合
     * @return 结果
     */
    public int deleteFileAttachmentGroupByIds(Long[] ids);

    /**
     * 删除附件分组信息
     *
     * @param id 附件分组主键
     * @return 结果
     */
    public int deleteFileAttachmentGroupById(Long id);
}
