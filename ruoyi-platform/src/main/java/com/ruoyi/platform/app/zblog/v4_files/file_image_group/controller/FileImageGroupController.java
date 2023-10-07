package com.ruoyi.platform.app.zblog.v4_files.file_image_group.controller;

import java.util.List;
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
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.platform.app.zblog.v4_files.file_image_group.domain.FileImageGroup;
//import com.ruoyi.platform.app.zblog.v4_files.file_image_group.service.IFileImageGroupService;
import com.ruoyi.platform.app.zblog.v4_files.file_image_group.service.impl.FileImageGroupServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * file_image_groupController
 *
 * @author mylady
 * @date 2023-10-07
 */
@RestController
@RequestMapping("/file_image_group/file_image_group")
public class FileImageGroupController extends BaseController {

    @Autowired
    private FileImageGroupServiceImpl fileImageGroupService;
    //private IFileImageGroupService fileImageGroupService;

    /**
     * 查询file_image_group列表
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:list')")
    @GetMapping("/list")
    public TableDataInfo list(FileImageGroup fileImageGroup) {
        startPage();
        List<FileImageGroup> list = fileImageGroupService.selectFileImageGroupList(fileImageGroup);
        return getDataTable(list);
    }

    /**
     * 导出file_image_group列表
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:export')")
    @Log(title = "导出file_image_group", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileImageGroup fileImageGroup) {
        List<FileImageGroup> list = fileImageGroupService.selectFileImageGroupList(fileImageGroup);
        ExcelUtil<FileImageGroup> util = new ExcelUtil<FileImageGroup>(FileImageGroup.class);
        util.exportExcel(response, list, "file_image_group数据");
    }

    /**
     * 获取file_image_group详细信息
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(fileImageGroupService.selectFileImageGroupById(id));
    }

    /**
     * 新增file_image_group
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:add')")
    @Log(title = "新增file_image_group", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FileImageGroup fileImageGroup) {
        return toAjax(fileImageGroupService.insertFileImageGroup(fileImageGroup));
    }

    /**
     * 修改file_image_group
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:edit')")
    @Log(title = "修改file_image_group", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FileImageGroup fileImageGroup) {
        return toAjax(fileImageGroupService.updateFileImageGroup(fileImageGroup));
    }

    /**
     * 删除file_image_group
     */
    @PreAuthorize("@ss.hasPermi('file_image_group:file_image_group:remove')")
    @Log(title = "删除file_image_group", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(fileImageGroupService.deleteFileImageGroupByIds(ids));
    }

}
