package com.ruoyi.platform.app.zblog.v3_books.book_book.controller;

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
import com.ruoyi.platform.app.zblog.v3_books.book_book.domain.BookBook;
//import com.ruoyi.platform.app.zblog.v3_books.book_book.service.IBookBookService;
import com.ruoyi.platform.app.zblog.v3_books.book_book.service.impl.BookBookServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 书籍信息Controller
 *
 * @author mylady
 * @date 2023-10-07
 */
@RestController
@RequestMapping("/book_book/book_book")
public class BookBookController extends BaseController {

    @Autowired
    private BookBookServiceImpl bookBookService;
    //private IBookBookService bookBookService;

    /**
     * 查询书籍信息列表
     */
    @PreAuthorize("@ss.hasPermi('book_book:book_book:list')")
    @GetMapping("/list")
    public TableDataInfo list(BookBook bookBook) {
        startPage();
        List<BookBook> list = bookBookService.selectBookBookList(bookBook);
        return getDataTable(list);
    }

    /**
     * 导出书籍信息列表
     */
    @PreAuthorize("@ss.hasPermi('book_book:book_book:export')")
    @Log(title = "导出书籍信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BookBook bookBook) {
        List<BookBook> list = bookBookService.selectBookBookList(bookBook);
        ExcelUtil<BookBook> util = new ExcelUtil<BookBook>(BookBook.class);
        util.exportExcel(response, list, "书籍信息数据");
    }

    /**
     * 获取书籍信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('book_book:book_book:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(bookBookService.selectBookBookById(id));
    }

    /**
     * 新增书籍信息
     */
    @PreAuthorize("@ss.hasPermi('book_book:book_book:add')")
    @Log(title = "新增书籍信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BookBook bookBook) {
        return toAjax(bookBookService.insertBookBook(bookBook));
    }

    /**
     * 修改书籍信息
     */
    @PreAuthorize("@ss.hasPermi('book_book:book_book:edit')")
    @Log(title = "修改书籍信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BookBook bookBook) {
        return toAjax(bookBookService.updateBookBook(bookBook));
    }

    /**
     * 删除书籍信息
     */
    @PreAuthorize("@ss.hasPermi('book_book:book_book:remove')")
    @Log(title = "删除书籍信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(bookBookService.deleteBookBookByIds(ids));
    }

}
