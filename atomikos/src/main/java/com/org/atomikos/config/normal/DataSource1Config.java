//package com.org.atomikos.config.normal;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import tk.mybatis.spring.annotation.MapperScan;
//import javax.sql.DataSource;
//
///**
// * @author
// * @date 2019/9/24
// **/
//@Configuration
//@MapperScan(basePackages = "com.org.atomikos.mapper.ds1", sqlSessionTemplateRef  = "ds1SqlSessionTemplate")
//public class DataSource1Config {
//
//    @Bean(name = "ds1DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.ds1")
//    @Primary
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "ds1SqlSessionFactory")
//    @Primary
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("ds1DataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "ds1TransactionManager")
//    @Primary
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("ds1DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "ds1SqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("ds1SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//
//}
