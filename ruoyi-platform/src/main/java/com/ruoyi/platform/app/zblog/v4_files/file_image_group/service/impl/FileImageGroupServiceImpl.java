package com.ruoyi.platform.app.zblog.v4_files.file_image_group.service.impl;

import java.util.List;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.platform.app.zblog.v4_files.file_image.domain.FileImage;
import com.ruoyi.platform.app.zblog.v4_files.file_image.mapper.FileImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.v4_files.file_image_group.mapper.FileImageGroupMapper;
import com.ruoyi.platform.app.zblog.v4_files.file_image_group.domain.FileImageGroup;
import com.ruoyi.platform.app.zblog.v4_files.file_image_group.service.IFileImageGroupService;

/**
 * file_image_groupService业务层处理
 *
 * @author mylady
 * @date 2023-10-07
 */
@Service
public class FileImageGroupServiceImpl implements IFileImageGroupService {
    @Autowired
    private FileImageGroupMapper fileImageGroupMapper;

    @Autowired
    private FileImageMapper imageMapper;

    /**
     * 查询file_image_group
     *
     * @param id file_image_group主键
     * @return file_image_group
     */
    @Override
    public FileImageGroup selectFileImageGroupById(Long id) {
        return fileImageGroupMapper.selectFileImageGroupById(id);
    }

    /**
     * 查询file_image_group列表
     *
     * @param fileImageGroup file_image_group
     * @return file_image_group
     */
    @Override
    public List<FileImageGroup> selectFileImageGroupList(FileImageGroup fileImageGroup) {
        return fileImageGroupMapper.selectFileImageGroupList(fileImageGroup);
    }

    /**
     * 新增file_image_group
     *
     * @param fileImageGroup file_image_group
     * @return 结果
     */
    @Override
    public int insertFileImageGroup(FileImageGroup fileImageGroup) {
        fileImageGroup.setCreateTime(DateUtils.getNowDate());
        return fileImageGroupMapper.insertFileImageGroup(fileImageGroup);
    }

    /**
     * 修改file_image_group
     *
     * @param fileImageGroup file_image_group
     * @return 结果
     */
    @Override
    public int updateFileImageGroup(FileImageGroup fileImageGroup) {
        fileImageGroup.setUpdateTime(DateUtils.getNowDate());
        return fileImageGroupMapper.updateFileImageGroup(fileImageGroup);
    }

    /**
     * 批量删除file_image_group
     *
     * @param ids 需要删除的file_image_group主键
     * @return 结果
     */
    @Override
    public int deleteFileImageGroupByIds(Long[] ids) {
        return fileImageGroupMapper.deleteFileImageGroupByIds(ids);
    }

    /**
     * 删除file_image_group信息
     *
     * @param id file_image_group主键
     * @return 结果
     */
    @Override
    public int deleteFileImageGroupById(Long id) {
        return fileImageGroupMapper.deleteFileImageGroupById(id);
    }
}
