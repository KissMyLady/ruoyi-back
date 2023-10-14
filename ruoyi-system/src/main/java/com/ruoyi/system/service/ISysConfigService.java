package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.SysConfig;

/**
 * 参数配置 服务层
 *
 * @author ruoyi
 */
public interface ISysConfigService {

    /**
     * 查询参数配置信息
     */
    SysConfig selectConfigById(Long configId);

    /**
     * 根据键名查询参数配置信息
     */
    String selectConfigByKey(String configKey);

    /**
     * 获取验证码开关
     *
     * @return true开启，false关闭
     */
    boolean selectCaptchaEnabled();

    /**
     * 查询参数配置列表
     */
    List<SysConfig> selectConfigList(SysConfig config);

    /**
     * 新增参数配置
     */
    int insertConfig(SysConfig config);

    /**
     * 修改参数配置
     */
    int updateConfig(SysConfig config);

    /**
     * 批量删除参数信息
     */
    void deleteConfigByIds(Long[] configIds);

    /**
     * 加载参数缓存数据
     */
    void loadingConfigCache();

    /**
     * 清空参数缓存数据
     */
    void clearConfigCache();

    /**
     * 重置参数缓存数据
     */
    void resetConfigCache();

    /**
     * 校验参数键名是否唯一
     *
     * @param config 参数信息
     * @return 结果
     */
    boolean checkConfigKeyUnique(SysConfig config);
}
