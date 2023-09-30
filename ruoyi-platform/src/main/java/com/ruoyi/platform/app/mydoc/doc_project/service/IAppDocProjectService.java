package com.ruoyi.platform.app.mydoc.doc_project.service;

import java.util.List;

import com.ruoyi.platform.app.mydoc.doc_project.domain.AppDocProject;

/**
 * doc_projectService接口
 *
 * @author mylady
 * @date 2023-09-30
 */
public interface IAppDocProjectService {
    /**
     * 查询doc_project
     *
     * @param id doc_project主键
     * @return doc_project
     */
    public AppDocProject selectAppDocProjectById(Long id);

    /**
     * 查询doc_project列表
     *
     * @param appDocProject doc_project
     * @return doc_project集合
     */
    public List<AppDocProject> selectAppDocProjectList(AppDocProject appDocProject);

    /**
     * 新增doc_project
     *
     * @param appDocProject doc_project
     * @return 结果
     */
    public int insertAppDocProject(AppDocProject appDocProject);

    /**
     * 修改doc_project
     *
     * @param appDocProject doc_project
     * @return 结果
     */
    public int updateAppDocProject(AppDocProject appDocProject);

    /**
     * 批量删除doc_project
     *
     * @param ids 需要删除的doc_project主键集合
     * @return 结果
     */
    public int deleteAppDocProjectByIds(Long[] ids);

    /**
     * 删除doc_project信息
     *
     * @param id doc_project主键
     * @return 结果
     */
    public int deleteAppDocProjectById(Long id);
}
