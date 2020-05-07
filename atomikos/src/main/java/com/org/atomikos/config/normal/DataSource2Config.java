//package com.org.atomikos.config.normal;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import tk.mybatis.spring.annotation.MapperScan;
//
//import javax.sql.DataSource;
//
///**
// * @author caromai
// * @date 2019/9/24
// **/
//@Configuration
//@MapperScan(basePackages = "com.org.atomikos.mapper.ds2", sqlSessionTemplateRef  = "ds2SqlSessionTemplate")
//public class DataSource2Config {
//
//    @Bean(name = "ds2DataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.ds2")
//    public DataSource testDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "ds2SqlSessionFactory")
//    public SqlSessionFactory testSqlSessionFactory(@Qualifier("ds2DataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "ds2TransactionManager")
//    public DataSourceTransactionManager testTransactionManager(@Qualifier("ds2DataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "ds2SqlSessionTemplate")
//    public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("ds2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
//
//}
