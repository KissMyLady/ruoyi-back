package com.ruoyi.platform.app.zblog.v4_files.file_image.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.v4_files.file_image.domain.FileImage;

/**
 * 素材图片Service接口
 *
 * @author mylady
 * @date 2023-10-07
 */
public interface IFileImageService {
    /**
     * 查询素材图片
     *
     * @param id 素材图片主键
     * @return 素材图片
     */
    public FileImage selectFileImageById(Long id);

    /**
     * 查询素材图片列表
     *
     * @param fileImage 素材图片
     * @return 素材图片集合
     */
    public List<FileImage> selectFileImageList(FileImage fileImage);

    /**
     * 新增素材图片
     *
     * @param fileImage 素材图片
     * @return 结果
     */
    public int insertFileImage(FileImage fileImage);

    /**
     * 修改素材图片
     *
     * @param fileImage 素材图片
     * @return 结果
     */
    public int updateFileImage(FileImage fileImage);

    /**
     * 批量删除素材图片
     *
     * @param ids 需要删除的素材图片主键集合
     * @return 结果
     */
    public int deleteFileImageByIds(Long[] ids);

    /**
     * 删除素材图片信息
     *
     * @param id 素材图片主键
     * @return 结果
     */
    public int deleteFileImageById(Long id);
}
