package com.ruoyi.platform.app.zblog.ideal.ideal_project.service.impl;

import cn.hutool.core.util.ObjectUtil;

import java.util.Map;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.EncryptDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.ideal.ideal_project.mapper.IdealProjectMapper;
import com.ruoyi.platform.app.zblog.ideal.ideal_project.domain.IdealProject;
import com.ruoyi.platform.app.zblog.ideal.ideal_project.service.IIdealProjectService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分类Service业务层处理
 *
 * @author mylady
 * @date 2023-10-29
 */
@Service
public class IdealProjectServiceImpl implements IIdealProjectService {

    private static final Logger logger = LoggerFactory.getLogger(IdealProjectServiceImpl.class);

    @Autowired
    private IdealProjectMapper idealProjectMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectIdealProjectById(Long id) {
        return idealProjectMapper.selectIdealProjectById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<IdealProject> selectIdealProjectList(IdealProject dto) {
        return idealProjectMapper.selectIdealProjectList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertIdealProject(IdealProject idealProject) {
        idealProject.setCreateTime(DateUtils.getNowDate());
        return idealProjectMapper.insertIdealProject(idealProject);
    }

    /**
     * 修改
     */
    @Override
    public int updateIdealProject(IdealProject idealProject) {
        idealProject.setUpdateTime(DateUtils.getNowDate());
        return idealProjectMapper.updateIdealProject(idealProject);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteIdealProjectByIds(Long[] ids) {
        return idealProjectMapper.deleteIdealProjectByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleteIdealProjectById(Long id) {
        return idealProjectMapper.deleteIdealProjectById(id);
    }
}
