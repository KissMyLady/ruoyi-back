package com.ruoyi.platform.app.mydoc.app_doc_project.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.mydoc.app_doc_project.mapper.AppDocProjectMapper;
import com.ruoyi.platform.app.mydoc.app_doc_project.domain.AppDocProject;
import com.ruoyi.platform.app.mydoc.app_doc_project.service.IAppDocProjectService;

/**
 * 文集Service业务层处理
 *
 * @author mylady
 * @date 2023-10-02
 */
@Service
public class AppDocProjectServiceImpl implements IAppDocProjectService {
    @Autowired
    private AppDocProjectMapper appDocProjectMapper;

    /**
     * 查询文集
     *
     * @param id 文集主键
     * @return 文集
     */
    @Override
    public AppDocProject selectAppDocProjectById(Long id) {
        return appDocProjectMapper.selectAppDocProjectById(id);
    }

    /**
     * 查询文集列表
     *
     * @param appDocProject 文集
     * @return 文集
     */
    @Override
    public List<AppDocProject> selectAppDocProjectList(AppDocProject appDocProject) {
        return appDocProjectMapper.selectAppDocProjectList(appDocProject);
    }

    /**
     * 新增文集
     *
     * @param appDocProject 文集
     * @return 结果
     */
    @Override
    public int insertAppDocProject(AppDocProject appDocProject) {
                appDocProject.setCreateTime(DateUtils.getNowDate());
            return appDocProjectMapper.insertAppDocProject(appDocProject);
    }

    /**
     * 修改文集
     *
     * @param appDocProject 文集
     * @return 结果
     */
    @Override
    public int updateAppDocProject(AppDocProject appDocProject) {
        return appDocProjectMapper.updateAppDocProject(appDocProject);
    }

    /**
     * 批量删除文集
     *
     * @param ids 需要删除的文集主键
     * @return 结果
     */
    @Override
    public int deleteAppDocProjectByIds(Long[] ids) {
        return appDocProjectMapper.deleteAppDocProjectByIds(ids);
    }

    /**
     * 删除文集信息
     *
     * @param id 文集主键
     * @return 结果
     */
    @Override
    public int deleteAppDocProjectById(Long id) {
        return appDocProjectMapper.deleteAppDocProjectById(id);
    }
}
