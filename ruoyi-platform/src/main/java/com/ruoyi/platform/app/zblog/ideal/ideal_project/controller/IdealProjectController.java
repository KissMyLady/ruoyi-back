package com.ruoyi.platform.app.zblog.ideal.ideal_project.controller;

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
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.EncryptDto;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.annotation.ReturnAESEncrypt;
import com.ruoyi.common.security.EncryptUtilsService;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.platform.app.zblog.ideal.ideal_project.domain.IdealProject;
//import com.ruoyi.platform.app.zblog.ideal.ideal_project.service.IIdealProjectService;
import com.ruoyi.platform.app.zblog.ideal.ideal_project.service.impl.IdealProjectServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.platform.app.zblog.ideal.ideal_project.mapper.IdealProjectMapper;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 分类Controller
 *
 * @author mylady
 * @date 2023-10-29
 */
@RestController
@RequestMapping("/ideal_project/ideal_project")
public class IdealProjectController extends BaseController {

    @Autowired
    private IdealProjectServiceImpl idealProjectService;
    //private IIdealProjectService idealProjectService;

    @Autowired
    private IdealProjectMapper idealProjectMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('ideal_project:ideal_project:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody IdealProject dto) {
        //设置用户可见
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setUserId(null);
        }else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }
        //分页
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
        //List<IdealProject> list = idealProjectService.selectIdealProjectList(dto);
        List<Map<String, Object>> mapList = idealProjectMapper.queryIdealProjectList_BySQL(dto);
        int i = idealProjectMapper.queryIdealProjectList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('ideal_project:ideal_project:export')")
    @Log(title = "导出分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, IdealProject dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setUserId(null);
        }else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }
        List<IdealProject> list = idealProjectService.selectIdealProjectList(dto);
        ExcelUtil<IdealProject> util = new ExcelUtil<IdealProject>(IdealProject.class);
        util.exportExcel(response, list, "分类数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('ideal_project:ideal_project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> res = idealProjectService.selectIdealProjectById(id);
        //return success(idealProjectService.selectIdealProjectById(id));
        //返回值加密
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增
     * IdealProject dto
     */
    @PreAuthorize("@ss.hasPermi('ideal_project:ideal_project:add')")
    @Log(title = "新增分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }

        IdealProject dto = JSONUtil.toBean(encryptDto.getJsonObject(), IdealProject.class);
        SysUser user = SecurityUtils.getLoginUser().getUser();
        dto.setUserId(user.getUserId());
        return toAjax(idealProjectService.insertIdealProject(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('ideal_project:ideal_project:edit')")
    @Log(title = "修改分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }

        IdealProject dto = JSONUtil.toBean(encryptDto.getJsonObject(), IdealProject.class);
        return toAjax(idealProjectService.updateIdealProject(dto));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('ideal_project:ideal_project:remove')")
    @Log(title = "删除分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(idealProjectService.deleteIdealProjectByIds(ids));
    }

}
