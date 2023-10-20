package com.ruoyi.platform.app.files.file_image.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.platform.app.files.file_image.service.impl.FileImageUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/20 21:24
 * @Description:
 */
@RestController
@RequestMapping("/file_image/upload")
public class FileImageUploadCtrl {

    @Autowired
    private FileImageUploadServiceImpl fileImageUploadService;

    /**
     * 图片上传
     */
    //@PreAuthorize("@ss.hasPermi('system:file:upload')")
    @Log(title = "图片上传", businessType = BusinessType.UPDATE)
    @PostMapping("/upload")
    public AjaxResult uploadFile(HttpServletRequest request, MultipartFile file) {
        return fileImageUploadService.uploadFile(request, file);
    }



}
