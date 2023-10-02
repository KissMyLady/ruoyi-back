package com.ruoyi.platform.app.mydoc.app_doc_doc.service;

import com.ruoyi.platform.app.mydoc.app_doc_doc.domain.AppDocDoc;

import java.util.List;
import java.util.Map;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/2 19:45
 * @Description:
 */
public interface IAppDocDocAuthorityServer {


    List<Map<String, Object>> selectAppDocDocList(AppDocDoc appDocDoc);

}
