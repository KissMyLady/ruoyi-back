package com.ruoyi.platform.app.zblog.do_spu.mapper;

import java.util.List;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.platform.app.zblog.do_spu.domain.DoSpu;

/**
 * do_spuMapper接口
 *
 * @author mylady
 * @date 2023-09-30
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface DoSpuMapper {
    /**
     * 查询do_spu
     *
     * @param id do_spu主键
     * @return do_spu
     */
    DoSpu selectDoSpuById(Long id);

    /**
     * 查询do_spu列表
     *
     * @param doSpu do_spu
     * @return do_spu集合
     */
    List<DoSpu> selectDoSpuList(DoSpu doSpu);

    /**
     * 新增do_spu
     *
     * @param doSpu do_spu
     * @return 结果
     */
    int insertDoSpu(DoSpu doSpu);

    /**
     * 修改do_spu
     *
     * @param doSpu do_spu
     * @return 结果
     */
    int updateDoSpu(DoSpu doSpu);

    /**
     * 删除do_spu
     *
     * @param id do_spu主键
     * @return 结果
     */
    int deleteDoSpuById(Long id);

    /**
     * 批量删除do_spu
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteDoSpuByIds(Long[] ids);
}
