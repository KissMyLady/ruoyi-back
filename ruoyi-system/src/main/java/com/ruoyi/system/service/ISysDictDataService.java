package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDictData;

/**
 * 字典 业务层
 *
 * @author ruoyi
 */
public interface ISysDictDataService {
    /**
     * 根据条件分页查询字典数据
     */
    List<SysDictData> selectDictDataList(SysDictData dictData);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     */
    String selectDictLabel(String dictType, String dictValue);

    /**
     * 根据字典数据ID查询信息
     */
    SysDictData selectDictDataById(Long dictCode);

    /**
     * 批量删除
     */
    void deleteDictDataByIds(Long[] dictCodes);

    /**
     * 新增保存
     */
    int insertDictData(SysDictData dictData);

    /**
     * 修改保存
     */
    int updateDictData(SysDictData dictData);
}
