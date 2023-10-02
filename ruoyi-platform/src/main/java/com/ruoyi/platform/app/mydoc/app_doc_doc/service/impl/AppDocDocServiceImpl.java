package com.ruoyi.platform.app.mydoc.app_doc_doc.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.mydoc.app_doc_doc.mapper.AppDocDocMapper;
import com.ruoyi.platform.app.mydoc.app_doc_doc.domain.AppDocDoc;
import com.ruoyi.platform.app.mydoc.app_doc_doc.service.IAppDocDocService;

/**
 * app_doc_docService业务层处理
 *
 * @author mylady
 * @date 2023-10-02
 */
@Service
public class AppDocDocServiceImpl implements IAppDocDocService {
    @Autowired
    private AppDocDocMapper appDocDocMapper;

    /**
     * 查询app_doc_doc
     *
     * @param id app_doc_doc主键
     * @return app_doc_doc
     */
    @Override
    public AppDocDoc selectAppDocDocById(Long id) {
        return appDocDocMapper.selectAppDocDocById(id);
    }

    /**
     * 查询app_doc_doc列表
     *
     * @param appDocDoc app_doc_doc
     * @return app_doc_doc
     */
    @Override
    public List<AppDocDoc> selectAppDocDocList(AppDocDoc appDocDoc) {
        return appDocDocMapper.selectAppDocDocList(appDocDoc);
    }

    /**
     * 新增app_doc_doc
     *
     * @param appDocDoc app_doc_doc
     * @return 结果
     */
    @Override
    public int insertAppDocDoc(AppDocDoc appDocDoc) {
                appDocDoc.setCreateTime(DateUtils.getNowDate());
            return appDocDocMapper.insertAppDocDoc(appDocDoc);
    }

    /**
     * 修改app_doc_doc
     *
     * @param appDocDoc app_doc_doc
     * @return 结果
     */
    @Override
    public int updateAppDocDoc(AppDocDoc appDocDoc) {
        return appDocDocMapper.updateAppDocDoc(appDocDoc);
    }

    /**
     * 批量删除app_doc_doc
     *
     * @param ids 需要删除的app_doc_doc主键
     * @return 结果
     */
    @Override
    public int deleteAppDocDocByIds(Long[] ids) {
        return appDocDocMapper.deleteAppDocDocByIds(ids);
    }

    /**
     * 删除app_doc_doc信息
     *
     * @param id app_doc_doc主键
     * @return 结果
     */
    @Override
    public int deleteAppDocDocById(Long id) {
        return appDocDocMapper.deleteAppDocDocById(id);
    }
}
