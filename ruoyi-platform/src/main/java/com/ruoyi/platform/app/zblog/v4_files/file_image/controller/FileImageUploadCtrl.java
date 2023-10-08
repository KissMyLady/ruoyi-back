package com.ruoyi.platform.app.zblog.v4_files.file_image.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.platform.app.zblog.v4_files.file_image.service.impl.FileImageUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/8 18:00
 * @Description: 图片上传API
 */
@RestController
@RequestMapping("/file_image/upload")
public class FileImageUploadCtrl extends BaseController {

    @Autowired
    private FileImageUploadServiceImpl fileImageUploadService;

    /**
     * 图片上传. 并写入到数据库
     */
    //@PreAuthorize("@ss.hasPermi('book_article:book_article:edit')")
    @Log(title = "图片上传", businessType = BusinessType.UPDATE)
    @PostMapping("/upload")
    public AjaxResult uploadFile(HttpServletRequest request, MultipartFile file) throws Exception {
        return fileImageUploadService.imageUploadFile(request, file);
    }

    //多图片上传
}
