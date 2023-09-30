package com.ruoyi.platform.app.zblog.do_spu.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.do_spu.mapper.DoSpuMapper;
import com.ruoyi.platform.app.zblog.do_spu.domain.DoSpu;
import com.ruoyi.platform.app.zblog.do_spu.service.IDoSpuService;

/**
 * do_spuService业务层处理
 *
 * @author mylady
 * @date 2023-09-30
 */
@Service
public class DoSpuServiceImpl implements IDoSpuService {
    @Autowired
    private DoSpuMapper doSpuMapper;

    /**
     * 查询do_spu
     *
     * @param id do_spu主键
     * @return do_spu
     */
    @Override
    public DoSpu selectDoSpuById(Long id) {
        return doSpuMapper.selectDoSpuById(id);
    }

    /**
     * 查询do_spu列表
     *
     * @param doSpu do_spu
     * @return do_spu
     */
    @Override
    public List<DoSpu> selectDoSpuList(DoSpu doSpu) {
        return doSpuMapper.selectDoSpuList(doSpu);
    }

    /**
     * 新增do_spu
     *
     * @param doSpu do_spu
     * @return 结果
     */
    @Override
    public int insertDoSpu(DoSpu doSpu) {
                doSpu.setCreateTime(DateUtils.getNowDate());
            return doSpuMapper.insertDoSpu(doSpu);
    }

    /**
     * 修改do_spu
     *
     * @param doSpu do_spu
     * @return 结果
     */
    @Override
    public int updateDoSpu(DoSpu doSpu) {
                doSpu.setUpdateTime(DateUtils.getNowDate());
        return doSpuMapper.updateDoSpu(doSpu);
    }

    /**
     * 批量删除do_spu
     *
     * @param ids 需要删除的do_spu主键
     * @return 结果
     */
    @Override
    public int deleteDoSpuByIds(Long[] ids) {
        return doSpuMapper.deleteDoSpuByIds(ids);
    }

    /**
     * 删除do_spu信息
     *
     * @param id do_spu主键
     * @return 结果
     */
    @Override
    public int deleteDoSpuById(Long id) {
        return doSpuMapper.deleteDoSpuById(id);
    }
}
