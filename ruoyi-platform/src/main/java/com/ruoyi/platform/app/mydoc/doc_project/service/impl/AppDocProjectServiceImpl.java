package com.ruoyi.platform.app.mydoc.doc_project.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.mydoc.doc_project.mapper.AppDocProjectMapper;
import com.ruoyi.platform.app.mydoc.doc_project.domain.AppDocProject;
import com.ruoyi.platform.app.mydoc.doc_project.service.IAppDocProjectService;

/**
 * doc_projectService业务层处理
 *
 * @author mylady
 * @date 2023-09-30
 */
@Service
public class AppDocProjectServiceImpl implements IAppDocProjectService {
    @Autowired
    private AppDocProjectMapper appDocProjectMapper;

    /**
     * 查询doc_project
     *
     * @param id doc_project主键
     * @return doc_project
     */
    @Override
    public AppDocProject selectAppDocProjectById(Long id) {
        return appDocProjectMapper.selectAppDocProjectById(id);
    }

    /**
     * 查询doc_project列表
     *
     * @param appDocProject doc_project
     * @return doc_project
     */
    @Override
    public List<AppDocProject> selectAppDocProjectList(AppDocProject appDocProject) {
        return appDocProjectMapper.selectAppDocProjectList(appDocProject);
    }

    /**
     * 新增doc_project
     *
     * @param appDocProject doc_project
     * @return 结果
     */
    @Override
    public int insertAppDocProject(AppDocProject appDocProject) {
                appDocProject.setCreateTime(DateUtils.getNowDate());
            return appDocProjectMapper.insertAppDocProject(appDocProject);
    }

    /**
     * 修改doc_project
     *
     * @param appDocProject doc_project
     * @return 结果
     */
    @Override
    public int updateAppDocProject(AppDocProject appDocProject) {
        return appDocProjectMapper.updateAppDocProject(appDocProject);
    }

    /**
     * 批量删除doc_project
     *
     * @param ids 需要删除的doc_project主键
     * @return 结果
     */
    @Override
    public int deleteAppDocProjectByIds(Long[] ids) {
        return appDocProjectMapper.deleteAppDocProjectByIds(ids);
    }

    /**
     * 删除doc_project信息
     *
     * @param id doc_project主键
     * @return 结果
     */
    @Override
    public int deleteAppDocProjectById(Long id) {
        return appDocProjectMapper.deleteAppDocProjectById(id);
    }
}
