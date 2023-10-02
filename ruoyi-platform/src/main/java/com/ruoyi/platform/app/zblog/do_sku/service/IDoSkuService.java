package com.ruoyi.platform.app.zblog.do_sku.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.do_sku.domain.DoSku;

/**
 * do_skuService接口
 *
 * @author mylady
 * @date 2023-10-02
 */
public interface IDoSkuService {
    /**
     * 查询do_sku
     *
     * @param id do_sku主键
     * @return do_sku
     */
    public DoSku selectDoSkuById(Long id);

    /**
     * 查询do_sku列表
     *
     * @param doSku do_sku
     * @return do_sku集合
     */
    public List<DoSku> selectDoSkuList(DoSku doSku);

    /**
     * 新增do_sku
     *
     * @param doSku do_sku
     * @return 结果
     */
    public int insertDoSku(DoSku doSku);

    /**
     * 修改do_sku
     *
     * @param doSku do_sku
     * @return 结果
     */
    public int updateDoSku(DoSku doSku);

    /**
     * 批量删除do_sku
     *
     * @param ids 需要删除的do_sku主键集合
     * @return 结果
     */
    public int deleteDoSkuByIds(Long[] ids);

    /**
     * 删除do_sku信息
     *
     * @param id do_sku主键
     * @return 结果
     */
    public int deleteDoSkuById(Long id);
}
