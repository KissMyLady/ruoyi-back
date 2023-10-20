package com.ruoyi.platform.app.files.file_image.service.impl;

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
import com.ruoyi.platform.app.files.file_image.mapper.file_imageMapper;
import com.ruoyi.platform.app.files.file_image.domain.file_image;
import com.ruoyi.platform.app.files.file_image.service.Ifile_imageService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 素材图片Service业务层处理
 *
 * @author mylady
 * @date 2023-10-20
 */
@Service
public class file_imageServiceImpl implements Ifile_imageService {

    private static final Logger logger = LoggerFactory.getLogger(file_imageServiceImpl.class);

    @Autowired
    private file_imageMapper file_imageMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectfile_imageById(Long id) {
        return file_imageMapper.selectfile_imageById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<file_image> selectfile_imageList(file_image dto) {
        return file_imageMapper.selectfile_imageList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertfile_image(file_image file_image) {
        file_image.setCreateTime(DateUtils.getNowDate());
        return file_imageMapper.insertfile_image(file_image);
    }

    /**
     * 修改
     */
    @Override
    public int updatefile_image(file_image file_image) {
        file_image.setUpdateTime(DateUtils.getNowDate());
        return file_imageMapper.updatefile_image(file_image);
    }

    /**
     * 批量删除
     */
    @Override
    public int deletefile_imageByIds(Long[] ids) {
        return file_imageMapper.deletefile_imageByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deletefile_imageById(Long id) {
        return file_imageMapper.deletefile_imageById(id);
    }
}
