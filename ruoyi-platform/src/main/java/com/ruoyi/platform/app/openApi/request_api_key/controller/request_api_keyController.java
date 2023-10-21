package com.ruoyi.platform.app.openApi.request_api_key.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.EncryptDto;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.annotation.ReturnAESEncrypt;
import com.ruoyi.common.security.EncryptUtilsService;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.platform.app.openApi.request_api_key.domain.request_api_key;
//import com.ruoyi.platform.app.openApi.request_api_key.service.Irequest_api_keyService;
import com.ruoyi.platform.app.openApi.request_api_key.service.impl.request_api_keyServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.platform.app.openApi.request_api_key.mapper.request_api_keyMapper;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * api请求-keyController
 *
 * @author mylady
 * @date 2023-10-21
 */
@RestController
@RequestMapping("/request_api_key/request_api_key")
public class request_api_keyController extends BaseController {

    @Autowired
    private request_api_keyServiceImpl request_api_keyService;
    //private Irequest_api_keyService request_api_keyService;

    @Autowired
    private request_api_keyMapper request_api_keyMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody request_api_key dto) {
        Integer page = dto.getPageNum();
        if (page <= 0 || page == null) {
            page = 1;
        }
        Integer pageSize = dto.getPageSize();
        page = (page - 1) * pageSize;
        dto.setPageNum(page);
        //sql排序字符串
        if (!ObjectUtil.isEmpty(dto.getSortStr())) {
            //如果不为空, 判断字符串是否合法
            String sortStr = dto.getSortStr();
            // logger.info("如果排序字符串不为空, 判断是否合法: {}" , sortStr);
        }
        //List<request_api_key> list = request_api_keyService.selectrequest_api_keyList(dto);
        List<Map<String, Object>> mapList = request_api_keyMapper.queryrequest_api_keyList_BySQL(dto);
        int i = request_api_keyMapper.queryrequest_api_keyList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:export')")
    @Log(title = "导出api请求-key", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, request_api_key dto) {
        List<request_api_key> list = request_api_keyService.selectrequest_api_keyList(dto);
        ExcelUtil<request_api_key> util = new ExcelUtil<request_api_key>(request_api_key.class);
        util.exportExcel(response, list, "api请求-key数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> res = request_api_keyService.selectrequest_api_keyById(id);
        //return success(request_api_keyService.selectrequest_api_keyById(id));
        //返回值加密
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增
     * request_api_key dto
     */
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:add')")
    @Log(title = "新增api请求-key", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }

        request_api_key dto = JSONUtil.toBean(encryptDto.getJsonObject(), request_api_key.class);
        return toAjax(request_api_keyService.insertrequest_api_key(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:edit')")
    @Log(title = "修改api请求-key", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }
        request_api_key dto = JSONUtil.toBean(encryptDto.getJsonObject(), request_api_key.class);
        //respKey 值不允许被修改
        dto.setRespKey(null);
        return toAjax(request_api_keyService.updaterequest_api_key(dto));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:remove')")
    @Log(title = "删除api请求-key", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(request_api_keyService.deleterequest_api_keyByIds(ids));
    }

}
