package com.ruoyi.platform.app.openApi.request_api_key_log.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.openApi.request_api_key_log.domain.request_api_key_log;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * api请求记录Mapper接口
 *
 * @author mylady
 * @date 2023-10-21
 */
//@DataSource(value = DataSourceType.MASTER)
public interface request_api_key_logMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selectrequest_api_key_logById(Long id);

    /**
     * 查询列表
     */
    List<request_api_key_log> selectrequest_api_key_logList(request_api_key_log dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> queryrequest_api_key_logList_BySQL(request_api_key_log dto);

    //查询列表 总条数
    int queryrequest_api_key_logList_count(request_api_key_log dto);

    /**
     * ++新增++
     */
    int insertrequest_api_key_log(request_api_key_log dto);

    /**
     * 修改
     */
    int updaterequest_api_key_log(request_api_key_log dto);

    /**
     * -删除-
     */
    int deleterequest_api_key_logById(Long id);

    /**
     * --批量删除--
     */
    int deleterequest_api_key_logByIds(Long[] ids);
}
