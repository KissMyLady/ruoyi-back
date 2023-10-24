package com.ruoyi.platform.app.zblog.blog.blog_history.controller;

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
import com.ruoyi.platform.app.zblog.blog.blog_history.domain.BlogHistory;
//import com.ruoyi.platform.app.zblog.blog.blog_history.service.IBlogHistoryService;
import com.ruoyi.platform.app.zblog.blog.blog_history.service.impl.BlogHistoryServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.platform.app.zblog.blog.blog_history.mapper.BlogHistoryMapper;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博客文档历史记录Controller
 *
 * @author mylady
 * @date 2023-10-24
 */
@RestController
@RequestMapping("/blog_history/blog_history")
public class BlogHistoryController extends BaseController {

    @Autowired
    private BlogHistoryServiceImpl blogHistoryService;
    //private IBlogHistoryService blogHistoryService;

    @Autowired
    private BlogHistoryMapper blogHistoryMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BlogHistory dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setUserId(null);
        }else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }
        //查询当前用户
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
        //List<BlogHistory> list = blogHistoryService.selectBlogHistoryList(dto);
        List<Map<String, Object>> mapList = blogHistoryMapper.queryBlogHistoryList_BySQL(dto);
        int i = blogHistoryMapper.queryBlogHistoryList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:export')")
    @Log(title = "导出博客文档历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BlogHistory dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setUserId(null);
        }else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }
        List<BlogHistory> list = blogHistoryService.selectBlogHistoryList(dto);
        ExcelUtil<BlogHistory> util = new ExcelUtil<BlogHistory>(BlogHistory.class);
        util.exportExcel(response, list, "博客文档历史记录数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> res = blogHistoryService.selectBlogHistoryById(id);
        //return success(blogHistoryService.selectBlogHistoryById(id));
        //返回值加密
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增
     * BlogHistory dto
     */
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:add')")
    @Log(title = "新增博客文档历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }

        BlogHistory dto = JSONUtil.toBean(encryptDto.getJsonObject(), BlogHistory.class);
        SysUser user = SecurityUtils.getLoginUser().getUser();
        dto.setUserId(user.getUserId());
        return toAjax(blogHistoryService.insertBlogHistory(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:edit')")
    @Log(title = "修改博客文档历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }

        BlogHistory dto = JSONUtil.toBean(encryptDto.getJsonObject(), BlogHistory.class);
        return toAjax(blogHistoryService.updateBlogHistory(dto));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:remove')")
    @Log(title = "删除博客文档历史记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(blogHistoryService.deleteBlogHistoryByIds(ids));
    }

}
