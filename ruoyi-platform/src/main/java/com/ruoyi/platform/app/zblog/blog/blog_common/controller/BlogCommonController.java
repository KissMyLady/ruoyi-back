package com.ruoyi.platform.app.zblog.blog.blog_common.controller;

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
import com.ruoyi.platform.app.zblog.blog.blog_common.domain.BlogCommon;
//import com.ruoyi.platform.app.zblog.blog.blog_common.service.IBlogCommonService;
import com.ruoyi.platform.app.zblog.blog.blog_common.service.impl.BlogCommonServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.platform.app.zblog.blog.blog_common.mapper.BlogCommonMapper;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博客评论Controller
 *
 * @author mylady
 * @date 2023-10-24
 */
@RestController
@RequestMapping("/blog_common/blog_common")
public class BlogCommonController extends BaseController {

    @Autowired
    private BlogCommonServiceImpl blogCommonService;
    //private IBlogCommonService blogCommonService;

    @Autowired
    private BlogCommonMapper blogCommonMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('blog_common:blog_common:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BlogCommon dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setAuthor(null);
        }else {
            //普通用户, 仅查询自己
            dto.setAuthor(""+user.getUserId());
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
        //List<BlogCommon> list = blogCommonService.selectBlogCommonList(dto);
        List<Map<String, Object>> mapList = blogCommonMapper.queryBlogCommonList_BySQL(dto);
        int i = blogCommonMapper.queryBlogCommonList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('blog_common:blog_common:export')")
    @Log(title = "导出博客评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BlogCommon dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setAuthor(null);
        }else {
            //普通用户, 仅查询自己
            dto.setAuthor(""+user.getUserId());
        }
        List<BlogCommon> list = blogCommonService.selectBlogCommonList(dto);
        ExcelUtil<BlogCommon> util = new ExcelUtil<BlogCommon>(BlogCommon.class);
        util.exportExcel(response, list, "博客评论数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('blog_common:blog_common:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> res = blogCommonService.selectBlogCommonById(id);
        //return success(blogCommonService.selectBlogCommonById(id));
        //返回值加密
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增
     * BlogCommon dto
     */
    @PreAuthorize("@ss.hasPermi('blog_common:blog_common:add')")
    @Log(title = "新增博客评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }

        BlogCommon dto = JSONUtil.toBean(encryptDto.getJsonObject(), BlogCommon.class);
        SysUser user = SecurityUtils.getLoginUser().getUser();
        dto.setAuthor(""+user.getUserId());
        return toAjax(blogCommonService.insertBlogCommon(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('blog_common:blog_common:edit')")
    @Log(title = "修改博客评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }

        BlogCommon dto = JSONUtil.toBean(encryptDto.getJsonObject(), BlogCommon.class);
        return toAjax(blogCommonService.updateBlogCommon(dto));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('blog_common:blog_common:remove')")
    @Log(title = "删除博客评论", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(blogCommonService.deleteBlogCommonByIds(ids));
    }

}
