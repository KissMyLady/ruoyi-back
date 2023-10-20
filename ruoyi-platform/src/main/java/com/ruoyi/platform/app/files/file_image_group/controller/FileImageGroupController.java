package com.ruoyi.platform.app.files.file_image_group.controller;

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
import com.ruoyi.platform.app.files.file_image_group.domain.FileImageGroup;
//import com.ruoyi.platform.app.files.file_image_group.service.IFileImageGroupService;
import com.ruoyi.platform.app.files.file_image_group.service.impl.FileImageGroupServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.platform.app.files.file_image_group.mapper.FileImageGroupMapper;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片分组Controller
 *
 * @author mylady
 * @date 2023-10-15
 */
@RestController
@RequestMapping("/file_image_group/file_image_group")
public class FileImageGroupController extends BaseController {

    @Autowired
    private FileImageGroupServiceImpl fileImageGroupService;
    //private IFileImageGroupService fileImageGroupService;

    @Autowired
    private FileImageGroupMapper fileImageGroupMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody FileImageGroup dto) {
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
        //List<FileImageGroup> list = fileImageGroupService.selectFileImageGroupList(dto);
        List<Map<String, Object>> mapList = fileImageGroupMapper.queryFileImageGroupList_BySQL(dto);
        int i = fileImageGroupMapper.queryFileImageGroupList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:export')")
    @Log(title = "导出图片分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileImageGroup dto) {
        List<FileImageGroup> list = fileImageGroupService.selectFileImageGroupList(dto);
        ExcelUtil<FileImageGroup> util = new ExcelUtil<FileImageGroup>(FileImageGroup.class);
        util.exportExcel(response, list, "图片分组数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> res = fileImageGroupService.selectFileImageGroupById(id);
        //return success(fileImageGroupService.selectFileImageGroupById(id));
        //返回值加密
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增
     * FileImageGroup dto
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:add')")
    @Log(title = "新增图片分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }

        FileImageGroup dto = JSONUtil.toBean(encryptDto.getJsonObject(), FileImageGroup.class);
        return toAjax(fileImageGroupService.insertFileImageGroup(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:edit')")
    @Log(title = "修改图片分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }

        FileImageGroup dto = JSONUtil.toBean(encryptDto.getJsonObject(), FileImageGroup.class);
        return toAjax(fileImageGroupService.updateFileImageGroup(dto));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:remove')")
    @Log(title = "删除图片分组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(fileImageGroupService.deleteFileImageGroupByIds(ids));
    }

}