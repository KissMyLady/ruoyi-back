package com.ruoyi.platform.app.files.file_image.service;

import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/20 21:25
 * @Description:
 */
public interface IFileImageUploadService {

    /**
     * 单文件上传
     */
    AjaxResult uploadFile(HttpServletRequest request, MultipartFile file);

    /**
     * 多文件上传
     */
    AjaxResult uploadFiles(HttpServletRequest request, List<MultipartFile> files);

    /**
     * 文件删除
     */
    String deleteFiles(Long[] ids);

}
