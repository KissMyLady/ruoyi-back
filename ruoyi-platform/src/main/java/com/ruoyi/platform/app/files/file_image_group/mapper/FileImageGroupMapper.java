package com.ruoyi.platform.app.files.file_image_group.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.files.file_image_group.domain.FileImageGroup;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 图片分组Mapper接口
 *
 * @author mylady
 * @date 2023-10-15
 */
//@DataSource(value = DataSourceType.MASTER)
public interface FileImageGroupMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selectFileImageGroupById(Long id);

    /**
     * 查询列表
     */
    List<FileImageGroup> selectFileImageGroupList(FileImageGroup dto);

    /**
     * 查询图片组是否存在
     */
    Map<String, Object> queryGroupExist(FileImageGroup dto);

    /**
     * SQL查询列表
     */
    // @MapKey("id")
    List<Map<String, Object>> queryFileImageGroupList_BySQL(FileImageGroup dto);

    //查询列表 总条数
    int queryFileImageGroupList_count(FileImageGroup dto);

    /**
     * ++新增++
     */
    int insertFileImageGroup(FileImageGroup dto);

    /**
     * 修改
     */
    int updateFileImageGroup(FileImageGroup dto);

    /**
     * -删除-
     */
    int deleteFileImageGroupById(Long id);

    /**
     * --批量删除--
     */
    int deleteFileImageGroupByIds(Long[] ids);
}
