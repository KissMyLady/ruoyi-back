package com.ruoyi.platform.app.zblog.ideal.ideal_project.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.ideal.ideal_project.domain.IdealProject;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 分类Mapper接口
 *
 * @author mylady
 * @date 2023-10-29
 */
//@DataSource(value = DataSourceType.MASTER)
public interface IdealProjectMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selectIdealProjectById(Long id);

    /**
     * 查询列表
     */
    List<IdealProject> selectIdealProjectList(IdealProject dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> queryIdealProjectList_BySQL(IdealProject dto);

    //查询列表 总条数
    int queryIdealProjectList_count(IdealProject dto);

    /**
     * ++新增++
     */
    int insertIdealProject(IdealProject dto);

    /**
     * 修改
     */
    int updateIdealProject(IdealProject dto);

    /**
     * -删除-
     */
    int deleteIdealProjectById(Long id);

    /**
     * --批量删除--
     */
    int deleteIdealProjectByIds(Long[] ids);
}
