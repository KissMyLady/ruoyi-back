package com.ruoyi.platform.app.files.file_attachment_group.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.files.file_attachment_group.domain.FileAttachmentGroup;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 附件分组Mapper接口
 *
 * @author mylady
 * @date 2023-10-14
 */
//@DataSource(value = DataSourceType.MASTER)
public interface FileAttachmentGroupMapper {
    /**
     * 查询附件分组
     *
     * @param id 附件分组主键
     * @return 附件分组
     */
    Map<String, Object> selectFileAttachmentGroupById(Long id);

    /**
     * 查询附件分组列表
     *
     * @param dto 附件分组
     * @return 附件分组集合
     */
    List<FileAttachmentGroup> selectFileAttachmentGroupList(FileAttachmentGroup dto);

    // 查询列表, 通过sql
    List<Map<String, Object>> queryFileAttachmentGroupList_BySQL(FileAttachmentGroup dto);

    //查询列表 总条数
    int queryFileAttachmentGroupList_count(FileAttachmentGroup dto);

    /**
     * 新增附件分组
     *
     * @param dto 附件分组
     * @return 结果
     */
    int insertFileAttachmentGroup(FileAttachmentGroup dto);

    /**
     * 修改附件分组
     *
     * @param dto 附件分组
     * @return 结果
     */
    int updateFileAttachmentGroup(FileAttachmentGroup dto);

    /**
     * 删除附件分组
     *
     * @param id 附件分组主键
     * @return 结果
     */
    int deleteFileAttachmentGroupById(Long id);

    /**
     * 批量删除附件分组
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFileAttachmentGroupByIds(Long[] ids);
}
