package com.ruoyi.platform.app.zblog.v4_files.file_image.service;

import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/8 18:01
 * @Description:
 */
public interface FileImageUploadService {

    /**
     * 图片上传
     */
    AjaxResult imageUploadFile(HttpServletRequest request, MultipartFile file);

    /**
     * 图片删除
     */
    AjaxResult deleteImage(Long[] ids);

}
