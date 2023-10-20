package com.ruoyi.platform.app.files.file_attachment.service;

import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/20 9:41
 * @Description:
 */
public interface IFileUploadService {

    /**
     * 单文件上传
     */
    AjaxResult uploadFile(HttpServletRequest request, MultipartFile file);


    /**
     * 多文件上传
     */
    AjaxResult uploadFiles(HttpServletRequest request, List<MultipartFile> files);

}
