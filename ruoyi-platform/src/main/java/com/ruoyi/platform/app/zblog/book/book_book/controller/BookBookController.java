package com.ruoyi.platform.app.zblog.book.book_book.controller;

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
import com.ruoyi.platform.app.zblog.book.book_book.domain.BookBook;
//import com.ruoyi.platform.app.zblog.book.book_book.service.IBookBookService;
import com.ruoyi.platform.app.zblog.book.book_book.service.impl.BookBookServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.platform.app.zblog.book.book_book.mapper.BookBookMapper;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 书籍Controller
 *
 * @author mylady
 * @date 2023-10-30
 */
@RestController
@RequestMapping("/book_book/book_book")
public class BookBookController extends BaseController {

    @Autowired
    private BookBookServiceImpl bookBookService;
    //private IBookBookService bookBookService;

    @Autowired
    private BookBookMapper bookBookMapper;

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    /**
     * 查询列表
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('book_book:book_book:list')")
    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BookBook dto) {
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
        //List<BookBook> list = bookBookService.selectBookBookList(dto);
        List<Map<String, Object>> mapList = bookBookMapper.queryBookBookList_BySQL(dto);
        int i = bookBookMapper.queryBookBookList_count(dto);
        return getDataTable_v2(mapList, i);
    }

    /**
     * 导出列表
     */
    @PreAuthorize("@ss.hasPermi('book_book:book_book:export')")
    @Log(title = "导出书籍", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BookBook dto) {
        //获取到用户
        SysUser user = SecurityUtils.getLoginUser().getUser();
        Long userId = user.getUserId();
        if(userId == 1){
            dto.setUserId(null);
        }else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }
        List<BookBook> list = bookBookService.selectBookBookList(dto);
        ExcelUtil<BookBook> util = new ExcelUtil<BookBook>(BookBook.class);
        util.exportExcel(response, list, "书籍数据");
    }

    /**
     * 获取详细信息
     */
    @ReturnAESEncrypt()
    @PreAuthorize("@ss.hasPermi('book_book:book_book:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        Map<String, Object> res = bookBookService.selectBookBookById(id);
        //return success(bookBookService.selectBookBookById(id));
        //返回值加密
        return AjaxResult.success_ok(res, "操作成功");
    }

    /**
     * 新增
     * BookBook dto
     */
    @PreAuthorize("@ss.hasPermi('book_book:book_book:add')")
    @Log(title = "新增书籍", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }

        BookBook dto = JSONUtil.toBean(encryptDto.getJsonObject(), BookBook.class);
        SysUser user = SecurityUtils.getLoginUser().getUser();
        dto.setUserId(user.getUserId());
        return toAjax(bookBookService.insertBookBook(dto));
    }

    /**
     * 修改
     */
    @PreAuthorize("@ss.hasPermi('book_book:book_book:edit')")
    @Log(title = "修改书籍", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody EncryptDto enDto) {
        //传递值解密
        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(enDto);
        if(ObjectUtil.isEmpty(encryptDto.getJsonObject())){
            return AjaxResult.error(encryptDto.getE());
        }

        BookBook dto = JSONUtil.toBean(encryptDto.getJsonObject(), BookBook.class);
        return toAjax(bookBookService.updateBookBook(dto));
    }

    /**
     * 删除
     */
    @PreAuthorize("@ss.hasPermi('book_book:book_book:remove')")
    @Log(title = "删除书籍", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(bookBookService.deleteBookBookByIds(ids));
    }

}
