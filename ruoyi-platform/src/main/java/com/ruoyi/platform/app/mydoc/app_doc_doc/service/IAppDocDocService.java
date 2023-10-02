package com.ruoyi.platform.app.mydoc.app_doc_doc.service;

import java.util.List;

import com.ruoyi.platform.app.mydoc.app_doc_doc.domain.AppDocDoc;

/**
 * app_doc_docService接口
 *
 * @author mylady
 * @date 2023-10-02
 */
public interface IAppDocDocService {
    /**
     * 查询app_doc_doc
     *
     * @param id app_doc_doc主键
     * @return app_doc_doc
     */
    public AppDocDoc selectAppDocDocById(Long id);

    /**
     * 查询app_doc_doc列表
     *
     * @param appDocDoc app_doc_doc
     * @return app_doc_doc集合
     */
    public List<AppDocDoc> selectAppDocDocList(AppDocDoc appDocDoc);

    /**
     * 新增app_doc_doc
     *
     * @param appDocDoc app_doc_doc
     * @return 结果
     */
    public int insertAppDocDoc(AppDocDoc appDocDoc);

    /**
     * 修改app_doc_doc
     *
     * @param appDocDoc app_doc_doc
     * @return 结果
     */
    public int updateAppDocDoc(AppDocDoc appDocDoc);

    /**
     * 批量删除app_doc_doc
     *
     * @param ids 需要删除的app_doc_doc主键集合
     * @return 结果
     */
    public int deleteAppDocDocByIds(Long[] ids);

    /**
     * 删除app_doc_doc信息
     *
     * @param id app_doc_doc主键
     * @return 结果
     */
    public int deleteAppDocDocById(Long id);
}
