package com.ruoyi.platform.app.files.file_image.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.platform.app.files.file_image.domain.file_image;
import com.ruoyi.platform.app.files.file_image.mapper.file_imageMapper;
import com.ruoyi.platform.app.files.file_image.service.IFileImageUploadService;
import com.ruoyi.platform.app.files.file_image_group.domain.FileImageGroup;
import com.ruoyi.platform.app.files.file_image_group.mapper.FileImageGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/20 21:25
 * @Description:
 */
@Service
public class FileImageUploadServiceImpl implements IFileImageUploadService {

    private static final Logger logger = LoggerFactory.getLogger(FileImageUploadServiceImpl.class);

    @Autowired
    private file_imageMapper fileImageMapper;

    @Autowired
    private FileImageGroupMapper fileImageGroupMapper;

    /**
     * 图片上传
     */
    @Override
    public AjaxResult uploadFile(HttpServletRequest request, MultipartFile file) {
        //查询分组是否存在
        String group_id = request.getHeader("http-group-id");
        if (ObjectUtil.isEmpty(group_id)) {
            // return AjaxResult.error("组id不能为空");
            group_id = "0";
        }
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();

        //dto拼接
        file_image dto = new file_image();
        dto.setUserId(userId);

        try {
            long group_id_long = Long.parseLong(group_id);
            dto.setGroupId(group_id_long);  //附件组id
        } catch (Exception e) {
            return AjaxResult.error("上传失败: 用户id与组id类型错误. " + e.getMessage());
        }

        //查询组是否存在
        FileImageGroup group = new FileImageGroup();
        group.setGroupId(Long.parseLong(group_id));

        Map<String, Object> stringObjectMap = fileImageGroupMapper.queryGroupExist(group);
        if (ObjectUtil.isEmpty(stringObjectMap) || stringObjectMap.isEmpty()) {
            if (group_id.equals("9999")) {
                return AjaxResult.error("默认文件组不存在, 请联系管理员创建一个group_id为9999的文件组");
            } else if (group_id.equals("0")) {

            } else {
                return AjaxResult.error("文件组groupId不存在, 请检查组id是否正确");
            }
        }

        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getImgUploadPath();

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
            String replacePath = fileName.replace("/media/imgUpload", "");
            String absPath = filePath + replacePath;
            dto.setAbsPath(absPath);

            String url = this.getUrl() + fileName;
            dto.setUrl(url);

            int i = fileImageMapper.insertfile_image(dto);

            ajax.put("success", i);
            ajax.put("url", url);
            ajax.put("absPath", absPath);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 多图上传
     */
    @Override
    public AjaxResult uploadFiles(HttpServletRequest request, List<MultipartFile> files) {
        return AjaxResult.error("多图上传暂未实现");
    }

    @Override
    public String deleteFiles(Long[] ids) {
        StringBuilder sb = new StringBuilder();
        for (Long fileId : ids) {
            //查询文件 by id
            Map<String, Object> stringObjectMap = fileImageMapper.selectfile_imageById(fileId);
            if (ObjectUtil.isEmpty(stringObjectMap)) {
                logger.warn("附件id: {} 查询不存在.跳过", fileId);
                sb.append(String.format("附件id: %s 查询不存在.跳过", fileId));
                continue;
            }

            String absPath = (String) stringObjectMap.get("absPath");
            //拼接
//            String img_prefix_path = RuoYiConfig.getProfile();
//            String replacePath = filePath.replace("/media/imgUpload", "/imgUpload");
//            String absPath = img_prefix_path + replacePath;

            logger.warn("执行图片删除操作.删除图片路径: {}", absPath);
            //移除文件
            String s = FileUploadUtils.deleteToLocal(absPath);
            sb.append(String.format(" 图片id: %s 删除成功 %s.", fileId, s));
        }
        return sb.toString();
    }

    public String getUrl() {
        HttpServletRequest request = ServletUtils.getRequest();
        return getDomain(request);
    }

    public static String getDomain(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        String contextPath = request.getServletContext().getContextPath();
        return url.delete(url.length() - request.getRequestURI().length(), url.length()).append(contextPath).toString();
    }
}
