**分布式配置事务管理器**

`第一步:`
  pom.xml 文件依赖
      
      <!--atomikos依赖-->
       <dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-jta-atomikos</artifactId>
  		</dependency>
  		
  		<!--去掉冲突jaxen的版本-->
  		<dependency>
            <groupId>jaxen</groupId>
            <artifactId>jaxen</artifactId>
            <version>1.1.1</version>
            <exclusions>
                <exclusion>
                    <groupId>xerces</groupId>
                    <artifactId>xercesImpl</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        
        
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>6.0.6</version>
        </dependency>
       </dependencies>
       
       
       <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid-spring-boot-starter</artifactId>
            <version>1.1.10</version>
      </dependency>
       
       		<!-- 用于监控与管理 -->
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
        <exclusions>
            <exclusion>
                <artifactId>spring-boot-starter-logging</artifactId>
                <groupId>org.springframework.boot</groupId>
            </exclusion>
        </exclusions>
      </dependency>
       
   注意:不要用创建springboot项目中的mysql-connector-java的版本，我这个是
   6.0.6的，否则回报数据库连接异常。
   
  ` 
  
  
  
 `  第二步`
      配置yml文件
     
     server.port=8080
     
     ## jta相关参数配置
     # 如果你在JTA环境中，并且仍然希望使用本地事务，你可以设置spring.jta.enabled属性为false以禁用JTA自动配置。
     spring.jta.enabled=true
     
     
     # 必须配置唯一的资源名
     spring.jta.atomikos.datasource.one.unique-resource-name=jta-book
     spring.jta.atomikos.datasource.one.max-pool-size=8
     spring.jta.atomikos.datasource.one.xa-data-source-class-name=com.alibaba.druid.pool.xa.DruidXADataSource
     spring.jta.atomikos.datasource.one.xa-properties.url=jdbc:mysql://127.0.0.1:3306/book?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8
     spring.jta.atomikos.datasource.one.xa-properties.username=root
     spring.jta.atomikos.datasource.one.xa-properties.password=root
     spring.jta.atomikos.datasource.one.xa-properties.filters=slf4j,stat,wall,config
     #spring.jta.atomikos.datasource.one.xa-properties.connectionProperties=config.decrypt=true;config.decrypt.key=${druid.publickey}
     
     spring.jta.atomikos.datasource.two.unique-resource-name=jta-personal
     spring.jta.atomikos.datasource.two.max-pool-size=8
     spring.jta.atomikos.datasource.two.xa-data-source-class-name=com.alibaba.druid.pool.xa.DruidXADataSource
     spring.jta.atomikos.datasource.two.xa-properties.url=jdbc:mysql://127.0.0.1:3306/log?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8
     spring.jta.atomikos.datasource.two.xa-properties.username=root
     spring.jta.atomikos.datasource.two.xa-properties.password=root
     spring.jta.atomikos.datasource.two.xa-properties.filters=slf4j,stat,wall,config
     
     
     
     ## Druid监控设置
     spring.datasource.druid.web-stat-filter.exclusions=*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*
     spring.datasource.druid.stat-view-servlet.url-pattern=/druid/*
     spring.datasource.druid.stat-view-servlet.reset-enable=true
     spring.datasource.druid.stat-view-servlet.login-username=admin
     spring.datasource.druid.stat-view-servlet.login-password=admin
     spring.datasource.druid.aop-patterns=com.org.atomikos.service.*
     
     
     
     spring.main.allow-bean-definition-overriding=true
     mybatis.type-aliases-package=com.org.atomikos.entity
     mybatis.mapper-locations=classpath:mapper/*.xml
     

  `第三步`
     配置不通的数据源，交给atomikos全局事务管理
     
     ##==================第一个对应的数据源============
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


   
      ##================第二个数据源================##
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
       
       
       ##================配置全局事务管理器==================##
     
       package com.org.atomikos.config.atomikos;
       
       import com.atomikos.icatch.jta.UserTransactionImp;
       import com.atomikos.icatch.jta.UserTransactionManager;
       import org.springframework.context.annotation.Bean;
       import org.springframework.context.annotation.Configuration;
       import org.springframework.transaction.jta.JtaTransactionManager;
       
       
       /***
        * @author kkj
        * @data 2020-23:38
        * 分布式事务使用JTA管理
        */
       import javax.transaction.UserTransaction;
       
       
       @Configuration
       public class TransactionManagerConfig {
       
           /**
            * 分布式事务使用JTA管理，不管有多少个数据源只要配置一个 JtaTransactionManager
            * @return
            */
           @Bean
           public JtaTransactionManager transactionManager(){
               UserTransactionManager userTransactionManager = new UserTransactionManager();
               UserTransaction userTransaction = new UserTransactionImp();
               return new JtaTransactionManager(userTransaction, userTransactionManager);
           }
       
       }



`
   第四步测试`
   
   package com.org.atomikos.service.impl;
   import com.org.atomikos.entity.ds1.Order;
   import com.org.atomikos.entity.ds1.OrderInfo;
   import com.org.atomikos.entity.ds2.LogsInfo;
   import com.org.atomikos.mapper.ds1.OrderInfoMapper;
   import com.org.atomikos.mapper.ds1.OrderMapper;
   import com.org.atomikos.mapper.ds2.LogsInfoMapper;
   import com.org.atomikos.service.TestService;
   import lombok.extern.java.Log;
   import org.springframework.beans.factory.annotation.Autowired;
   import org.springframework.stereotype.Service;
   import org.springframework.transaction.annotation.Transactional;
   
   import java.math.BigDecimal;
   import java.util.Date;
   import java.util.List;
   
   @Log
   @Service
   public class TestServiceImpl implements TestService{
   
       @Autowired
       private LogsInfoMapper logsInfoMapper;
   
       @Autowired
       private OrderMapper orderMapper;
   
       @Autowired
       private OrderInfoMapper orderInfoMapper;
   
   
       @Transactional(rollbackFor = Exception.class)
       @Override
       public void insertTest() {
           try {
               LogsInfo logsInfo = new LogsInfo();
               logsInfo.setContent("我是插入的数据");
               logsInfo.setCreateTime(new Date());
               Integer count = logsInfoMapper.insert(logsInfo);
               if (count != 1) {
                   log.info("==========插入异常logsInfo=========");
                   return;
               }
   
   
   
   
               OrderInfo orderInfo=new OrderInfo();
               orderInfo.setMoney(new BigDecimal(7.89));
               orderInfo.setAddress("情雪湖");
               orderInfo.setCreateTime(new Date());
               orderInfo.setUserId(1);
               Integer countOrderInfo=orderInfoMapper.insert(orderInfo);
               if (countOrderInfo != 1) {
                   log.info("==========Order=========");
                   return;
               }
   
              int i=1/0;
   
           }catch (Exception e){
               log.info("==========插入异常========="+e);
               throw new RuntimeException("注册用户:数据库保存异常");
           }
       }
   }
   
   
      ##springboot自带的测试类
       package com.org.atomikos;
       import com.org.atomikos.service.TestService;
       import org.junit.jupiter.api.Test;
       import org.springframework.beans.factory.annotation.Autowired;
       import org.springframework.boot.test.context.SpringBootTest;
       
       @SpringBootTest
       class AtomikosApplicationTests {
       
        @Autowired
        private TestService testService;
       
        @Test
        void contextLoads() {
            testService.insertTest();
        }
       
       }
       
       
     注意:我这个service的代码块就没有贴出来了，自己看项目结构。

