package com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.mapper.IdealCategoryMapper;
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.domain.IdealCategory;
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.service.IIdealCategoryService;

/**
 * 看理想-类别Service业务层处理
 *
 * @author mylady
 * @date 2023-10-07
 */
@Service
public class IdealCategoryServiceImpl implements IIdealCategoryService {
    @Autowired
    private IdealCategoryMapper idealCategoryMapper;

    /**
     * 查询看理想-类别
     *
     * @param id 看理想-类别主键
     * @return 看理想-类别
     */
    @Override
    public IdealCategory selectIdealCategoryById(Long id) {
        return idealCategoryMapper.selectIdealCategoryById(id);
    }

    /**
     * 查询看理想-类别列表
     *
     * @param idealCategory 看理想-类别
     * @return 看理想-类别
     */
    @Override
    public List<IdealCategory> selectIdealCategoryList(IdealCategory idealCategory) {
        return idealCategoryMapper.selectIdealCategoryList(idealCategory);
    }

    /**
     * 新增看理想-类别
     *
     * @param idealCategory 看理想-类别
     * @return 结果
     */
    @Override
    public int insertIdealCategory(IdealCategory idealCategory) {
                idealCategory.setCreateTime(DateUtils.getNowDate());
            return idealCategoryMapper.insertIdealCategory(idealCategory);
    }

    /**
     * 修改看理想-类别
     *
     * @param idealCategory 看理想-类别
     * @return 结果
     */
    @Override
    public int updateIdealCategory(IdealCategory idealCategory) {
                idealCategory.setUpdateTime(DateUtils.getNowDate());
        return idealCategoryMapper.updateIdealCategory(idealCategory);
    }

    /**
     * 批量删除看理想-类别
     *
     * @param ids 需要删除的看理想-类别主键
     * @return 结果
     */
    @Override
    public int deleteIdealCategoryByIds(Long[] ids) {
        return idealCategoryMapper.deleteIdealCategoryByIds(ids);
    }

    /**
     * 删除看理想-类别信息
     *
     * @param id 看理想-类别主键
     * @return 结果
     */
    @Override
    public int deleteIdealCategoryById(Long id) {
        return idealCategoryMapper.deleteIdealCategoryById(id);
    }
}
