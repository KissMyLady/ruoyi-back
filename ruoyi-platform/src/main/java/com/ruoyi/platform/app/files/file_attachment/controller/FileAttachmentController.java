package com.ruoyi.platform.app.files.file_attachment.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.platform.app.files.file_attachment.mapper.FileAttachmentMapper;
import com.ruoyi.platform.app.files.file_attachment.service.impl.FileUploadServiceImpl;
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
import com.ruoyi.platform.app.files.file_attachment.domain.FileAttachment;
//import com.ruoyi.platform.app.files.file_attachment.service.IFileAttachmentService;
import com.ruoyi.platform.app.files.file_attachment.service.impl.FileAttachmentServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 附件Controller
 *
 * @author mylady
 * @date 2023-10-15
 */
@RestController
@RequestMapping("/file_attachment/file_attachment")
public class FileAttachmentController extends BaseController {

    @Autowired
    private FileAttachmentServiceImpl fileAttachmentService;
    //private IFileAttachmentService fileAttachmentService;

    @Autowired
    private FileAttachmentMapper fileAttachmentMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    @Autowired
    private FileUploadServiceImpl fileUploadService;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody FileAttachment dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setUserId(null);
        }else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }
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
        //List<FileAttachment> list = fileAttachmentService.selectFileAttachmentList(dto);
        List<Map<String, Object>> mapList = fileAttachmentMapper.queryFileAttachmentList_BySQL(dto);
        int i = fileAttachmentMapper.queryFileAttachmentList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:export')")
    @Log(title = "导出附件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileAttachment dto) {
        List<FileAttachment> list = fileAttachmentService.selectFileAttachmentList(dto);
        ExcelUtil<FileAttachment> util = new ExcelUtil<FileAttachment>(FileAttachment.class);
        util.exportExcel(response, list, "附件数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> stringObjectMap = fileAttachmentService.selectFileAttachmentById(id);
        //return success(fileAttachmentService.selectFileAttachmentById(id));
        //返回值加密
        // logger.info("查询结果打印: {}", stringObjectMap);
        return AjaxResult.success_ok(stringObjectMap, "操作成功");
    }

    /**
     * 新增
     * FileAttachment dto
     */
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:add')")
    @Log(title = "新增附件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }

        FileAttachment dto = JSONUtil.toBean(encryptDto.getJsonObject(), FileAttachment.class);
        return toAjax(fileAttachmentService.insertFileAttachment(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:edit')")
    @Log(title = "修改附件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE(), enDto.toString());
        }

        FileAttachment dto = JSONUtil.toBean(encryptDto.getJsonObject(), FileAttachment.class);
        return toAjax(fileAttachmentService.updateFileAttachment(dto));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('file_attachment:file_attachment:remove')")
    @Log(title = "删除附件", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        //删除文件
        String res = fileUploadService.deleteFiles(ids);
        //删除数据
        int i = fileAttachmentService.deleteFileAttachmentByIds(ids);
        return AjaxResult.success(res + " 删除数据成功: " + i);
    }

}
