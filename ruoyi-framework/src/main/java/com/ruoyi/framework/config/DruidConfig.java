package com.ruoyi.framework.config;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.util.Utils;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.framework.config.properties.DruidProperties;
import com.ruoyi.framework.datasource.DynamicDataSource;

/**
 * druid 配置多数据源
 *
 * @author ruoyi
 */
@Configuration
public class DruidConfig {

    private static final Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    //主
    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource(DruidProperties druidProperties) {
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        return druidProperties.dataSource(dataSource);
    }

    //从库mydoc
    @Bean
    @ConfigurationProperties("spring.datasource.druid.slavemydoc")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slavemydoc", name = "enabled", havingValue = "true")
    public DataSource slaveMyDoc(DruidProperties druidProperties) {
        //在DruidConfig配置读取slave数据源
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        logger.info("在DruidConfig配置读取 从库 mydoc 数据源 ... 配置从数据库 ...");
        return druidProperties.dataSource(dataSource);
    }

    //从库Zblog
    @Bean
    @ConfigurationProperties("spring.datasource.druid.slavezblog")
    @ConditionalOnProperty(prefix = "spring.datasource.druid.slavezblog", name = "enabled", havingValue = "true")
    public DataSource slaveZblog(DruidProperties druidProperties) {
        //在DruidConfig配置读取slave数据源
        DruidDataSource dataSource = DruidDataSourceBuilder.create().build();
        logger.info("在DruidConfig配置读取 从库 Zblog 数据源 ... 配置从数据库 ...");
        return druidProperties.dataSource(dataSource);
    }

    /**
     * 设置数据源
     *
     * @param targetDataSources 备选数据源集合
     * @param sourceName        数据源名称
     * @param beanName          bean名称
     */
    public void setDataSource(Map<Object, Object> targetDataSources,
                              String sourceName,
                              String beanName
    ) {
        try {
            DataSource dataSource = SpringUtils.getBean(beanName);
            targetDataSources.put(sourceName, dataSource);
        } catch (Exception e) {
            logger.warn("设置数据源错误1: {}", e.getMessage());
        }
    }

    //主要数据源
    @Bean(name = "dynamicDataSource")
    @Primary
    public DynamicDataSource dataSource(DataSource masterDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();

        //ry_vue
        String ryVueName = DataSourceType.MASTER.name();
        targetDataSources.put(ryVueName, masterDataSource);

        //mydoc
        String slaveName = DataSourceType.slaveMyDoc.name();
        setDataSource(targetDataSources, slaveName, "slaveMyDoc");

        //zblog
        String zlogName = DataSourceType.slaveZblog.name();
        setDataSource(targetDataSources, zlogName, "slaveZblog");

        return new DynamicDataSource(masterDataSource, targetDataSources);
    }

    /**
     * 去除监控页面底部的广告
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Bean
    @ConditionalOnProperty(name = "spring.datasource.druid.statViewServlet.enabled", havingValue = "true")
    public FilterRegistrationBean removeDruidFilterRegistrationBean(DruidStatProperties properties) {
        // 获取web监控页面的参数
        DruidStatProperties.StatViewServlet config = properties.getStatViewServlet();
        // 提取common.js的配置路径
        String pattern = config.getUrlPattern() != null ? config.getUrlPattern() : "/druid/*";
        String commonJsPattern = pattern.replaceAll("\\*", "js/common.js");
        final String filePath = "support/http/resources/js/common.js";
        // 创建filter进行过滤
        Filter filter = new Filter() {
            @Override
            public void init(javax.servlet.FilterConfig filterConfig) throws ServletException {
            }

            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                    throws IOException, ServletException {
                chain.doFilter(request, response);
                // 重置缓冲区，响应头不会被重置
                response.resetBuffer();
                // 获取common.js
                String text = Utils.readFromResource(filePath);
                // 正则替换banner, 除去底部的广告信息
                text = text.replaceAll("<a.*?banner\"></a><br/>", "");
                text = text.replaceAll("powered.*?shrek.wang</a>", "");
                response.getWriter().write(text);
            }

            @Override
            public void destroy() {
            }
        };
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns(commonJsPattern);
        return registrationBean;
    }
}
