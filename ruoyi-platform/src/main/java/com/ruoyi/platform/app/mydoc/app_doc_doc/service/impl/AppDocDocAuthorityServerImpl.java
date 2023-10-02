package com.ruoyi.platform.app.mydoc.app_doc_doc.service.impl;

import com.ruoyi.platform.app.mydoc.app_doc_doc.domain.AppDocDoc;
import com.ruoyi.platform.app.mydoc.app_doc_doc.mapper.AppDocDocAuthorityRowMapper;
import com.ruoyi.platform.app.mydoc.app_doc_doc.service.IAppDocDocAuthorityServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/2 19:45
 * @Description:
 */
@Service
public class AppDocDocAuthorityServerImpl implements IAppDocDocAuthorityServer {


    @Autowired
    private AppDocDocAuthorityRowMapper appDocDocAuthorityRowMapper;

    /**
     * 查询doc_doc表的list数据 By auth_dept
     */
    @Override
    public List<Map<String, Object>> selectAppDocDocList(AppDocDoc appDocDoc) {
        return appDocDocAuthorityRowMapper.selectAppDocDocList(appDocDoc);
    }
}
