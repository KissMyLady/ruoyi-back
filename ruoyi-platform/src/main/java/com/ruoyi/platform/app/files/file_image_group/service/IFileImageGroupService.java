package com.ruoyi.platform.app.files.file_image_group.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.files.file_image_group.domain.FileImageGroup;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
/**
 * 图片分组Service接口
 *
 * @author mylady
 * @date 2023-10-15
 */
public interface IFileImageGroupService {
    /**
     * 查询详情
     */
    Map<String, Object> selectFileImageGroupById(Long id);

    /**
     * 查询列表
     */
    List<FileImageGroup> selectFileImageGroupList(FileImageGroup dto);

    /**
     * ++新增++
     */
    int insertFileImageGroup(FileImageGroup dto);

    /**
     * 修改
     */
    int updateFileImageGroup(FileImageGroup dto);

    /**
     * --批量删除--
     */
    int deleteFileImageGroupByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleteFileImageGroupById(Long id);

}
