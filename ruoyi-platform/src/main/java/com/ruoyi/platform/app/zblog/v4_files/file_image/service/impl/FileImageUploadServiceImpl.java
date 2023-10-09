package com.ruoyi.platform.app.zblog.v4_files.file_image.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.domain.FileAttachment;
import com.ruoyi.platform.app.zblog.v4_files.file_image.domain.FileImage;
import com.ruoyi.platform.app.zblog.v4_files.file_image.mapper.FileImageMapper;
import com.ruoyi.platform.app.zblog.v4_files.file_image.service.FileImageUploadService;
import com.ruoyi.platform.app.zblog.v4_files.file_image_group.domain.FileImageGroup;
import com.ruoyi.platform.app.zblog.v4_files.file_image_group.mapper.FileImageGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/8 18:01
 * @Description:
 */
@Service
public class FileImageUploadServiceImpl implements FileImageUploadService {

    private static final Logger logger = LoggerFactory.getLogger(FileImageUploadServiceImpl.class);

    @Autowired
    private FileImageMapper fileImageMapper;

    @Autowired
    private FileImageGroupMapper fileImageGroupMapper;

    /**
     * 图片上传
     */
    @Override
    public AjaxResult imageUploadFile(HttpServletRequest request, MultipartFile file) {
        if (ObjectUtil.isEmpty(request.getHeader("group_id"))) {
            return AjaxResult.error("图片组组id不能为空");
        }
        String groupId = request.getHeader("group_id");
        //查询组是否存在
        List<Map<String, Objects>> maps = fileImageGroupMapper.queryGroupIdExist(groupId);
        if(ObjectUtil.isEmpty(maps)){
            return AjaxResult.error("图片组groupId不存在, 请检查组id是否正确");
        }

        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String originalName = file.getOriginalFilename();

            int len = originalName.length();
            if (len >= 240) {
                //截取后面250位
                originalName = "cut_" + originalName.substring(len - 240, len);
            }
            //String url = serverConfig.getUrl() + fileName;

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
            FileImage dto = new FileImage();

            dto.setUserId(1L);
            dto.setGroupId(Long.parseLong(groupId));

            dto.setFileSuffix(extension);  //后缀
            dto.setFileSize(mSize);  //图片大小
            dto.setFileName(originalName); //图片名
            dto.setTitle(originalName); //标题
            dto.setFilePath(fileName);  //路径
            dto.setUpMethod("spring");  //上传方式

            //md5
            int i = fileImageMapper.insertFileImage(dto);
            ajax.put("success", i);
            ajax.put("groupId", i);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }

    }

    /**
     * 图片删除
     */
    @Override
    public String deleteImage(Long[] ids) {
        StringBuilder sb = new StringBuilder();
        for (Long fileId : ids) {
            //查询文件
            FileImage dto = fileImageMapper.selectFileImageById(fileId);
            if (ObjectUtil.isEmpty(dto)){
                sb.append("图片id");
                sb.append(fileId);
                sb.append("查询不存在.跳过. ");
                continue;
            }
            String upload_path = RuoYiConfig.getUploadPath();

            String filePath = dto.getFilePath();
            // 路径格式: /media/upload/2023/10/08/2023-03-12_120556.png
            String replacePath = filePath.replace("/media/upload", "");

            String newPath = upload_path + replacePath;
            //移除文件
            String s = FileUploadUtils.deleteToLocal(newPath);

            sb.append("执行图片删除操作.删除文件路径:").append(newPath);
            sb.append("id:").append(fileId);
            sb.append("文件删除成功:").append(s);
        }
        return sb.toString();
    }
}
