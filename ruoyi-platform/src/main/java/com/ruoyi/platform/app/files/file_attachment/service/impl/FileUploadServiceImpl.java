package com.ruoyi.platform.app.files.file_attachment.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.platform.app.files.file_attachment.mapper.FileAttachmentMapper;
import com.ruoyi.platform.app.files.file_attachment.service.IFileUploadService;
import com.ruoyi.platform.app.files.file_attachment_group.mapper.FileAttachmentGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.platform.app.files.file_attachment.domain.FileAttachment;
import com.ruoyi.platform.app.files.file_attachment_group.domain.FileAttachmentGroup;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/20 9:41
 * @Description:
 */
@Service
public class FileUploadServiceImpl implements IFileUploadService {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);

    @Autowired
    private FileAttachmentMapper fileAttachmentMapper;

    @Autowired
    private FileAttachmentGroupMapper fileAttachmentGroupMapper;

    private static final String FILE_DELIMETER = ",";

    @Override
    public AjaxResult uploadFile(HttpServletRequest request, MultipartFile file) {
        String group_id = request.getHeader("group_id");
        logger.info("获取到的group_id: {}", group_id);
        if (ObjectUtil.isEmpty(group_id)) {
            return AjaxResult.error("组id不能为空");
        }
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();

        //dto拼接
        FileAttachment dto = new FileAttachment();
        dto.setUserId(userId);

        try {
            long group_id_long = Long.parseLong(group_id);
            dto.setGroupId(group_id_long);  //附件组id
        } catch (Exception e) {
            return AjaxResult.error("上传失败: 用户id与组id类型错误. " + e.getMessage());
        }

        //查询组是否存在
        FileAttachmentGroup group = new FileAttachmentGroup();
        group.setGroupId(Long.parseLong(group_id));
        List<Map<String, Object>> maps = fileAttachmentGroupMapper.queryGroupExist(group);
        if (ObjectUtil.isEmpty(maps)) {
            if (group_id.equals("9999")) {
                return AjaxResult.error("默认文件组不存在, 请联系管理员创建一个group_id为9999的文件组");
            } else {
                return AjaxResult.error("文件组groupId不存在, 请检查组id是否正确");
            }
        }

        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();

            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String originalName = file.getOriginalFilename();

            String originalFilename = file.getOriginalFilename();
            assert originalFilename != null;
            int len = originalFilename.length();
            if (len >= 250) {
                //截取后面250位
                originalFilename = originalFilename.substring(len - 250, len);
            }

            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("newFileName", FileUtils.getName(fileName));
            ajax.put("originalFilename", originalFilename);

            //大小
            float size = file.getSize();
            String mSize = String.format("%.2fM", size / 1024 / 1024);

            //后缀
            String extension = FileUploadUtils.getExtension(file);

            dto.setFileSuffix(extension);
            dto.setFilePath(fileName);
            dto.setFileName(originalName);
            dto.setTitle(originalName);
            dto.setFileSize(mSize);
            dto.setUpMethod("spring");

            //绝对路径与url设置
            String replacePath = fileName.replace("/media/upload", "");
            String absPath = filePath + replacePath;

            String url = this.getUrl() + fileName;
            dto.setAbsPath(absPath);
            dto.setUrl(url);

            int i = fileAttachmentMapper.insertFileAttachment(dto);

            ajax.put("success", i);
            ajax.put("url", url);
            ajax.put("absPath", absPath);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    @Override
    public AjaxResult uploadFiles(HttpServletRequest request, List<MultipartFile> files) {
        if (ObjectUtil.isEmpty(request.getHeader("group_id"))) {
            return AjaxResult.error("组id不能为空");
        }
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();

        //dto拼接
        FileAttachment dto = new FileAttachment();
        dto.setUserId(userId);
        String group_id = request.getHeader("group_id");

        try {
            long group_id_long = Long.parseLong(group_id);
            dto.setGroupId(group_id_long);  //附件组id
        } catch (Exception e) {
            return AjaxResult.error("上传失败: 用户id与组id类型错误. " + e.getMessage());
        }

        //查询组是否存在
        FileAttachmentGroup group = new FileAttachmentGroup();
        group.setGroupId(Long.parseLong(group_id));
        List<Map<String, Object>> maps = fileAttachmentGroupMapper.queryGroupExist(group);
        if (ObjectUtil.isEmpty(maps)) {
            if (group_id.equals("9999")) {
                return AjaxResult.error("默认文件组不存在, 请联系管理员创建一个group_id为9999的文件组");
            } else {
                return AjaxResult.error("文件组groupId不存在, 请检查组id是否正确");
            }
        }


        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath();
        List<String> urls = new ArrayList<>();
        List<String> fileNames = new ArrayList<>();
        List<String> newFileNames = new ArrayList<>();
        List<String> originalFilenames = new ArrayList<>();
        List<String> absPathList = new ArrayList<>();
        List<String> successInsertData = new ArrayList<>();

        for (MultipartFile file : files) {
            try {
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);
                String originalName = file.getOriginalFilename();

                String originalFilename = file.getOriginalFilename();
                assert originalFilename != null;
                int len = originalFilename.length();
                if (len >= 250) {
                    //截取后面250位
                    originalFilename = originalFilename.substring(len - 250, len);
                }

                //大小
                float size = file.getSize();
                String mSize = String.format("%.2fM", size / 1024 / 1024);

                //后缀
                String extension = FileUploadUtils.getExtension(file);

                dto.setFileSuffix(extension);
                dto.setFilePath(fileName);
                dto.setFileName(originalName);
                dto.setTitle(originalName);
                dto.setFileSize(mSize);
                dto.setUpMethod("spring");

                //绝对路径与url设置
                String replacePath = fileName.replace("/media/upload", "");
                String absPath = filePath + replacePath;

                String url = this.getUrl() + fileName;
                dto.setAbsPath(absPath);
                dto.setUrl(url);

                int i = fileAttachmentMapper.insertFileAttachment(dto);

                successInsertData.add(" ,数据插入成功: " + i);

                fileNames.add(fileName);
                newFileNames.add(FileUtils.getName(fileName));
                originalFilenames.add(originalFilename);
                urls.add(url);
                absPathList.add(absPath);

            } catch (Exception e) {
                logger.warn("多文件上传失败: {}", e.getMessage());
                // return AjaxResult.error(e.getMessage());
            }
        }

        AjaxResult ajax = AjaxResult.success();
        ajax.put("urls", StringUtils.join(urls, FILE_DELIMETER));
        ajax.put("fileNames", StringUtils.join(fileNames, FILE_DELIMETER));
        ajax.put("newFileNames", StringUtils.join(newFileNames, FILE_DELIMETER));
        ajax.put("originalFilenames", StringUtils.join(originalFilenames, FILE_DELIMETER));
        ajax.put("absPathList", StringUtils.join(absPathList, FILE_DELIMETER));
        ajax.put("successInsertData", StringUtils.join(successInsertData, FILE_DELIMETER));
        return ajax;
    }

    /**
     * 获取完整的请求路径，包括：域名，端口，上下文访问路径
     *
     * @return 服务地址
     */
    public String getUrl() {
        HttpServletRequest request = ServletUtils.getRequest();
        return getDomain(request);
    }

    public static String getDomain(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        String contextPath = request.getServletContext().getContextPath();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append(contextPath).toString();
    }

    @Override
    public String deleteFiles(Long[] ids) {
        StringBuilder sb = new StringBuilder();
        for (Long fileId : ids) {
            //查询文件 by id
            Map<String, Object> stringObjectMap = fileAttachmentMapper.selectFileAttachmentById(fileId);
            if (ObjectUtil.isEmpty(stringObjectMap)) {
                logger.warn("附件id: {} 查询不存在.跳过", fileId);
                sb.append(String.format("附件id: %s 查询不存在.跳过", fileId));
                continue;
            }

            String absPath = (String) stringObjectMap.get("absPath");
            logger.info("执行图片删除操作.删除文件路径: {}", absPath);
            //移除文件
            String s = FileUploadUtils.deleteToLocal(absPath);
            sb.append(String.format(" 附件id: %s 文件删除成功 %s.", fileId, s));
        }
        return sb.toString();
    }
}
