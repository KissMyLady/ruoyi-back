package com.ruoyi.platform.app.files.file_image_group.service.impl;

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
import com.ruoyi.platform.app.files.file_image_group.mapper.FileImageGroupMapper;
import com.ruoyi.platform.app.files.file_image_group.domain.FileImageGroup;
import com.ruoyi.platform.app.files.file_image_group.service.IFileImageGroupService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片分组Service业务层处理
 *
 * @author mylady
 * @date 2023-10-15
 */
@Service
public class FileImageGroupServiceImpl implements IFileImageGroupService {

    private static final Logger logger = LoggerFactory.getLogger(FileImageGroupServiceImpl.class);

    @Autowired
    private FileImageGroupMapper fileImageGroupMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectFileImageGroupById(Long id) {
        return fileImageGroupMapper.selectFileImageGroupById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<FileImageGroup> selectFileImageGroupList(FileImageGroup dto) {
        return fileImageGroupMapper.selectFileImageGroupList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertFileImageGroup(FileImageGroup fileImageGroup) {
        fileImageGroup.setCreateTime(DateUtils.getNowDate());
        return fileImageGroupMapper.insertFileImageGroup(fileImageGroup);
    }

    /**
     * 修改
     */
    @Override
    public int updateFileImageGroup(FileImageGroup fileImageGroup) {
        fileImageGroup.setUpdateTime(DateUtils.getNowDate());
        return fileImageGroupMapper.updateFileImageGroup(fileImageGroup);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteFileImageGroupByIds(Long[] ids) {
        return fileImageGroupMapper.deleteFileImageGroupByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleteFileImageGroupById(Long id) {
        return fileImageGroupMapper.deleteFileImageGroupById(id);
    }
}
