package com.ruoyi.platform.app.files.file_attachment.mapper;

import java.util.List;
import java.util.Map;
import com.ruoyi.platform.app.files.file_attachment.domain.FileAttachment;
import com.ruoyi.platform.app.files.file_attachment.domain.FileGroupDto;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 附件Mapper接口
 *
 * @author mylady
 * @date 2023-10-15
 */
//@DataSource(value = DataSourceType.MASTER)
public interface FileAttachmentMapper {

    /**
     * 查询详情
     */
    Map<String, Object> selectFileAttachmentById(Long id);

    /**
     * 根据 group_id 查询图片
     */
    //@MapKey("id")
    List<Map<String, Object>> select_file_by_group_id(@Param("group_id") long group_id);


    /**
     * 查询列表
     */
    List<FileAttachment> selectFileAttachmentList(FileAttachment dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> queryFileAttachmentList_BySQL(FileAttachment dto);

    //查询列表 总条数
    int queryFileAttachmentList_count(FileAttachment dto);

    /**
     * ++新增++
     */
    int insertFileAttachment(FileAttachment dto);

    /**
     * 修改
     */
    int updateFileAttachment(FileAttachment dto);


    /**
     * 批量修改文件所属组
     */
    int batch_change_file_group(FileGroupDto dto);

    /**
     * -删除-
     */
    int deleteFileAttachmentById(Long id);

    /**
     * --批量删除--
     */
    int deleteFileAttachmentByIds(Long[] ids);
}
