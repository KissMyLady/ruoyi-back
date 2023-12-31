package com.ruoyi.platform.app.files.file_attachment_group.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.common.core.domain.EncryptDto;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.security.EncryptUtilsService;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.platform.app.files.file_attachment.mapper.FileAttachmentMapper;
import com.ruoyi.platform.app.files.file_attachment_group.mapper.FileAttachmentGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(FileAttachmentGroupController.class);

    @Autowired
    private FileAttachmentGroupServiceImpl fileAttachmentGroupService;
    //private IFileAttachmentGroupService fileAttachmentGroupService;

    @Autowired
    private FileAttachmentGroupMapper fileAttachmentGroupMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    @Autowired
    private FileAttachmentMapper fileAttachmentMapper;

    /**
     * 查询列表, SQL分页查询
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:list')")
    @PostMapping("/list_sql")
    public TableDataInfo list_sql(@RequestBody FileAttachmentGroup dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setUserId(null);
        }else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }
        //startPage();
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
        }
        List<Map<String, Object>> mapList = fileAttachmentGroupMapper.queryFileAttachmentGroupList_BySQL(dto);
        int i = fileAttachmentGroupMapper.queryFileAttachmentGroupList_count(dto);
        // logger.info("查询数据打印: {}", mapList.toString());
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出附件分组列表
     */
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:export')")
    @Log(title = "导出附件分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileAttachmentGroup dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setUserId(null);
        }else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }
        List<FileAttachmentGroup> list = fileAttachmentGroupService.selectFileAttachmentGroupList(dto);
        ExcelUtil<FileAttachmentGroup> util = new ExcelUtil<FileAttachmentGroup>(FileAttachmentGroup.class);
        util.exportExcel(response, list, "附件分组数据");
    }

    /**
     * 获取附件分组详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        //返回值加密
        Map<String, Object> res = fileAttachmentGroupService.selectFileAttachmentGroupById(id);
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增附件分组
     */
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:add')")
    @Log(title = "新增附件分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }
        FileAttachmentGroup dto = JSONUtil.toBean(encryptDto.getJsonObject(), FileAttachmentGroup.class);
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        dto.setUserId(userId);
        return toAjax(fileAttachmentGroupService.insertFileAttachmentGroup(dto));
    }

    /**
     * 修改附件分组
     */
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:edit')")
    @Log(title = "修改附件分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }
        FileAttachmentGroup dto = JSONUtil.toBean(encryptDto.getJsonObject(), FileAttachmentGroup.class);

        //不允许修改 code字段
        //检查是否允许修改group_id字段
        Map<String, Object> stringObjectMap = fileAttachmentGroupMapper.selectFileAttachmentGroupById(dto.getId());

        StringBuilder sb = new StringBuilder();
        //校验字段是否存在
        if(ObjectUtil.isNotEmpty(dto.getGroupId())
                && ObjectUtil.isNotEmpty(stringObjectMap.get("groupId"))
        ){
            long old_group_id = Long.parseLong(String.valueOf((Integer) stringObjectMap.get("groupId")));
            long new_group_id = dto.getGroupId();
            //新旧数据不一致, 修改判断
            if (!Objects.equals(old_group_id, new_group_id)) {
                List<Map<String, Object>> maps = fileAttachmentMapper.select_file_by_group_id(old_group_id);
                if (ObjectUtil.isNotEmpty(maps) && maps.size() >= 1) {
                    dto.setGroupId(null);
                    sb.append("当前组下存在文件数据,code字段不允许修改.");
                    sb.append("其他字段");
                }
            }
        }
        dto.setUserId(null); //创建用户不允许修改
        int i = fileAttachmentGroupService.updateFileAttachmentGroup(dto);
        sb.append("修改成功: ");
        sb.append(i);
        return AjaxResult.success(sb.toString());
    }

    /**
     * 删除附件分组
     */
    @PreAuthorize("@ss.hasPermi('file_attachment_group:file_attachment_group:remove')")
    @Log(title = "删除附件分组", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        for (long db_id : ids) {
            //查询组数据
            Map<String, Object> stringObjectMap = fileAttachmentGroupMapper.selectFileAttachmentGroupById(db_id);
            //logger.info("打印stringObjectMap: {}", stringObjectMap);
            //根据组数据查询 组下的文件
            long groupId = Long.parseLong(String.valueOf((Integer) stringObjectMap.get("groupId")));
            List<Map<String, Object>> maps = fileAttachmentMapper.select_file_by_group_id(groupId);
            //logger.info("根据组数据查询 组下的文件大小: {}", maps.size());
            if (ObjectUtil.isNotEmpty(maps) && maps.size() >= 1) {
                return AjaxResult.error("当前组存在文件数据, 不允许删除.");
            }
        }
        return toAjax(fileAttachmentGroupService.deleteFileAttachmentGroupByIds(ids));
    }

}
