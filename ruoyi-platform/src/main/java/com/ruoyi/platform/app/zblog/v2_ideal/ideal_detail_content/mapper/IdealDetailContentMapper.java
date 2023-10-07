package com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.mapper;

import java.util.List;
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.domain.IdealDetailContent;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
 * 看理想-详情Mapper接口
 *
 * @author mylady
 * @date 2023-10-07
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface IdealDetailContentMapper {
    /**
     * 查询看理想-详情
     *
     * @param id 看理想-详情主键
     * @return 看理想-详情
     */
    IdealDetailContent selectIdealDetailContentById(Long id);

    /**
     * 查询看理想-详情列表
     *
     * @param idealDetailContent 看理想-详情
     * @return 看理想-详情集合
     */
    List<IdealDetailContent> selectIdealDetailContentList(IdealDetailContent idealDetailContent);

    /**
     * 新增看理想-详情
     *
     * @param idealDetailContent 看理想-详情
     * @return 结果
     */
    int insertIdealDetailContent(IdealDetailContent idealDetailContent);

    /**
     * 修改看理想-详情
     *
     * @param idealDetailContent 看理想-详情
     * @return 结果
     */
    int updateIdealDetailContent(IdealDetailContent idealDetailContent);

    /**
     * 删除看理想-详情
     *
     * @param id 看理想-详情主键
     * @return 结果
     */
    int deleteIdealDetailContentById(Long id);

    /**
     * 批量删除看理想-详情
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteIdealDetailContentByIds(Long[] ids);
}
