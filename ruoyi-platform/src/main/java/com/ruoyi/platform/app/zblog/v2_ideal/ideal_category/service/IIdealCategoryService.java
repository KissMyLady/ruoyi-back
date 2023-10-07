package com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.domain.IdealCategory;

/**
 * 看理想-类别Service接口
 *
 * @author mylady
 * @date 2023-10-07
 */
public interface IIdealCategoryService {
    /**
     * 查询看理想-类别
     *
     * @param id 看理想-类别主键
     * @return 看理想-类别
     */
    public IdealCategory selectIdealCategoryById(Long id);

    /**
     * 查询看理想-类别列表
     *
     * @param idealCategory 看理想-类别
     * @return 看理想-类别集合
     */
    public List<IdealCategory> selectIdealCategoryList(IdealCategory idealCategory);

    /**
     * 新增看理想-类别
     *
     * @param idealCategory 看理想-类别
     * @return 结果
     */
    public int insertIdealCategory(IdealCategory idealCategory);

    /**
     * 修改看理想-类别
     *
     * @param idealCategory 看理想-类别
     * @return 结果
     */
    public int updateIdealCategory(IdealCategory idealCategory);

    /**
     * 批量删除看理想-类别
     *
     * @param ids 需要删除的看理想-类别主键集合
     * @return 结果
     */
    public int deleteIdealCategoryByIds(Long[] ids);

    /**
     * 删除看理想-类别信息
     *
     * @param id 看理想-类别主键
     * @return 结果
     */
    public int deleteIdealCategoryById(Long id);
}
