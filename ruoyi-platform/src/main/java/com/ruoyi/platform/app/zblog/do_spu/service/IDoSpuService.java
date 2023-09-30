package com.ruoyi.platform.app.zblog.do_spu.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.do_spu.domain.DoSpu;

/**
 * do_spuService接口
 *
 * @author mylady
 * @date 2023-09-30
 */
public interface IDoSpuService {
    /**
     * 查询do_spu
     *
     * @param id do_spu主键
     * @return do_spu
     */
    public DoSpu selectDoSpuById(Long id);

    /**
     * 查询do_spu列表
     *
     * @param doSpu do_spu
     * @return do_spu集合
     */
    public List<DoSpu> selectDoSpuList(DoSpu doSpu);

    /**
     * 新增do_spu
     *
     * @param doSpu do_spu
     * @return 结果
     */
    public int insertDoSpu(DoSpu doSpu);

    /**
     * 修改do_spu
     *
     * @param doSpu do_spu
     * @return 结果
     */
    public int updateDoSpu(DoSpu doSpu);

    /**
     * 批量删除do_spu
     *
     * @param ids 需要删除的do_spu主键集合
     * @return 结果
     */
    public int deleteDoSpuByIds(Long[] ids);

    /**
     * 删除do_spu信息
     *
     * @param id do_spu主键
     * @return 结果
     */
    public int deleteDoSpuById(Long id);
}
