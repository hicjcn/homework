package com.demo.stu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.google.common.collect.Maps;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druid(){
        return new DruidDataSource();
    }

    /**
     * 配置servlet
     * 启动服务器在浏览器地址栏数据localhost:端口号:/druid进行测试
     * @return
     */
    @Bean
    public ServletRegistrationBean myservlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = Maps.newHashMap();
        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","123456");
        // 如果不写就是默认允许所有
        initParams.put("allow","");
        initParams.put("deny","127.0.0.1");
        //是否能够重置数据.
        bean.addInitParameter("resetEnable","false");
        bean.setInitParameters(initParams);
        return bean;
    }

    /**
     * 配置filter
     * @return
     */
    @Bean
    public FilterRegistrationBean myfilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        bean.setFilter(new WebStatFilter());

        Map<String,String> initParams = new HashMap<>();
        initParams.put("exclusions","*.js,*.css,/druid/*");

        bean.setInitParameters(initParams);

        bean.addUrlPatterns("/*");
        return bean;
    }
}
