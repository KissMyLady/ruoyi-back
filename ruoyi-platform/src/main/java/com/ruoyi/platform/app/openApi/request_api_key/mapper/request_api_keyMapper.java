package com.ruoyi.platform.app.openApi.request_api_key.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.openApi.request_api_key.domain.request_api_key;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * api请求-keyMapper接口
 *
 * @author mylady
 * @date 2023-10-21
 */
//@DataSource(value = DataSourceType.MASTER)
public interface request_api_keyMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selectrequest_api_keyById(Long id);

    //字符串查询key
    request_api_key selectByKey(@Param("key") String key);

    //自增
    int addSendCount(@Param("key") String key);

    /**
     * 查询列表
     */
    List<request_api_key> selectrequest_api_keyList(request_api_key dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> queryrequest_api_keyList_BySQL(request_api_key dto);

    //查询列表 总条数
    int queryrequest_api_keyList_count(request_api_key dto);

    /**
     * ++新增++
     */
    int insertrequest_api_key(request_api_key dto);

    /**
     * 修改
     */
    int updaterequest_api_key(request_api_key dto);

    /**
     * -删除-
     */
    int deleterequest_api_keyById(Long id);

    /**
     * --批量删除--
     */
    int deleterequest_api_keyByIds(Long[] ids);
}
