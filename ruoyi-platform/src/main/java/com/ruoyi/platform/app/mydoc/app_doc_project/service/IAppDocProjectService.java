package com.ruoyi.platform.app.mydoc.app_doc_project.service;

import java.util.List;

import com.ruoyi.platform.app.mydoc.app_doc_project.domain.AppDocProject;

/**
 * 文集Service接口
 *
 * @author mylady
 * @date 2023-10-02
 */
public interface IAppDocProjectService {
    /**
     * 查询文集
     *
     * @param id 文集主键
     * @return 文集
     */
    public AppDocProject selectAppDocProjectById(Long id);

    /**
     * 查询文集列表
     *
     * @param appDocProject 文集
     * @return 文集集合
     */
    public List<AppDocProject> selectAppDocProjectList(AppDocProject appDocProject);

    /**
     * 新增文集
     *
     * @param appDocProject 文集
     * @return 结果
     */
    public int insertAppDocProject(AppDocProject appDocProject);

    /**
     * 修改文集
     *
     * @param appDocProject 文集
     * @return 结果
     */
    public int updateAppDocProject(AppDocProject appDocProject);

    /**
     * 批量删除文集
     *
     * @param ids 需要删除的文集主键集合
     * @return 结果
     */
    public int deleteAppDocProjectByIds(Long[] ids);

    /**
     * 删除文集信息
     *
     * @param id 文集主键
     * @return 结果
     */
    public int deleteAppDocProjectById(Long id);
}
