package com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.domain.IdealDetailContent;

/**
 * 看理想-详情Service接口
 *
 * @author mylady
 * @date 2023-10-07
 */
public interface IIdealDetailContentService {
    /**
     * 查询看理想-详情
     *
     * @param id 看理想-详情主键
     * @return 看理想-详情
     */
    public IdealDetailContent selectIdealDetailContentById(Long id);

    /**
     * 查询看理想-详情列表
     *
     * @param idealDetailContent 看理想-详情
     * @return 看理想-详情集合
     */
    public List<IdealDetailContent> selectIdealDetailContentList(IdealDetailContent idealDetailContent);

    /**
     * 新增看理想-详情
     *
     * @param idealDetailContent 看理想-详情
     * @return 结果
     */
    public int insertIdealDetailContent(IdealDetailContent idealDetailContent);

    /**
     * 修改看理想-详情
     *
     * @param idealDetailContent 看理想-详情
     * @return 结果
     */
    public int updateIdealDetailContent(IdealDetailContent idealDetailContent);

    /**
     * 批量删除看理想-详情
     *
     * @param ids 需要删除的看理想-详情主键集合
     * @return 结果
     */
    public int deleteIdealDetailContentByIds(Long[] ids);

    /**
     * 删除看理想-详情信息
     *
     * @param id 看理想-详情主键
     * @return 结果
     */
    public int deleteIdealDetailContentById(Long id);
}
