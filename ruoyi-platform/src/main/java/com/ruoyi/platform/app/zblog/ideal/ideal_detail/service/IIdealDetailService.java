package com.ruoyi.platform.app.zblog.ideal.ideal_detail.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.ideal.ideal_detail.domain.IdealDetail;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;

/**
 * 详情Service接口
 *
 * @author mylady
 * @date 2023-10-29
 */
public interface IIdealDetailService {
    /**
     * 查询详情
     */
    Map<String, Object> selectIdealDetailById(Long id);

    /**
     * 查询列表
     */
    List<IdealDetail> selectIdealDetailList(IdealDetail dto);

    /**
     * ++新增++
     */
    int insertIdealDetail(IdealDetail dto);

    /**
     * 修改
     */
    int updateIdealDetail(IdealDetail dto);

    /**
     * --批量删除--
     */
    int deleteIdealDetailByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleteIdealDetailById(Long id);

}
