package com.ruoyi.platform.app.zblog.ideal.ideal_detail.service.impl;

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
import com.ruoyi.platform.app.zblog.ideal.ideal_detail.mapper.IdealDetailMapper;
import com.ruoyi.platform.app.zblog.ideal.ideal_detail.domain.IdealDetail;
import com.ruoyi.platform.app.zblog.ideal.ideal_detail.service.IIdealDetailService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 详情Service业务层处理
 *
 * @author mylady
 * @date 2023-10-29
 */
@Service
public class IdealDetailServiceImpl implements IIdealDetailService {

    private static final Logger logger = LoggerFactory.getLogger(IdealDetailServiceImpl.class);

    @Autowired
    private IdealDetailMapper idealDetailMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectIdealDetailById(Long id) {
        return idealDetailMapper.selectIdealDetailById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<IdealDetail> selectIdealDetailList(IdealDetail dto) {
        return idealDetailMapper.selectIdealDetailList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertIdealDetail(IdealDetail idealDetail) {
        idealDetail.setCreateTime(DateUtils.getNowDate());
        return idealDetailMapper.insertIdealDetail(idealDetail);
    }

    /**
     * 修改
     */
    @Override
    public int updateIdealDetail(IdealDetail idealDetail) {
        idealDetail.setUpdateTime(DateUtils.getNowDate());
        return idealDetailMapper.updateIdealDetail(idealDetail);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteIdealDetailByIds(Long[] ids) {
        return idealDetailMapper.deleteIdealDetailByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleteIdealDetailById(Long id) {
        return idealDetailMapper.deleteIdealDetailById(id);
    }
}
