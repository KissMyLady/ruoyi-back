package com.ruoyi.platform.app.zblog.blog.blog_blog.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.platform.app.zblog.blog.blog_history.domain.BlogHistory;
import com.ruoyi.platform.app.zblog.blog.blog_history.mapper.BlogHistoryMapper;
import com.ruoyi.platform.app.zblog.blog.blog_project.domain.BlogProject;
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
import com.ruoyi.platform.app.zblog.blog.blog_blog.domain.BlogBlog;
//import com.ruoyi.platform.zblog.blog.blog_blog.service.IBlogBlogService;
import com.ruoyi.platform.app.zblog.blog.blog_blog.service.impl.BlogBlogServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.platform.app.zblog.blog.blog_blog.mapper.BlogBlogMapper;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博客文档Controller
 *
 * @author mylady
 * @date 2023-10-24
 */
@RestController
@RequestMapping("/blog_blog/blog_blog")
public class BlogBlogController extends BaseController {

    @Autowired
    private BlogBlogServiceImpl blogBlogService;
    //private IBlogBlogService blogBlogService;

    @Autowired
    private BlogBlogMapper blogBlogMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    @Autowired
    private BlogHistoryMapper blogHistoryMapper;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('blog_blog:blog_blog:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BlogBlog dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if (userId == 1) {
            dto.setUserId(null);
        } else {
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
        //List<BlogBlog> list = blogBlogService.selectBlogBlogList(dto);
        List<Map<String, Object>> mapList = blogBlogMapper.queryBlogBlogList_BySQL(dto);
        int i = blogBlogMapper.queryBlogBlogList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('blog_blog:blog_blog:export')")
    @Log(title = "导出博客文档", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BlogBlog dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if (userId == 1) {
            dto.setUserId(null);
        } else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }
        List<BlogBlog> list = blogBlogService.selectBlogBlogList(dto);
        ExcelUtil<BlogBlog> util = new ExcelUtil<BlogBlog>(BlogBlog.class);
        util.exportExcel(response, list, "博客文档数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('blog_blog:blog_blog:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> res = blogBlogService.selectBlogBlogById(id);
        //return success(blogBlogService.selectBlogBlogById(id));
        //返回值加密
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增
     * BlogBlog dto
     */
    @PreAuthorize("@ss.hasPermi('blog_blog:blog_blog:add')")
    @Log(title = "新增博客文档", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }

        //长文本内容
        // String longTextContent = encryptDto.getC();
        BlogBlog dto = JSONUtil.toBean(encryptDto.getJsonObject(), BlogBlog.class);

        SysUser user = SecurityUtils.getLoginUser().getUser();
        dto.setUserId(user.getUserId());
        return toAjax(blogBlogService.insertBlogBlog(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('blog_blog:blog_blog:edit')")
    @Log(title = "修改博客文档", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if (ObjectUtil.isEmpty(encryptDto.getJsonObject())) {
            return AjaxResult.error(encryptDto.getE());
        }

        BlogBlog dto = JSONUtil.toBean(encryptDto.getJsonObject(), BlogBlog.class);

        //查询历史数据, 保存到表
        Map<String, Object> stringObjectMap = blogBlogService.selectBlogBlogById(dto.getId());

        BlogBlog historyDto = JSONUtil.toBean(JSONUtil.toJsonStr(stringObjectMap), BlogBlog.class);

        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();

        //保存到历史记录
        BlogHistory blogHistory = new BlogHistory();
        blogHistory.setBlogId(historyDto.getId());  //文档id
        blogHistory.setName(historyDto.getName());  //文档名称
        blogHistory.setUserId(userId);  //用户id
        blogHistory.setPreContent(historyDto.getPreContent());  //内容
        blogHistoryMapper.insertBlogHistory(blogHistory);

        //更新
        int i = blogBlogService.updateBlogBlog(dto);
        return toAjax(i);
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('blog_blog:blog_blog:remove')")
    @Log(title = "删除博客文档", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        //删除前, 将文档备份到历史数据表
        for (Long dbId : ids) {
            Map<String, Object> stringObjectMap = blogBlogMapper.selectBlogBlogById(dbId);
            //转对象
            BlogBlog dto = JSONUtil.toBean(JSONUtil.toJsonStr(stringObjectMap), BlogBlog.class);
            BlogHistory blogHistory = new BlogHistory();
            blogHistory.setUserId(userId);
            blogHistory.setBlogId(dbId);
            blogHistory.setName(dto.getName());  //文档名称

            //判断编辑器类别
            Long editorMode = dto.getEditorMode();
            if (editorMode == 1){
                //md编辑器, 内容字段为 preContent
                blogHistory.setPreContent(dto.getPreContent());
            } else if (editorMode == 2) {
                //富文本编辑器, 存文本txt内容
                blogHistory.setPreContent(dto.getPreContent());
            }else if (editorMode == 9) {
                blogHistory.setPreContent(dto.getContent());
            }else {
                blogHistory.setPreContent(dto.getPreContent());
            }
            blogHistoryMapper.insertBlogHistory(blogHistory);
        }
        return toAjax(blogBlogService.deleteBlogBlogByIds(ids));
    }

}
