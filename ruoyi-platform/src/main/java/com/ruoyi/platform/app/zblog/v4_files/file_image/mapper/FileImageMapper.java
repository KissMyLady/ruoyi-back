package com.ruoyi.platform.app.zblog.v4_files.file_image.mapper;

import java.util.List;

import com.ruoyi.platform.app.zblog.v4_files.file_image.domain.FileImage;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
 * 素材图片Mapper接口
 *
 * @author mylady
 * @date 2023-10-07
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface FileImageMapper {
    /**
     * 查询素材图片
     *
     * @param id 素材图片主键
     * @return 素材图片
     */
    FileImage selectFileImageById(Long id);

    /**
     * 查询素材图片列表
     *
     * @param fileImage 素材图片
     * @return 素材图片集合
     */
    List<FileImage> selectFileImageList(FileImage fileImage);

    /**
     * 新增素材图片
     *
     * @param fileImage 素材图片
     * @return 结果
     */
    int insertFileImage(FileImage fileImage);

    /**
     * 修改素材图片
     *
     * @param fileImage 素材图片
     * @return 结果
     */
    int updateFileImage(FileImage fileImage);

    /**
     * 删除素材图片
     *
     * @param id 素材图片主键
     * @return 结果
     */
    int deleteFileImageById(Long id);

    /**
     * 批量删除素材图片
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFileImageByIds(Long[] ids);
}
