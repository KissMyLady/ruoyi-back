package com.ruoyi.common.utils.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.exception.file.FileNameLengthLimitExceededException;
import com.ruoyi.common.exception.file.FileSizeLimitExceededException;
import com.ruoyi.common.exception.file.InvalidExtensionException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.Seq;

/**
 * 文件上传工具类
 *
 * @author ruoyi
 */
public class FileUploadUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUploadUtils.class);

    /**
     * 默认大小 50M 1G
     */
    public static final long DEFAULT_MAX_SIZE = 1024 * 1024 * 1024;

    /**
     * 默认的文件名最大长度 100
     */
    public static final int DEFAULT_FILE_NAME_LENGTH = 200;

    /**
     * 默认上传的地址
     */
    private static String defaultBaseDir = RuoYiConfig.getProfile();

    public static void setDefaultBaseDir(String defaultBaseDir) {
        FileUploadUtils.defaultBaseDir = defaultBaseDir;
    }

    public static String getDefaultBaseDir() {
        return defaultBaseDir;
    }

    /**
     * 以默认配置进行文件上传
     *
     * @param file 上传的文件
     * @return 文件名称
     * @throws Exception
     */
    public static String upload(MultipartFile file) throws IOException {
        try {
            return upload(getDefaultBaseDir(), file, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
        } catch (Exception e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    /**
     * 根据文件路径上传
     *
     * @param baseDir 相对应用的基目录
     * @param file    上传的文件
     * @return 文件名称
     * @throws IOException
     */
    public static String upload(String baseDir, MultipartFile file) throws IOException {
        try {
            String pathFileName = upload(baseDir, file, MimeTypeUtils.DEFAULT_ALLOWED_EXTENSION);
            return pathFileName;
        } catch (Exception e) {
            throw new IOException(e.getMessage(), e);
        }
    }

    /**
     * 文件上传
     *
     * @param baseDir          相对应用的基目录
     * @param file             上传的文件
     * @param allowedExtension 上传文件类型
     * @return 返回上传成功的文件名
     * @throws FileSizeLimitExceededException       如果超出最大大小
     * @throws FileNameLengthLimitExceededException 文件名太长
     * @throws IOException                          比如读写文件出错时
     * @throws InvalidExtensionException            文件校验异常
     */
    public static String upload(String baseDir,
                                MultipartFile file,
                                String[] allowedExtension
    ) throws FileSizeLimitExceededException,
            IOException,
            FileNameLengthLimitExceededException,
            InvalidExtensionException
    {
        //获取文件长度
        int fileNamelength = Objects.requireNonNull(file.getOriginalFilename()).length();
        if (fileNamelength > FileUploadUtils.DEFAULT_FILE_NAME_LENGTH) {
            throw new FileNameLengthLimitExceededException(FileUploadUtils.DEFAULT_FILE_NAME_LENGTH);
        }

        //文件大小校验, 类型校验
        assertAllowed(file, allowedExtension);

        //编码文件名
        String fileName = extractFilename(file);

        //获取File对象
        String absPath = getAbsoluteFile(
                baseDir,
                fileName
        ).getAbsolutePath();

        //写入. 将当前对象的输入流（可能是文件或其他数据源）的内容复制到指定的目录路径。
        file.transferTo(Paths.get(absPath));

        String pathFileName = getPathFileName(baseDir, fileName);
        return pathFileName;
    }

    /**
     * 编码文件名
     */
    public static String extractFilename(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();

        logger.info("编码文件名 获取的文件名: {}", originalFilename);
//        String format = StringUtils.format(
//                "{}/{}_{}.{}",
//                DateUtils.datePath(),
//                FilenameUtils.getBaseName(originalFilename),
//                Seq.getId(Seq.uploadSeqType),  //机器id
//                getExtension(file)  //后缀
//        );
        String format = StringUtils.format(
                "{}/{}.{}",
                DateUtils.datePath(),
                FilenameUtils.getBaseName(originalFilename),
                getExtension(file)  //后缀
        );

        return format;
    }

    public static File getAbsoluteFile(String uploadDir, String fileName) throws IOException {
        File desc = new File(uploadDir + File.separator + fileName);

        if (!desc.exists()) {
            if (!desc.getParentFile().exists()) {
                desc.getParentFile().mkdirs();
            }
        }
        return desc;
    }

    public static String getPathFileName(String uploadDir, String fileName) throws IOException {
        int dirLastIndex = RuoYiConfig.getProfile().length() + 1;
        String currentDir = StringUtils.substring(uploadDir, dirLastIndex);
        return Constants.RESOURCE_PREFIX + "/" + currentDir + "/" + fileName;
    }

    /**
     * 文件大小校验
     *
     * @param file 上传的文件
     * @return
     * @throws FileSizeLimitExceededException 如果超出最大大小
     * @throws InvalidExtensionException
     */
    public static void assertAllowed(MultipartFile file, String[] allowedExtension)
            throws FileSizeLimitExceededException, InvalidExtensionException
    {
        long size = file.getSize();
        if (size > DEFAULT_MAX_SIZE) {
            throw new FileSizeLimitExceededException(DEFAULT_MAX_SIZE / 1024 / 1024);
        }

        //类型判断
//        String fileName = file.getOriginalFilename();
//        String extension = getExtension(file);

//        if (allowedExtension != null && !isAllowedExtension(extension, allowedExtension)) {
//            if (allowedExtension == MimeTypeUtils.IMAGE_EXTENSION) {
//                throw new InvalidExtensionException.InvalidImageExtensionException(allowedExtension, extension, fileName);
//            } else if (allowedExtension == MimeTypeUtils.FLASH_EXTENSION) {
//                throw new InvalidExtensionException.InvalidFlashExtensionException(allowedExtension, extension, fileName);
//            } else if (allowedExtension == MimeTypeUtils.MEDIA_EXTENSION) {
//                throw new InvalidExtensionException.InvalidMediaExtensionException(allowedExtension, extension, fileName);
//            } else if (allowedExtension == MimeTypeUtils.VIDEO_EXTENSION) {
//                throw new InvalidExtensionException.InvalidVideoExtensionException(allowedExtension, extension, fileName);
//            } else {
//                throw new InvalidExtensionException(allowedExtension, extension, fileName);
//            }
//        }
    }

    /**
     * 判断MIME类型是否是允许的MIME类型
     *
     * @param extension
     * @param allowedExtension
     * @return
     */
    public static boolean isAllowedExtension(String extension, String[] allowedExtension) {
        for (String str : allowedExtension) {
            if (str.equalsIgnoreCase(extension)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取文件名的后缀
     *
     * @param file 表单文件
     * @return 后缀名
     */
    public static String getExtension(MultipartFile file) {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (StringUtils.isEmpty(extension)) {
            extension = MimeTypeUtils.getExtension(Objects.requireNonNull(file.getContentType()));
        }
        return extension;
    }

    /**
     * 传入路径, 移除本地文件
     * 1: 成功
     * 0: 失败
     */
    public static String deleteToLocal(String path){
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
