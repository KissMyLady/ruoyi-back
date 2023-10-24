package com.ruoyi.platform.app.zblog.blog.blog_project.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.platform.app.zblog.blog.blog_project.domain.BlogProject;
//import com.ruoyi.platform.app.zblog.blog.blog_project.service.IBlogProjectService;
import com.ruoyi.platform.app.zblog.blog.blog_project.service.impl.BlogProjectServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.platform.app.zblog.blog.blog_project.mapper.BlogProjectMapper;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博客文集Controller
 *
 * @author mylady
 * @date 2023-10-24
 */
@RestController
@RequestMapping("/blog_project/blog_project")
public class BlogProjectController extends BaseController {

    @Autowired
    private BlogProjectServiceImpl blogProjectService;
    //private IBlogProjectService blogProjectService;

    @Autowired
    private BlogProjectMapper blogProjectMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BlogProject dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setUserId(null);
        }else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }
        //查询当前用户的文档
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
        //List<BlogProject> list = blogProjectService.selectBlogProjectList(dto);
        List<Map<String, Object>> mapList = blogProjectMapper.queryBlogProjectList_BySQL(dto);
        int i = blogProjectMapper.queryBlogProjectList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:export')")
    @Log(title = "导出博客文集", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BlogProject dto) {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setUserId(null);
        }else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }
        List<BlogProject> list = blogProjectService.selectBlogProjectList(dto);
        ExcelUtil<BlogProject> util = new ExcelUtil<BlogProject>(BlogProject.class);
        util.exportExcel(response, list, "博客文集数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> res = blogProjectService.selectBlogProjectById(id);
        //return success(blogProjectService.selectBlogProjectById(id));
        //返回值加密
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增
     * BlogProject dto
     */
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:add')")
    @Log(title = "新增博客文集", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }

        BlogProject dto = JSONUtil.toBean(encryptDto.getJsonObject(), BlogProject.class);
        SysUser user = SecurityUtils.getLoginUser().getUser();
        dto.setUserId(user.getUserId());
        return toAjax(blogProjectService.insertBlogProject(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:edit')")
    @Log(title = "修改博客文集", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }

        BlogProject dto = JSONUtil.toBean(encryptDto.getJsonObject(), BlogProject.class);
        return toAjax(blogProjectService.updateBlogProject(dto));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:remove')")
    @Log(title = "删除博客文集", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(blogProjectService.deleteBlogProjectByIds(ids));
    }

}
