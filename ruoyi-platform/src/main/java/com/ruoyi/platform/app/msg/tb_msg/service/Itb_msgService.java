package com.ruoyi.platform.app.msg.tb_msg.service;

import java.util.List;
import java.util.Map;
import com.ruoyi.platform.app.msg.tb_msg.domain.tb_msg;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
/**
 * 消息Service接口
 *
 * @author mylady
 * @date 2023-10-21
 */
public interface Itb_msgService {
    /**
     * 查询详情
     */
    Map<String, Object> selecttb_msgById(Long id);

    /**
     * 查询列表
     */
    List<tb_msg> selecttb_msgList(tb_msg dto);

    /**
     * ++新增++
     */
    int inserttb_msg(tb_msg dto);

    /**
     * 修改
     */
    int updatetb_msg(tb_msg dto);

    /**
     * --批量删除--
     */
    int deletetb_msgByIds(Long[] ids);

    /**
     * -删除-
     */
    int deletetb_msgById(Long id);

}
