package com.ruoyi.platform.app.zblog.v4_files.file_attachment.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.service.impl.FileAttachmentUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/8 16:56
 * @Description:
 */
@RestController
@RequestMapping("/file_attachment/upload")
public class FileAttachmentUploadCtrl extends BaseController {

    @Autowired
    private FileAttachmentUploadServiceImpl fileAttachmentUploadService;

    /**
     * 文件上传. 并写入到数据库
     */
    //@PreAuthorize("@ss.hasPermi('book_article:book_article:edit')")
    @Log(title = "文件上传", businessType = BusinessType.UPDATE)
    @PostMapping("/upload")
    public AjaxResult uploadFile(MultipartFile file) throws Exception {
        return fileAttachmentUploadService.uploadFile(file);
    }


    /**
     * 通用上传请求（多个）
     */
    //@PreAuthorize("@ss.hasPermi('book_article:book_article:edit')")
    @Log(title = "多文件上传", businessType = BusinessType.UPDATE)
    @PostMapping("/uploads")
    public AjaxResult uploadFiles(List<MultipartFile> files) throws Exception {
        return fileAttachmentUploadService.uploadFiles(files);
    }

}
