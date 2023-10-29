package com.ruoyi.platform.app.files.file_attachment.controller;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.annotation.ReturnAESEncrypt;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.platform.app.files.file_attachment.domain.FileGroupDto;
import com.ruoyi.platform.app.files.file_attachment.mapper.FileAttachmentMapper;
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
 * @Date: Created in 2023/10/29 23:39
 * @Description:
 */
@RestController
@RequestMapping("/file_attachment/group")
public class FileGroupCtrl {

    @Autowired
    private FileAttachmentMapper fileAttachmentMapper;

    /**
     * 批量修改文件所属组
     */
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:edit')")
    @Log(title = "批量修改文件所属组", businessType = BusinessType.UPDATE)
    @PostMapping("/batchChangeFileGroup")
    public AjaxResult batchChangeFileGroup(@RequestBody FileGroupDto dto) {
        List<Integer> ids = dto.getIds();
        if (ObjectUtil.isEmpty(ids)) {
            return AjaxResult.error("传递ids不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getGroup_id())) {
            return AjaxResult.error("传递group_id不能为空");
        }
        int i = fileAttachmentMapper.batch_change_file_group(dto);
        return AjaxResult.success("修改成功: " + i);
    }
}
