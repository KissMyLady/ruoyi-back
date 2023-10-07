package com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.mapper.IdealDetailContentMapper;
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.domain.IdealDetailContent;
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.service.IIdealDetailContentService;

/**
 * 看理想-详情Service业务层处理
 *
 * @author mylady
 * @date 2023-10-07
 */
@Service
public class IdealDetailContentServiceImpl implements IIdealDetailContentService {
    @Autowired
    private IdealDetailContentMapper idealDetailContentMapper;

    /**
     * 查询看理想-详情
     *
     * @param id 看理想-详情主键
     * @return 看理想-详情
     */
    @Override
    public IdealDetailContent selectIdealDetailContentById(Long id) {
        return idealDetailContentMapper.selectIdealDetailContentById(id);
    }

    /**
     * 查询看理想-详情列表
     *
     * @param idealDetailContent 看理想-详情
     * @return 看理想-详情
     */
    @Override
    public List<IdealDetailContent> selectIdealDetailContentList(IdealDetailContent idealDetailContent) {
        return idealDetailContentMapper.selectIdealDetailContentList(idealDetailContent);
    }

    /**
     * 新增看理想-详情
     *
     * @param idealDetailContent 看理想-详情
     * @return 结果
     */
    @Override
    public int insertIdealDetailContent(IdealDetailContent idealDetailContent) {
        idealDetailContent.setCreateTime(DateUtils.getNowDate());
        return idealDetailContentMapper.insertIdealDetailContent(idealDetailContent);
    }

    /**
     * 修改看理想-详情
     *
     * @param idealDetailContent 看理想-详情
     * @return 结果
     */
    @Override
    public int updateIdealDetailContent(IdealDetailContent idealDetailContent) {
        idealDetailContent.setUpdateTime(DateUtils.getNowDate());
        return idealDetailContentMapper.updateIdealDetailContent(idealDetailContent);
    }

    /**
     * 批量删除看理想-详情
     *
     * @param ids 需要删除的看理想-详情主键
     * @return 结果
     */
    @Override
    public int deleteIdealDetailContentByIds(Long[] ids) {
        return idealDetailContentMapper.deleteIdealDetailContentByIds(ids);
    }

    /**
     * 删除看理想-详情信息
     *
     * @param id 看理想-详情主键
     * @return 结果
     */
    @Override
    public int deleteIdealDetailContentById(Long id) {
        return idealDetailContentMapper.deleteIdealDetailContentById(id);
    }
}
