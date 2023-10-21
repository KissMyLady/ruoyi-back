package com.ruoyi.platform.app.openApi.request_api_key_log.controller;

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
import com.ruoyi.platform.app.openApi.request_api_key_log.domain.request_api_key_log;
//import com.ruoyi.platform.app.openApi.request_api_key_log.service.Irequest_api_key_logService;
import com.ruoyi.platform.app.openApi.request_api_key_log.service.impl.request_api_key_logServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.platform.app.openApi.request_api_key_log.mapper.request_api_key_logMapper;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * api请求记录Controller
 *
 * @author mylady
 * @date 2023-10-21
 */
@RestController
@RequestMapping("/request_api_key_log/request_api_key_log")
public class request_api_key_logController extends BaseController {

    @Autowired
    private request_api_key_logServiceImpl request_api_key_logService;
    //private Irequest_api_key_logService request_api_key_logService;

    @Autowired
    private request_api_key_logMapper request_api_key_logMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('request_api_key_log:request_api_key_log:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody request_api_key_log dto) {
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
        //List<request_api_key_log> list = request_api_key_logService.selectrequest_api_key_logList(dto);
        List<Map<String, Object>> mapList = request_api_key_logMapper.queryrequest_api_key_logList_BySQL(dto);
        int i = request_api_key_logMapper.queryrequest_api_key_logList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('request_api_key_log:request_api_key_log:export')")
    @Log(title = "导出api请求记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, request_api_key_log dto) {
        List<request_api_key_log> list = request_api_key_logService.selectrequest_api_key_logList(dto);
        ExcelUtil<request_api_key_log> util = new ExcelUtil<request_api_key_log>(request_api_key_log.class);
        util.exportExcel(response, list, "api请求记录数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('request_api_key_log:request_api_key_log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> res = request_api_key_logService.selectrequest_api_key_logById(id);
        //return success(request_api_key_logService.selectrequest_api_key_logById(id));
        //返回值加密
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增
     * request_api_key_log dto
     */
    @PreAuthorize("@ss.hasPermi('request_api_key_log:request_api_key_log:add')")
    @Log(title = "新增api请求记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }

        request_api_key_log dto = JSONUtil.toBean(encryptDto.getJsonObject(), request_api_key_log.class);
        return toAjax(request_api_key_logService.insertrequest_api_key_log(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('request_api_key_log:request_api_key_log:edit')")
    @Log(title = "修改api请求记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }

        request_api_key_log dto = JSONUtil.toBean(encryptDto.getJsonObject(), request_api_key_log.class);
        return toAjax(request_api_key_logService.updaterequest_api_key_log(dto));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('request_api_key_log:request_api_key_log:remove')")
    @Log(title = "删除api请求记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(request_api_key_logService.deleterequest_api_key_logByIds(ids));
    }

}
