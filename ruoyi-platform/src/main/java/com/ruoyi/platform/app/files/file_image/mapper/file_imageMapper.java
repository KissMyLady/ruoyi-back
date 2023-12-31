package com.ruoyi.platform.app.files.file_image.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.files.file_image.domain.FileImageGroupDto;
import com.ruoyi.platform.app.files.file_image.domain.file_image;
import org.apache.ibatis.annotations.MapKey;
import com.ruoyi.platform.app.files.file_attachment.domain.FileGroupDto;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 素材图片Mapper接口
 *
 * @author mylady
 * @date 2023-10-20
 */
//@DataSource(value = DataSourceType.MASTER)
public interface file_imageMapper {

    /**
     * 查询详情
     */
    // @MapKey("id")
    Map<String, Object> selectfile_imageById(Long id);

    /**
     * 查询列表
     */
    List<file_image> selectfile_imageList(file_image dto);

    /**
     * 查询组下图片数量
     */
    int query_group_image_count(@Param("group_id") String group_id);

    /**
     * SQL查询列表
     */
    // @MapKey("id")
    List<Map<String, Object>> queryfile_imageList_BySQL(file_image dto);

    //查询列表 总条数
    int queryfile_imageList_count(file_image dto);

    /**
     * ++新增++
     */
    int insertfile_image(file_image dto);

    /**
     * 修改
     */
    int updatefile_image(file_image dto);

    /**
     * 批量修改图片 所属组
     */
    int batch_change_image_group(FileImageGroupDto dto);

    /**
     * -删除-
     */
    int deletefile_imageById(Long id);

    /**
     * --批量删除--
     */
    int deletefile_imageByIds(Long[] ids);
}
