package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.domain.entity.SysDictType;

/**
 * 字典 业务层
 *
 * @author ruoyi
 */
public interface ISysDictTypeService {

    /**
     * 根据条件分页查询字典类型
     */
    List<SysDictType> selectDictTypeList(SysDictType dictType);

    /**
     * 根据所有字典类型
     */
    List<SysDictType> selectDictTypeAll();

    /**
     * 根据字典类型查询字典数据
     */
    List<SysDictData> selectDictDataByType(String dictType);

    /**
     * 根据字典类型ID查询信息
     */
    SysDictType selectDictTypeById(Long dictId);

    /**
     * 根据字典类型查询信息
     */
    SysDictType selectDictTypeByType(String dictType);

    /**
     * 批量删除字典信息
     */
    void deleteDictTypeByIds(Long[] dictIds);

    /**
     * 加载字典缓存数据
     */
    void loadingDictCache();

    /**
     * 清空字典缓存数据
     */
    void clearDictCache();

    /**
     * 重置字典缓存数据
     */
    void resetDictCache();

    /**
     * 新增保存字典类型信息
     */
    int insertDictType(SysDictType dictType);

    /**
     * 修改保存字典类型信息
     */
    int updateDictType(SysDictType dictType);

    /**
     * 校验字典类型称是否唯一
     */
    boolean checkDictTypeUnique(SysDictType dictType);
}
