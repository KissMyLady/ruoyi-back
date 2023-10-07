package com.ruoyi.platform.app.zblog.v4_files.file_attachment.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.platform.app.zblog.v4_files.file_attachment.domain.FileAttachment;
import com.ruoyi.platform.app.zblog.v4_files.file_attachment.service.impl.FileAttachmentServiceImpl;
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
//import com.ruoyi.platform.app.files.file_attachment.service.IFileAttachmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * file_attachmentController
 *
 * @author mylady
 * @date 2023-10-07
 */
@RestController
@RequestMapping("/file_attachment/file_attachment")
public class FileAttachmentController extends BaseController {

    @Autowired
    private FileAttachmentServiceImpl fileAttachmentService;
    //private IFileAttachmentService fileAttachmentService;

    /**
     * 查询file_attachment列表
     */
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:list')")
    @GetMapping("/list")
    public TableDataInfo list(FileAttachment fileAttachment) {
        startPage();
        List<FileAttachment> list = fileAttachmentService.selectFileAttachmentList(fileAttachment);
        return getDataTable(list);
    }

    /**
     * 导出file_attachment列表
     */
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:export')")
    @Log(title = "导出file_attachment", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileAttachment fileAttachment) {
        List<FileAttachment> list = fileAttachmentService.selectFileAttachmentList(fileAttachment);
        ExcelUtil<FileAttachment> util = new ExcelUtil<FileAttachment>(FileAttachment.class);
        util.exportExcel(response, list, "file_attachment数据");
    }

    /**
     * 获取file_attachment详细信息
     */
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(fileAttachmentService.selectFileAttachmentById(id));
    }

    /**
     * 新增file_attachment
     */
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:add')")
    @Log(title = "新增file_attachment", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FileAttachment fileAttachment) {
        return toAjax(fileAttachmentService.insertFileAttachment(fileAttachment));
    }

    /**
     * 修改file_attachment
     */
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:edit')")
    @Log(title = "修改file_attachment", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FileAttachment fileAttachment) {
        return toAjax(fileAttachmentService.updateFileAttachment(fileAttachment));
    }

    /**
     * 删除file_attachment
     */
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:remove')")
    @Log(title = "删除file_attachment", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(fileAttachmentService.deleteFileAttachmentByIds(ids));
    }

}
