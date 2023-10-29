package com.ruoyi.platform.app.zblog.ideal.ideal_detail.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.ideal.ideal_detail.domain.IdealDetail;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 详情Mapper接口
 *
 * @author mylady
 * @date 2023-10-29
 */
//@DataSource(value = DataSourceType.MASTER)
public interface IdealDetailMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selectIdealDetailById(Long id);

    /**
     * 查询列表
     */
    List<IdealDetail> selectIdealDetailList(IdealDetail dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> queryIdealDetailList_BySQL(IdealDetail dto);

    //查询列表 总条数
    int queryIdealDetailList_count(IdealDetail dto);

    /**
     * ++新增++
     */
    int insertIdealDetail(IdealDetail dto);

    /**
     * 修改
     */
    int updateIdealDetail(IdealDetail dto);

    /**
     * -删除-
     */
    int deleteIdealDetailById(Long id);

    /**
     * --批量删除--
     */
    int deleteIdealDetailByIds(Long[] ids);
}
