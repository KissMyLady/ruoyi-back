package com.ruoyi.platform.app.mydoc.app_doc_doc.mapper;

import com.ruoyi.platform.app.mydoc.app_doc_doc.domain.AppDocDoc;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/2 19:37
 * @Description:
 */
public interface AppDocDocAuthorityRowMapper {


    /**
     * 查询app_doc_doc列表
     *
     * @param appDocDoc app_doc_doc
     * @return app_doc_doc集合
     */
    @MapKey("id")
    List<Map<String, Object>> selectAppDocDocList(AppDocDoc appDocDoc);


}
