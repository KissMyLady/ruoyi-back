package com.ruoyi.platform.app.mydoc.doc_project.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.platform.app.mydoc.doc_project.domain.AppDocProject;

/**
 * doc_projectMapper接口
 *
 * @author mylady
 * @date 2023-09-30
 */
@DataSource(value = DataSourceType.slaveMyDoc)
public interface AppDocProjectMapper {
    /**
     * 查询doc_project
     *
     * @param id doc_project主键
     * @return doc_project
     */
    AppDocProject selectAppDocProjectById(Long id);

    /**
     * 查询doc_project列表
     *
     * @param appDocProject doc_project
     * @return doc_project集合
     */
    List<AppDocProject> selectAppDocProjectList(AppDocProject appDocProject);

    /**
     * 新增doc_project
     *
     * @param appDocProject doc_project
     * @return 结果
     */
    int insertAppDocProject(AppDocProject appDocProject);

    /**
     * 修改doc_project
     *
     * @param appDocProject doc_project
     * @return 结果
     */
    int updateAppDocProject(AppDocProject appDocProject);

    /**
     * 删除doc_project
     *
     * @param id doc_project主键
     * @return 结果
     */
    int deleteAppDocProjectById(Long id);

    /**
     * 批量删除doc_project
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAppDocProjectByIds(Long[] ids);
}
