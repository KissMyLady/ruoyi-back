package com.ruoyi.platform.app.zblog.v4_files.file_attachment.service.impl;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.domain.FileAttachment;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.mapper.FileAttachmentMapper;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.service.FileAttachmentUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/8 16:50
 * @Description:
 */
@Service
public class FileAttachmentUploadServiceImpl implements FileAttachmentUploadService {

    @Autowired
    private FileAttachmentMapper fileAttachmentMapper;

    private static final String FILE_DELIMETER = ",";

    /**
     * 文件上传
     */
    @Override
    public AjaxResult uploadFile(MultipartFile file) {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String originalName = file.getOriginalFilename();

//            int len = fileName.length();
//            if (len >= 250) {
//                //截取后面250位
//                fileName = fileName.substring(len - 250, len);
//            }
            // String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", "前端拼接");
            ajax.put("fileName", fileName);
            ajax.put("newFileName", FileUtils.getName(fileName));
            ajax.put("originalFilename", originalName);

            //大小
            float size = file.getSize();
            String mSize = String.format("%.2fM", size / 1024 / 1024);

            //后缀
            String extension = FileUploadUtils.getExtension(file);

            //dto拼接
            FileAttachment dto = new FileAttachment();
            dto.setUserId(1L);  //用户默认为1, 应该从前端获取
            dto.setFileSuffix(extension);
            dto.setFilePath(fileName);
            dto.setFileName(originalName);
            dto.setTitle(originalName);
            dto.setFileSize(mSize);
            dto.setUpMethod("spring");
            //md5
            int i = fileAttachmentMapper.insertFileAttachment(dto);
            ajax.put("success", i);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 多文件上传
     */
    @Override
    public AjaxResult uploadFiles(List<MultipartFile> files) {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            List<String> urls = new ArrayList<>();
            List<String> fileNames = new ArrayList<>();
            List<String> newFileNames = new ArrayList<>();
            List<String> originalFilenames = new ArrayList<>();

            for (MultipartFile file : files) {
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);

                // String url = serverConfig.getUrl() + fileName;
                String url = "自己拼接";

                urls.add(url);
                fileNames.add(fileName);
                newFileNames.add(FileUtils.getName(fileName));
                String originalName = file.getOriginalFilename();

                originalFilenames.add(originalName);

                //大小
                float size = file.getSize();
                String mSize = String.format("%.2fM", size / 1024 / 1024);

                //后缀
                String extension = null;
                int dotIndex = fileName.lastIndexOf('.');
                if (dotIndex != -1) {
                    extension = fileName.substring(dotIndex + 1);
                }

                FileAttachment dto = new FileAttachment();
                dto.setFilePath(fileName);
                dto.setFileName(originalName);
                dto.setFileSuffix(extension);
                dto.setTitle(originalName);
                dto.setUpMethod("springBack");
                dto.setUserId(1L);
                //md5
                int i = fileAttachmentMapper.insertFileAttachment(dto);

                urls.add(",成功:" + i);
            }

            AjaxResult ajax = AjaxResult.success();
            ajax.put("urls", StringUtils.join(urls, FILE_DELIMETER));
            ajax.put("fileNames", StringUtils.join(fileNames, FILE_DELIMETER));
            ajax.put("newFileNames", StringUtils.join(newFileNames, FILE_DELIMETER));
            ajax.put("originalFilenames", StringUtils.join(originalFilenames, FILE_DELIMETER));
            return ajax;

        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}
