package com.ruoyi.platform.app.msg.tb_msg.controller;

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
import com.ruoyi.platform.app.msg.tb_msg.domain.tb_msg;
//import com.ruoyi.platform.app.msg.tb_msg.service.Itb_msgService;
import com.ruoyi.platform.app.msg.tb_msg.service.impl.tb_msgServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.platform.app.msg.tb_msg.mapper.tb_msgMapper;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消息Controller
 *
 * @author mylady
 * @date 2023-10-21
 */
@RestController
@RequestMapping("/tb_msg/tb_msg")
public class tb_msgController extends BaseController {

    @Autowired
    private tb_msgServiceImpl tb_msgService;
    //private Itb_msgService tb_msgService;

    @Autowired
    private tb_msgMapper tb_msgMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('tb_msg:tb_msg:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody tb_msg dto) {
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
        //List<tb_msg> list = tb_msgService.selecttb_msgList(dto);
        List<Map<String, Object>> mapList = tb_msgMapper.querytb_msgList_BySQL(dto);
        int i = tb_msgMapper.querytb_msgList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('tb_msg:tb_msg:export')")
    @Log(title = "导出消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, tb_msg dto) {
        List<tb_msg> list = tb_msgService.selecttb_msgList(dto);
        ExcelUtil<tb_msg> util = new ExcelUtil<tb_msg>(tb_msg.class);
        util.exportExcel(response, list, "消息数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('tb_msg:tb_msg:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> res = tb_msgService.selecttb_msgById(id);
        //return success(tb_msgService.selecttb_msgById(id));
        //返回值加密
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增
     * tb_msg dto
     */
    @PreAuthorize("@ss.hasPermi('tb_msg:tb_msg:add')")
    @Log(title = "新增消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }

        tb_msg dto = JSONUtil.toBean(encryptDto.getJsonObject(), tb_msg.class);
        return toAjax(tb_msgService.inserttb_msg(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('tb_msg:tb_msg:edit')")
    @Log(title = "修改消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }

        tb_msg dto = JSONUtil.toBean(encryptDto.getJsonObject(), tb_msg.class);
        return toAjax(tb_msgService.updatetb_msg(dto));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('tb_msg:tb_msg:remove')")
    @Log(title = "删除消息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tb_msgService.deletetb_msgByIds(ids));
    }

}
