package com.ruoyi.platform.app.zblog.v4_files.file_attachment.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.domain.FileAttachment;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.mapper.FileAttachmentMapper;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.service.FileAttachmentUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/8 16:50
 * @Description:
 */
@Service
public class FileAttachmentUploadServiceImpl implements FileAttachmentUploadService {

    private static final Logger logger = LoggerFactory.getLogger(FileAttachmentUploadServiceImpl.class);

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

    @Override
    public AjaxResult deleteFile(Long[] ids) {
        AjaxResult ajax = new AjaxResult();
        for (Long fileId : ids) {
            //查询文件
            FileAttachment dto = fileAttachmentMapper.selectFileAttachmentById(fileId);
            if (ObjectUtil.isEmpty(dto)){
                logger.warn("文件id: {} 查询不存在.跳过", fileId);
                continue;
            }
            String upload_path = RuoYiConfig.getUploadPath();

            String filePath = dto.getFilePath();
            // 路径格式: /media/upload/2023/10/08/2023-03-12_120556.png
            String replacePath = filePath.replace("/media/upload", "");

            String newPath = upload_path + replacePath;
            logger.info("执行删除操作.删除文件路径: {}", newPath);
            //移除文件
            String s = deleteToLocal(newPath);
            ajax.put("id:"+fileId, "文件删除成功:"+s);
        }
        return ajax;
    }

    /**
     * 传入路径, 移除本地文件
     * 1: 成功
     * 0: 失败
     */
    public String deleteToLocal(String path){
        try {
            File pathFile = new File(path);
            if (pathFile.exists()) {
                pathFile.delete();
            }
            return "1";
        } catch (Exception e) {
            logger.error("传入路径移除本地文件, 操作失败, 原因是: {}", e +"");
            return "0";
        }

    }
}
