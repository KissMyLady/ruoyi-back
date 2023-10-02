package com.ruoyi.platform.app.zblog.do_sku.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.do_sku.mapper.DoSkuMapper;
import com.ruoyi.platform.app.zblog.do_sku.domain.DoSku;
import com.ruoyi.platform.app.zblog.do_sku.service.IDoSkuService;

/**
 * do_skuService业务层处理
 *
 * @author mylady
 * @date 2023-10-02
 */
@Service
public class DoSkuServiceImpl implements IDoSkuService {
    @Autowired
    private DoSkuMapper doSkuMapper;

    /**
     * 查询do_sku
     *
     * @param id do_sku主键
     * @return do_sku
     */
    @Override
    public DoSku selectDoSkuById(Long id) {
        return doSkuMapper.selectDoSkuById(id);
    }

    /**
     * 查询do_sku列表
     *
     * @param doSku do_sku
     * @return do_sku
     */
    @Override
    public List<DoSku> selectDoSkuList(DoSku doSku) {
        return doSkuMapper.selectDoSkuList(doSku);
    }

    /**
     * 新增do_sku
     *
     * @param doSku do_sku
     * @return 结果
     */
    @Override
    public int insertDoSku(DoSku doSku) {
                doSku.setCreateTime(DateUtils.getNowDate());
            return doSkuMapper.insertDoSku(doSku);
    }

    /**
     * 修改do_sku
     *
     * @param doSku do_sku
     * @return 结果
     */
    @Override
    public int updateDoSku(DoSku doSku) {
                doSku.setUpdateTime(DateUtils.getNowDate());
        return doSkuMapper.updateDoSku(doSku);
    }

    /**
     * 批量删除do_sku
     *
     * @param ids 需要删除的do_sku主键
     * @return 结果
     */
    @Override
    public int deleteDoSkuByIds(Long[] ids) {
        return doSkuMapper.deleteDoSkuByIds(ids);
    }

    /**
     * 删除do_sku信息
     *
     * @param id do_sku主键
     * @return 结果
     */
    @Override
    public int deleteDoSkuById(Long id) {
        return doSkuMapper.deleteDoSkuById(id);
    }
}
