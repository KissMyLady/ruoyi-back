package com.ruoyi.platform.app.zblog.ideal.ideal_project.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.ideal.ideal_project.domain.IdealProject;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;

/**
 * 分类Service接口
 *
 * @author mylady
 * @date 2023-10-29
 */
public interface IIdealProjectService {
    /**
     * 查询详情
     */
    Map<String, Object> selectIdealProjectById(Long id);

    /**
     * 查询列表
     */
    List<IdealProject> selectIdealProjectList(IdealProject dto);

    /**
     * ++新增++
     */
    int insertIdealProject(IdealProject dto);

    /**
     * 修改
     */
    int updateIdealProject(IdealProject dto);

    /**
     * --批量删除--
     */
    int deleteIdealProjectByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleteIdealProjectById(Long id);

}
