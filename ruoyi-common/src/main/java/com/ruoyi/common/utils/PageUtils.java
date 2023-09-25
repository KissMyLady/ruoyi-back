package com.ruoyi.common.utils;

import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.page.PageDomain;
import com.ruoyi.common.core.page.TableSupport;
import com.ruoyi.common.utils.sql.SqlUtil;

/**
 * 分页工具类
 *
 * @author ruoyi
 */
public class PageUtils extends PageHelper {
    /**
     * 设置请求分页数据
     */
    public static void startPage() {
        /*
         * 主要是通过拦截器（Interceptor）来实现。在 MyBatis 中，提供了 Interceptor
         * 接口用于对 SQL 语句进行拦截和处理，PageHelper 就是实现了这个接口，从而实现
         * 了对 SQL 语句的拦截和分页处理。
         */
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();   //页码
        Integer pageSize = pageDomain.getPageSize();  //每页大小
        String orderBy1 = pageDomain.getOrderBy();    // 排序
        String orderBy = SqlUtil.escapeOrderBySql(orderBy1);  //检查字符, 防止注入
        Boolean reasonable = pageDomain.getReasonable();  //分页参数合理化
        PageHelper.startPage(pageNum, pageSize, orderBy).setReasonable(reasonable);
    }

    /**
     * 清理分页的线程变量
     */
    public static void clearPage() {
        PageHelper.clearPage();
    }
}
