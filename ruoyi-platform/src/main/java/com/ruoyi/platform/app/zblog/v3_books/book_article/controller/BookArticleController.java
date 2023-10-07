package com.ruoyi.platform.app.zblog.v3_books.book_article.controller;

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
import com.ruoyi.platform.app.zblog.v3_books.book_article.domain.BookArticle;
//import com.ruoyi.platform.app.zblog.v3_books.book_article.service.IBookArticleService;
import com.ruoyi.platform.app.zblog.v3_books.book_article.service.impl.BookArticleServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 书籍-详情列内容Controller
 *
 * @author mylady
 * @date 2023-10-07
 */
@RestController
@RequestMapping("/book_article/book_article")
public class BookArticleController extends BaseController {

    @Autowired
    private BookArticleServiceImpl bookArticleService;
    //private IBookArticleService bookArticleService;

    /**
     * 查询书籍-详情列内容列表
     */
    @PreAuthorize("@ss.hasPermi('book_article:book_article:list')")
    @GetMapping("/list")
    public TableDataInfo list(BookArticle bookArticle) {
        startPage();
        List<BookArticle> list = bookArticleService.selectBookArticleList(bookArticle);
        return getDataTable(list);
    }

    /**
     * 导出书籍-详情列内容列表
     */
    @PreAuthorize("@ss.hasPermi('book_article:book_article:export')")
    @Log(title = "导出书籍-详情列内容", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BookArticle bookArticle) {
        List<BookArticle> list = bookArticleService.selectBookArticleList(bookArticle);
        ExcelUtil<BookArticle> util = new ExcelUtil<BookArticle>(BookArticle.class);
        util.exportExcel(response, list, "书籍-详情列内容数据");
    }

    /**
     * 获取书籍-详情列内容详细信息
     */
    @PreAuthorize("@ss.hasPermi('book_article:book_article:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(bookArticleService.selectBookArticleById(id));
    }

    /**
     * 新增书籍-详情列内容
     */
    @PreAuthorize("@ss.hasPermi('book_article:book_article:add')")
    @Log(title = "新增书籍-详情列内容", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BookArticle bookArticle) {
        return toAjax(bookArticleService.insertBookArticle(bookArticle));
    }

    /**
     * 修改书籍-详情列内容
     */
    @PreAuthorize("@ss.hasPermi('book_article:book_article:edit')")
    @Log(title = "修改书籍-详情列内容", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BookArticle bookArticle) {
        return toAjax(bookArticleService.updateBookArticle(bookArticle));
    }

    /**
     * 删除书籍-详情列内容
     */
    @PreAuthorize("@ss.hasPermi('book_article:book_article:remove')")
    @Log(title = "删除书籍-详情列内容", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(bookArticleService.deleteBookArticleByIds(ids));
    }

}
