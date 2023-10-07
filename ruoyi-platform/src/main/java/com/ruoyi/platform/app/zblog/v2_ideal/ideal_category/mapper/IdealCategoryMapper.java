package com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.mapper;

import java.util.List;
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.domain.IdealCategory;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
 * 看理想-类别Mapper接口
 *
 * @author mylady
 * @date 2023-10-07
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface IdealCategoryMapper {
    /**
     * 查询看理想-类别
     *
     * @param id 看理想-类别主键
     * @return 看理想-类别
     */
    IdealCategory selectIdealCategoryById(Long id);

    /**
     * 查询看理想-类别列表
     *
     * @param idealCategory 看理想-类别
     * @return 看理想-类别集合
     */
    List<IdealCategory> selectIdealCategoryList(IdealCategory idealCategory);

    /**
     * 新增看理想-类别
     *
     * @param idealCategory 看理想-类别
     * @return 结果
     */
    int insertIdealCategory(IdealCategory idealCategory);

    /**
     * 修改看理想-类别
     *
     * @param idealCategory 看理想-类别
     * @return 结果
     */
    int updateIdealCategory(IdealCategory idealCategory);

    /**
     * 删除看理想-类别
     *
     * @param id 看理想-类别主键
     * @return 结果
     */
    int deleteIdealCategoryById(Long id);

    /**
     * 批量删除看理想-类别
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteIdealCategoryByIds(Long[] ids);
}
