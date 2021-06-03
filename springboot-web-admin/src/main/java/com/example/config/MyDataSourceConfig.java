package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @Deprecated: 过期注解
 */
@Deprecated
//@Configuration
public class MyDataSourceConfig {

    //    @ConfigurationProperties("spring.datasource")
//    @Bean
    public DataSource dataSource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();

        //druidDataSource.setUrl();

        // 加入监控页:stat，防火墙:wall, 在yml配置了，这里不用配置
        //druidDataSource.setFilters("stat,wall");

        return druidDataSource;
    }

    /**
     * 配置 druid 的监控页功能
     *
     * @return
     */
    // @Bean
    public ServletRegistrationBean statViewServlet() {

        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        // 设置进入 druid的账号和密码
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "123456");

        return registrationBean;
    }


    /**
     * webStatFilter 用于采集web-jdbc关联监控的数据
     *
     * @return
     */
    // @Bean
    public FilterRegistrationBean webStatFilter() {

        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterFilterRegistrationBean;
    }


}
