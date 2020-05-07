package com.org.atomikos.config.atomikos;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@MapperScan(basePackages = "com.org.atomikos.mapper.ds2", sqlSessionTemplateRef = "testSqlSessionTemplate2")
public class TestMyBatisConfig2 {

    /**
     * spring数据库配置前缀.
     */
    final static String DATA_SOURCE_PREFIX_TWO = "spring.jta.atomikos.datasource.two";

    // 配置数据源

    @Bean(name = "twoAtomikosDataSource")
    @ConfigurationProperties(prefix = DATA_SOURCE_PREFIX_TWO)
    public DataSource testDataSource() throws SQLException {
        return  new AtomikosDataSourceBean();
    }

    @Bean(name = "testSqlSessionFactory2")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("twoAtomikosDataSource")DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "testSqlSessionTemplate2")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("testSqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
