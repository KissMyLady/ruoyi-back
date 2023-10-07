package com.ruoyi.platform.app.zblog.v4_files.file_image_group.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.v4_files.file_image_group.domain.FileImageGroup;

/**
 * file_image_groupService接口
 *
 * @author mylady
 * @date 2023-10-07
 */
public interface IFileImageGroupService {
    /**
     * 查询file_image_group
     *
     * @param id file_image_group主键
     * @return file_image_group
     */
    public FileImageGroup selectFileImageGroupById(Long id);

    /**
     * 查询file_image_group列表
     *
     * @param fileImageGroup file_image_group
     * @return file_image_group集合
     */
    public List<FileImageGroup> selectFileImageGroupList(FileImageGroup fileImageGroup);

    /**
     * 新增file_image_group
     *
     * @param fileImageGroup file_image_group
     * @return 结果
     */
    public int insertFileImageGroup(FileImageGroup fileImageGroup);

    /**
     * 修改file_image_group
     *
     * @param fileImageGroup file_image_group
     * @return 结果
     */
    public int updateFileImageGroup(FileImageGroup fileImageGroup);

    /**
     * 批量删除file_image_group
     *
     * @param ids 需要删除的file_image_group主键集合
     * @return 结果
     */
    public int deleteFileImageGroupByIds(Long[] ids);

    /**
     * 删除file_image_group信息
     *
     * @param id file_image_group主键
     * @return 结果
     */
    public int deleteFileImageGroupById(Long id);
}
