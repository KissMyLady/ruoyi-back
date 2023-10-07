package com.ruoyi.platform.app.zblog.v4_files.file_image.controller;

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
import com.ruoyi.platform.app.zblog.v4_files.file_image.domain.FileImage;
//import com.ruoyi.platform.app.zblog.v4_files.file_image.service.IFileImageService;
import com.ruoyi.platform.app.zblog.v4_files.file_image.service.impl.FileImageServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 素材图片Controller
 *
 * @author mylady
 * @date 2023-10-07
 */
@RestController
@RequestMapping("/file_image/file_image")
public class FileImageController extends BaseController {

    @Autowired
    private FileImageServiceImpl fileImageService;
    //private IFileImageService fileImageService;

    /**
     * 查询素材图片列表
     */
    @PreAuthorize("@ss.hasPermi('file_image:file_image:list')")
    @GetMapping("/list")
    public TableDataInfo list(FileImage fileImage) {
        startPage();
        List<FileImage> list = fileImageService.selectFileImageList(fileImage);
        return getDataTable(list);
    }

    /**
     * 导出素材图片列表
     */
    @PreAuthorize("@ss.hasPermi('file_image:file_image:export')")
    @Log(title = "导出素材图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileImage fileImage) {
        List<FileImage> list = fileImageService.selectFileImageList(fileImage);
        ExcelUtil<FileImage> util = new ExcelUtil<FileImage>(FileImage.class);
        util.exportExcel(response, list, "素材图片数据");
    }

    /**
     * 获取素材图片详细信息
     */
    @PreAuthorize("@ss.hasPermi('file_image:file_image:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(fileImageService.selectFileImageById(id));
    }

    /**
     * 新增素材图片
     */
    @PreAuthorize("@ss.hasPermi('file_image:file_image:add')")
    @Log(title = "新增素材图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FileImage fileImage) {
        return toAjax(fileImageService.insertFileImage(fileImage));
    }

    /**
     * 修改素材图片
     */
    @PreAuthorize("@ss.hasPermi('file_image:file_image:edit')")
    @Log(title = "修改素材图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FileImage fileImage) {
        return toAjax(fileImageService.updateFileImage(fileImage));
    }

    /**
     * 删除素材图片
     */
    @PreAuthorize("@ss.hasPermi('file_image:file_image:remove')")
    @Log(title = "删除素材图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(fileImageService.deleteFileImageByIds(ids));
    }

}
