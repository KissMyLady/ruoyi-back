package com.ruoyi.platform.app.zblog.do_sku.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.platform.app.zblog.do_sku.domain.DoSku;

/**
 * do_skuMapper接口
 *
 * @author mylady
 * @date 2023-10-02
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface DoSkuMapper {
    /**
     * 查询do_sku
     *
     * @param id do_sku主键
     * @return do_sku
     */
    DoSku selectDoSkuById(Long id);

    /**
     * 查询do_sku列表
     *
     * @param doSku do_sku
     * @return do_sku集合
     */
    List<DoSku> selectDoSkuList(DoSku doSku);

    /**
     * 新增do_sku
     *
     * @param doSku do_sku
     * @return 结果
     */
    int insertDoSku(DoSku doSku);

    /**
     * 修改do_sku
     *
     * @param doSku do_sku
     * @return 结果
     */
    int updateDoSku(DoSku doSku);

    /**
     * 删除do_sku
     *
     * @param id do_sku主键
     * @return 结果
     */
    int deleteDoSkuById(Long id);

    /**
     * 批量删除do_sku
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteDoSkuByIds(Long[] ids);
}
