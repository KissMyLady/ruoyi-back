package com.ruoyi.platform.app.files.file_image.controller;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.platform.app.files.file_image.domain.FileImageGroupDto;
import com.ruoyi.platform.app.files.file_image.mapper.file_imageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/20 21:24
 * @Description:
 */
@RestController
@RequestMapping("/file_image/group")
public class FileImageGroupCtrl {

    @Autowired
    private file_imageMapper fileImageMapper;

    /**
     * 批量修改图片所属组
     */
    @PreAuthorize("@ss.hasPermi('file_image:file_image:edit')")
    @Log(title = "批量修改图片所属组", businessType = BusinessType.UPDATE)
    @PostMapping("/batchChangeImageGroup")
    public AjaxResult batchChangeImageGroup(@RequestBody FileImageGroupDto dto) {
        List<Integer> ids = dto.getIds();
        if (ObjectUtil.isEmpty(ids)) {
            return AjaxResult.error("传递ids不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getGroup_id())) {
            return AjaxResult.error("传递group_id不能为空");
        }

        int i = fileImageMapper.batch_change_image_group(dto);
        return AjaxResult.success("批量修改图片分组成功: " + i);
    }


}
