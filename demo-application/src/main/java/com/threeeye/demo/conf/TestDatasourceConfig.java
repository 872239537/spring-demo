package com.threeeye.demo.conf;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.threeeye.expends.mybatis.mapper.SqlMapper;
import com.threeeye.framework.dao.MyMapper;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.threeeye.api.dao", markerInterface = MyMapper.class, sqlSessionTemplateRef = "sqlSessionTemplateAdmin")
public class TestDatasourceConfig {
    @Value("${admin.aliases.package}")
    private String aliasPacage;

    @Value("${admin.mapper}")
    private String adminMapper;


    @Bean(name = "dataSourceAdmin")
    @ConfigurationProperties(prefix = "spring.datasource.admin")
    public DataSource dataSourceAdmin() {
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;

    }

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        registrationBean.addInitParameter("allow", "127.0.0.1"); // IP白名单 (没有配置或者为空，则允许所有访问)
        registrationBean.addInitParameter("deny", ""); // IP黑名单 (存在共同时，deny优先于allow)
        registrationBean.addInitParameter("loginUsername", "admin");
        registrationBean.addInitParameter("loginPassword", "admin");
        registrationBean.addInitParameter("resetEnable", "false");
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean druidWebStatViewFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
        registrationBean.addInitParameter("urlPatterns", "/*");
        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        return registrationBean;
    }


    @Bean(name = "sqlSessionFactoryAdmin")
    public SqlSessionFactory sqlSessionFactoryAdmin(@Qualifier("dataSourceAdmin") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        VFS.addImplClass(SpringBootVFS.class);
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage(aliasPacage);
        // Mybatis Config
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        sessionFactory.setConfiguration(configuration);

        // Mybatis Mapper XML Config
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //*.mapper.xml的地址（根据你的项目自行修改）
        String resouces[] = adminMapper.split(",");
        Resource[] resourceArray = null;
        for (String resouce : resouces) {
            Resource[] resourceArray1 = resolver.getResources(resouce);
            if (resourceArray == null) {
                resourceArray = resourceArray1;
            } else {
                resourceArray = (Resource[]) ArrayUtils.addAll(resourceArray, resourceArray1);
            }
        }
        sessionFactory.setMapperLocations(resourceArray);
        return sessionFactory.getObject();
    }

    @Bean(name = "dataSourceTransactionManagerAdmin")
    public DataSourceTransactionManager dataSourceTransactionManagerOne(
            @Qualifier("dataSourceAdmin") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "sqlSessionTemplateAdmin")
    public SqlSessionTemplate sqlSessionTemplateAdmin(
            @Qualifier("sqlSessionFactoryAdmin") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean(name = "sqlMapper")
    public SqlMapper sqlMapperAdmin(
            @Qualifier("sqlSessionTemplateAdmin") SqlSessionTemplate sqlSessionTemplate) throws Exception {
        return new SqlMapper(sqlSessionTemplate);
    }


}
