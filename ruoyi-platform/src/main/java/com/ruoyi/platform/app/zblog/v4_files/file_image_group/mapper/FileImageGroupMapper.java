package com.ruoyi.platform.app.zblog.v4_files.file_image_group.mapper;

import java.util.List;
import com.ruoyi.platform.app.zblog.v4_files.file_image_group.domain.FileImageGroup;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
 * file_image_groupMapper接口
 *
 * @author mylady
 * @date 2023-10-07
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface FileImageGroupMapper {
    /**
     * 查询file_image_group
     *
     * @param id file_image_group主键
     * @return file_image_group
     */
    FileImageGroup selectFileImageGroupById(Long id);

    /**
     * 查询file_image_group列表
     *
     * @param fileImageGroup file_image_group
     * @return file_image_group集合
     */
    List<FileImageGroup> selectFileImageGroupList(FileImageGroup fileImageGroup);

    /**
     * 新增file_image_group
     *
     * @param fileImageGroup file_image_group
     * @return 结果
     */
    int insertFileImageGroup(FileImageGroup fileImageGroup);

    /**
     * 修改file_image_group
     *
     * @param fileImageGroup file_image_group
     * @return 结果
     */
    int updateFileImageGroup(FileImageGroup fileImageGroup);

    /**
     * 删除file_image_group
     *
     * @param id file_image_group主键
     * @return 结果
     */
    int deleteFileImageGroupById(Long id);

    /**
     * 批量删除file_image_group
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFileImageGroupByIds(Long[] ids);
}
