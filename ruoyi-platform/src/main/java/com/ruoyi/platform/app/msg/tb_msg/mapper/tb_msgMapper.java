package com.ruoyi.platform.app.msg.tb_msg.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.msg.tb_msg.domain.tb_msg;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 消息Mapper接口
 *
 * @author mylady
 * @date 2023-10-21
 */
//@DataSource(value = DataSourceType.MASTER)
public interface tb_msgMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selecttb_msgById(Long id);

    /**
     * 查询列表
     */
    List<tb_msg> selecttb_msgList(tb_msg dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> querytb_msgList_BySQL(tb_msg dto);

    //查询列表 总条数
    int querytb_msgList_count(tb_msg dto);

    /**
     * ++新增++
     */
    int inserttb_msg(tb_msg dto);

    /**
     * 修改
     */
    int updatetb_msg(tb_msg dto);

    /**
     * -删除-
     */
    int deletetb_msgById(Long id);

    /**
     * --批量删除--
     */
    int deletetb_msgByIds(Long[] ids);
}
