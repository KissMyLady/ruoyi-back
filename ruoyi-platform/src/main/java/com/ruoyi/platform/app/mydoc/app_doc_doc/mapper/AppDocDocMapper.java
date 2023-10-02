package com.ruoyi.platform.app.mydoc.app_doc_doc.mapper;

import java.util.List;
import com.ruoyi.platform.app.mydoc.app_doc_doc.domain.AppDocDoc;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * app_doc_docMapper接口
 *
 * @author mylady
 * @date 2023-10-02
 */
//@DataSource(value = DataSourceType.MASTER)
public interface AppDocDocMapper {
    /**
     * 查询app_doc_doc
     *
     * @param id app_doc_doc主键
     * @return app_doc_doc
     */
    AppDocDoc selectAppDocDocById(Long id);

    /**
     * 查询app_doc_doc列表
     *
     * @param appDocDoc app_doc_doc
     * @return app_doc_doc集合
     */
    List<AppDocDoc> selectAppDocDocList(AppDocDoc appDocDoc);

    /**
     * 新增app_doc_doc
     *
     * @param appDocDoc app_doc_doc
     * @return 结果
     */
    int insertAppDocDoc(AppDocDoc appDocDoc);

    /**
     * 修改app_doc_doc
     *
     * @param appDocDoc app_doc_doc
     * @return 结果
     */
    int updateAppDocDoc(AppDocDoc appDocDoc);

    /**
     * 删除app_doc_doc
     *
     * @param id app_doc_doc主键
     * @return 结果
     */
    int deleteAppDocDocById(Long id);

    /**
     * 批量删除app_doc_doc
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteAppDocDocByIds(Long[] ids);

}
