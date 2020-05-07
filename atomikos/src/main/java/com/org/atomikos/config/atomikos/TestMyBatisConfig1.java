package com.org.atomikos.config.atomikos;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.cj.jdbc.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.org.atomikos.mapper.ds1", sqlSessionTemplateRef = "testSqlSessionTemplate")
public class TestMyBatisConfig1 {

    /**
     * spring数据库配置前缀.
     */
    final static String DATA_SOURCE_PREFIX_ONE = "spring.jta.atomikos.datasource.one";



    // 配置数据源
    @Bean
    @Primary
    @ConfigurationProperties(prefix = DATA_SOURCE_PREFIX_ONE)
    public DataSource testDataSource( )throws SQLException {
        return  new AtomikosDataSourceBean();
    }
    @Primary
    @Bean(name = "testSqlSessionFactory")
    public SqlSessionFactory testSqlSessionFactory(DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Primary
    @Bean(name = "testSqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("testSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
