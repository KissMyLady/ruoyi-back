package com.ruoyi.platform.app.zblog.v4_files.file_image.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.v4_files.file_image.mapper.FileImageMapper;
import com.ruoyi.platform.app.zblog.v4_files.file_image.domain.FileImage;
import com.ruoyi.platform.app.zblog.v4_files.file_image.service.IFileImageService;

/**
 * 素材图片Service业务层处理
 *
 * @author mylady
 * @date 2023-10-07
 */
@Service
public class FileImageServiceImpl implements IFileImageService {
    @Autowired
    private FileImageMapper fileImageMapper;

    /**
     * 查询素材图片
     *
     * @param id 素材图片主键
     * @return 素材图片
     */
    @Override
    public FileImage selectFileImageById(Long id) {
        return fileImageMapper.selectFileImageById(id);
    }

    /**
     * 查询素材图片列表
     *
     * @param fileImage 素材图片
     * @return 素材图片
     */
    @Override
    public List<FileImage> selectFileImageList(FileImage fileImage) {
        return fileImageMapper.selectFileImageList(fileImage);
    }

    /**
     * 新增素材图片
     *
     * @param fileImage 素材图片
     * @return 结果
     */
    @Override
    public int insertFileImage(FileImage fileImage) {
        fileImage.setCreateTime(DateUtils.getNowDate());
        return fileImageMapper.insertFileImage(fileImage);
    }

    /**
     * 修改素材图片
     *
     * @param fileImage 素材图片
     * @return 结果
     */
    @Override
    public int updateFileImage(FileImage fileImage) {
        fileImage.setUpdateTime(DateUtils.getNowDate());
        return fileImageMapper.updateFileImage(fileImage);
    }

    /**
     * 批量删除素材图片
     *
     * @param ids 需要删除的素材图片主键
     * @return 结果
     */
    @Override
    public int deleteFileImageByIds(Long[] ids) {
        return fileImageMapper.deleteFileImageByIds(ids);
    }

    /**
     * 删除素材图片信息
     *
     * @param id 素材图片主键
     * @return 结果
     */
    @Override
    public int deleteFileImageById(Long id) {
        return fileImageMapper.deleteFileImageById(id);
    }
}
