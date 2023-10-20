package com.ruoyi.platform.app.files.file_attachment.controller;

import com.ruoyi.platform.app.files.file_attachment.service.impl.FileUploadServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/20 9:31
 * @Description:
 */
@RestController
@RequestMapping("/file_attachment/upload")
public class FileUploadCtrl {

    @Autowired
    private FileUploadServiceImpl fileUploadService;

    //附件上传
    //@PreAuthorize("@ss.hasPermi('system:file:upload')")
    @Log(title = "文件上传", businessType = BusinessType.UPDATE)
    @PostMapping("/upload")
    public AjaxResult uploadFile(HttpServletRequest request, MultipartFile file) {
        return fileUploadService.uploadFile(request, file);
    }

    //多文件上传
    //@PreAuthorize("@ss.hasPermi('system:file:upload')")
    @Log(title = "多文件上传", businessType = BusinessType.UPDATE)
    @PostMapping("/uploads")
    public AjaxResult uploadFiles(HttpServletRequest request, List<MultipartFile> files) {
        return fileUploadService.uploadFiles(request, files);
    }

}
