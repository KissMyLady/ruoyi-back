package com.ruoyi.platform.app.files.file_image.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.platform.app.files.file_image.service.impl.FileImageUploadServiceImpl;
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
import com.ruoyi.platform.app.files.file_image.domain.file_image;
//import com.ruoyi.platform.app.files.file_image.service.Ifile_imageService;
import com.ruoyi.platform.app.files.file_image.service.impl.file_imageServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.platform.app.files.file_image.mapper.file_imageMapper;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 素材图片Controller
 *
 * @author mylady
 * @date 2023-10-20
 */
@RestController
@RequestMapping("/file_image/file_image")
public class file_imageController extends BaseController {

    @Autowired
    private file_imageServiceImpl file_imageService;
    //private Ifile_imageService file_imageService;

    @Autowired
    private file_imageMapper file_imageMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    @Autowired
    private FileImageUploadServiceImpl fileImageUploadService;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('file_image:file_image:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody file_image dto) {
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
        //List<file_image> list = file_imageService.selectfile_imageList(dto);
        List<Map<String, Object>> mapList = file_imageMapper.queryfile_imageList_BySQL(dto);
        int i = file_imageMapper.queryfile_imageList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('file_image:file_image:export')")
    @Log(title = "导出素材图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, file_image dto) {
        List<file_image> list = file_imageService.selectfile_imageList(dto);
        ExcelUtil<file_image> util = new ExcelUtil<file_image>(file_image.class);
        util.exportExcel(response, list, "素材图片数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('file_image:file_image:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> res = file_imageService.selectfile_imageById(id);
        //return success(file_imageService.selectfile_imageById(id));
        //返回值加密
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增
     * file_image dto
     */
    @PreAuthorize("@ss.hasPermi('file_image:file_image:add')")
    @Log(title = "新增素材图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }

        file_image dto = JSONUtil.toBean(encryptDto.getJsonObject(), file_image.class);
        return toAjax(file_imageService.insertfile_image(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('file_image:file_image:edit')")
    @Log(title = "修改素材图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }

        file_image dto = JSONUtil.toBean(encryptDto.getJsonObject(), file_image.class);
        return toAjax(file_imageService.updatefile_image(dto));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('file_image:file_image:remove')")
    @Log(title = "删除素材图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        //删除文件
        String res = fileImageUploadService.deleteFiles(ids);

        //删除数据
        int i = file_imageService.deletefile_imageByIds(ids);

        return AjaxResult.success(res + " 删除数据成功: " + i);
    }

}
