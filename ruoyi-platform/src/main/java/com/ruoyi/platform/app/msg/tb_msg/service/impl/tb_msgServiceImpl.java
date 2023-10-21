package com.ruoyi.platform.app.msg.tb_msg.service.impl;

import cn.hutool.core.util.ObjectUtil;

import java.util.Map;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.EncryptDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.msg.tb_msg.mapper.tb_msgMapper;
import com.ruoyi.platform.app.msg.tb_msg.domain.tb_msg;
import com.ruoyi.platform.app.msg.tb_msg.service.Itb_msgService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消息Service业务层处理
 *
 * @author mylady
 * @date 2023-10-21
 */
@Service
public class tb_msgServiceImpl implements Itb_msgService {

    private static final Logger logger = LoggerFactory.getLogger(tb_msgServiceImpl.class);

    @Autowired
    private tb_msgMapper tb_msgMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selecttb_msgById(Long id) {
        return tb_msgMapper.selecttb_msgById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<tb_msg> selecttb_msgList(tb_msg dto) {
        return tb_msgMapper.selecttb_msgList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int inserttb_msg(tb_msg tb_msg) {
        tb_msg.setCreateTime(DateUtils.getNowDate());
        return tb_msgMapper.inserttb_msg(tb_msg);
    }

    /**
     * 修改
     */
    @Override
    public int updatetb_msg(tb_msg tb_msg) {
        tb_msg.setUpdateTime(DateUtils.getNowDate());
        return tb_msgMapper.updatetb_msg(tb_msg);
    }

    /**
     * 批量删除
     */
    @Override
    public int deletetb_msgByIds(Long[] ids) {
        return tb_msgMapper.deletetb_msgByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deletetb_msgById(Long id) {
        return tb_msgMapper.deletetb_msgById(id);
    }
}
