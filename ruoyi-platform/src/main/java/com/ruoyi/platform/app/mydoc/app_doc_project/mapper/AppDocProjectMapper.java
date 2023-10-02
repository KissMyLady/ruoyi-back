package com.ruoyi.platform.app.mydoc.app_doc_project.mapper;

import java.util.List;

import com.ruoyi.platform.app.mydoc.app_doc_project.domain.AppDocProject;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 文集Mapper接口
 *
 * @author mylady
 * @date 2023-10-02
 */
//@DataSource(value = DataSourceType.MASTER)
public interface AppDocProjectMapper {
    /**
     * 查询文集
     *
     * @param id 文集主键
     * @return 文集
     */
    AppDocProject selectAppDocProjectById(Long id);

    /**
     * 查询文集列表
     *
     * @param appDocProject 文集
     * @return 文集集合
     */
    List<AppDocProject> selectAppDocProjectList(AppDocProject appDocProject);

    /**
     * 新增文集
     *
     * @param appDocProject 文集
     * @return 结果
     */
    int insertAppDocProject(AppDocProject appDocProject);

    /**
     * 修改文集
     *
     * @param appDocProject 文集
     * @return 结果
     */
    int updateAppDocProject(AppDocProject appDocProject);

    /**
     * 删除文集
     *
     * @param id 文集主键
     * @return 结果
     */
    int deleteAppDocProjectById(Long id);

    /**
     * 批量删除文集
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAppDocProjectByIds(Long[] ids);
}
