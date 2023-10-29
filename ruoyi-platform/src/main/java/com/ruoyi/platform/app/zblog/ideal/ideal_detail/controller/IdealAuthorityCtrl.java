package com.ruoyi.platform.app.zblog.ideal.ideal_detail.controller;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.platform.app.zblog.blog.blog_blog.domain.BatchChangeAuthCodeDto;
import com.ruoyi.platform.app.zblog.ideal.ideal_detail.mapper.IdealDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/29 22:57
 * @Description:
 */
@RestController
@RequestMapping("/ideal_detail/authority")
public class IdealAuthorityCtrl {

    @Autowired
    private IdealDetailMapper idealDetailMapper;

    /**
     * 批量修改ideal文档权限
     */
    @PreAuthorize("@ss.hasPermi('ideal_detail:ideal_detail:edit')")
    @Log(title = "批量修改文档权限", businessType = BusinessType.UPDATE)
    @PostMapping("/batchChangeAuth")
    public AjaxResult batchChangeAuth(@RequestBody BatchChangeAuthCodeDto dto) {
        List<Integer> ids = dto.getIds();
        if (ObjectUtil.isEmpty(ids)) {
            return AjaxResult.error("传递ids不能为空");
        }
        String autoCode = dto.getCode();
        if (ObjectUtil.isEmpty(autoCode)) {
            return AjaxResult.error("传递code不能为空");
        }
        //校验code是否存在于数据库
        int i = idealDetailMapper.batch_update_authority(dto);
        return AjaxResult.success("修改成功 " + i);
    }


}
