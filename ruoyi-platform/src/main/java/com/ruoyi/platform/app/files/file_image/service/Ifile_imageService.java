package com.ruoyi.platform.app.files.file_image.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.files.file_image.domain.file_image;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
/**
 * 素材图片Service接口
 *
 * @author mylady
 * @date 2023-10-20
 */
public interface Ifile_imageService {
    /**
     * 查询详情
     */
    Map<String, Object> selectfile_imageById(Long id);

    /**
     * 查询列表
     */
    List<file_image> selectfile_imageList(file_image dto);

    /**
     * ++新增++
     */
    int insertfile_image(file_image dto);

    /**
     * 修改
     */
    int updatefile_image(file_image dto);

    /**
     * --批量删除--
     */
    int deletefile_imageByIds(Long[] ids);

    /**
     * -删除-
     */
    int deletefile_imageById(Long id);

}
