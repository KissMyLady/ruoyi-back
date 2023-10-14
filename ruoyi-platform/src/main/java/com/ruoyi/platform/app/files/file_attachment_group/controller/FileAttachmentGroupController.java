package com.ruoyi.platform.app.files.file_attachment_group.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.platform.app.files.file_attachment_group.mapper.FileAttachmentGroupMapper;
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
import com.ruoyi.common.annotation.ReturnAESEncrypt;
import com.ruoyi.platform.app.files.file_attachment_group.domain.FileAttachmentGroup;
//import com.ruoyi.platform.app.files.file_attachment_group.service.IFileAttachmentGroupService;
import com.ruoyi.platform.app.files.file_attachment_group.service.impl.FileAttachmentGroupServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 附件分组Controller
 *
 * @author mylady
 * @date 2023-10-14
 */
@RestController
@RequestMapping("/file_attachment_group/file_attachment_group")
public class FileAttachmentGroupController extends BaseController {

    @Autowired
    private FileAttachmentGroupServiceImpl fileAttachmentGroupService;
    //private IFileAttachmentGroupService fileAttachmentGroupService;

    @Autowired
    private FileAttachmentGroupMapper fileAttachmentGroupMapper;

    /**
     * 查询附件分组列表
     */
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:list')")
    @GetMapping("/list")
    public TableDataInfo list(FileAttachmentGroup dto) {
        //startPage();
        Integer page = dto.getPageNum();
        if (page <= 0 || page == null) {
            page = 1;
        }
        Integer pageSize = dto.getPageSize();
        page = (page - 1) * pageSize;
        dto.setPageNum(page);

        //sql排序字符串
        if (ObjectUtil.isEmpty(dto.getSortStr())) {
            dto.setSortStr("create_time");
        }

        List<FileAttachmentGroup> list = fileAttachmentGroupService.selectFileAttachmentGroupList(dto);

        int i = fileAttachmentGroupMapper.queryFileAttachmentGroupList_count(dto);

        return getDataTable(list, i);
    }

    /**
     * 查询列表, SQL分页查询
     */
    //@ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:list')")
    @PostMapping("/list_sql")
    public TableDataInfo list_sql(@RequestBody FileAttachmentGroup dto) {
        startPage();
        List<Map<String, Objects>> mapList = fileAttachmentGroupMapper.queryFileAttachmentGroupList_BySQL(dto);

        int i = fileAttachmentGroupMapper.queryFileAttachmentGroupList_count(dto);
        logger.info("查询数据打印: {}", mapList.toString());
        return getDataTable(mapList, i);
    }


    /**
     * 导出附件分组列表
     */
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:export')")
    @Log(title = "导出附件分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileAttachmentGroup dto) {
        List<FileAttachmentGroup> list = fileAttachmentGroupService.selectFileAttachmentGroupList(dto);
        ExcelUtil<FileAttachmentGroup> util = new ExcelUtil<FileAttachmentGroup>(FileAttachmentGroup.class);
        util.exportExcel(response, list, "附件分组数据");
    }

    /**
     * 获取附件分组详细信息
     */
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(fileAttachmentGroupService.selectFileAttachmentGroupById(id));
    }

    /**
     * 新增附件分组
     */
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:add')")
    @Log(title = "新增附件分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FileAttachmentGroup dto) {
        return toAjax(fileAttachmentGroupService.insertFileAttachmentGroup(dto));
    }

    /**
     * 修改附件分组
     */
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:edit')")
    @Log(title = "修改附件分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FileAttachmentGroup dto) {
        return toAjax(fileAttachmentGroupService.updateFileAttachmentGroup(dto));
    }

    /**
     * 删除附件分组
     */
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:remove')")
    @Log(title = "删除附件分组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(fileAttachmentGroupService.deleteFileAttachmentGroupByIds(ids));
    }

}
