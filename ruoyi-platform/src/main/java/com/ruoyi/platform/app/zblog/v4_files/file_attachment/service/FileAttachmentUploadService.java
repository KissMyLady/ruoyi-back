package com.ruoyi.platform.app.zblog.v4_files.file_attachment.service;

import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/8 16:50
 * @Description:
 */
public interface FileAttachmentUploadService {


    /**
     * 文件上传
     */
    AjaxResult uploadFile(MultipartFile file);



    /**
     * 多文件上传
     */
    AjaxResult uploadFiles(List<MultipartFile> files);


    /**
     * 文件删除
     */
    AjaxResult deleteFile(Long[] ids);

}
