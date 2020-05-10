


说明：tx-manager事务项目配置成功，启动会添加两张表，用于记录分布式事务日志记录
还有，我这个是一个分布式不同模块的项目，项目结构如图。





第一步：
    创建Eureka项目（当服务注册中心）

(1)  在pom.xml文中添加需要得依赖


<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>


(2) application.properties配置需要的属性


server.port=8081
spring.application.name=tx-eureka

##euraka配置
eureka.instance.hostname=localhost
eureka.client.fetch-registry=false
eureka.client.register-with-eureka=false
eureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka

(3) 启动类加入配置


(4)项目启动测试







第二步
  创建tx-manager项目

(1)  在pom.xml文中添加需要得依赖



<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<dependency>
   <groupId>org.springframework.boot</groupId>
   <artifactId>spring-boot-starter-data-redis</artifactId>
   <version>2.2.6.RELEASE</version>
</dependency>


      <!-- 参照例子引入需要的依赖jar -->
      <dependency>
          <groupId>com.codingapi.txlcn</groupId>
          <artifactId>txlcn-tm</artifactId>
          <version>5.0.2.RELEASE</version>
      </dependency>

<dependency>
   <groupId>com.codingapi.txlcn</groupId>
   <artifactId>txlcn-tc</artifactId>
   <version>5.0.2.RELEASE</version>
</dependency>

<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
</dependency>


(2)  application.properties配置需要的属性

server.port=8082
spring.application.name=tx-manager

##euraka配置
eureka.client.service-url.defaultZone=http://localhost:8081/eureka/

##数据库配置
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/tx-manager?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.ddl-auto=update


# TM后台登陆密码
tx-lcn.manager.admin-key=123456
tx-lcn.manager.host=192.168.11.13
tx-lcn.manager.port=8070


# 开启日志,默认为false
tx-lcn.logger.enabled=true
tx-lcn.logger.driver-class-name=${spring.datasource.driver-class-name}
tx-lcn.logger.jdbc-url=${spring.datasource.url}
tx-lcn.logger.username=${spring.datasource.username}
tx-lcn.logger.password=${spring.datasource.password}
logging.level.com.codingapi.txlcn=DEBUG


##redis
spring.redis.host=127.0.0.1
spring.redis.port=6379
spring.redis.password=
spring.redis.jedis.pool.max-active=10
spring.redis.jedis.pool.max-wait=-1ms
spring.redis.jedis.pool.max-idle=5
spring.redis.jedis.pool.min-idle=0


(3) 启动类加入配置


(4)tx-manager项目启动



第三步
 创建tx-order订单项目

(1)  在pom.xml文中添加需要得依赖



<dependency>
   <groupId>com.codingapi.txlcn</groupId>
   <artifactId>txlcn-tc</artifactId>
   <version>5.0.2.RELEASE</version>
</dependency>

<dependency>
   <groupId>com.codingapi.txlcn</groupId>
   <artifactId>txlcn-txmsg-netty</artifactId>
   <version>5.0.2.RELEASE</version>
</dependency>

<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
</dependency>

<dependency>
   <groupId>tk.mybatis</groupId>
   <artifactId>mapper-spring-boot-starter</artifactId>
   <version>2.1.5</version>
</dependency>

<dependency>
   <groupId>org.springframework.cloud</groupId>
   <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>

<dependency>
   <groupId>org.projectlombok</groupId>
   <artifactId>lombok</artifactId>
   <optional>true</optional>
</dependency>



(2)  application.properties配置需要的属性



server.port=8085
spring.application.name=tx-order

##euraka配置
eureka.client.service-url.defaultZone=http://localhost:8081/eureka/

##数据库配置
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/book?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=root


feign.hystrix.enabled=false
feign.httpclient.enabled=false
feign.okhttp.enabled=true



##mybatis配置
mybatis.type-aliases-package=com.org.tx.order.entity
mybatis.mapper-locations=classpath:mapper/*.xml

##开启负载均衡
tx-lcn.ribbon.loadbalancer.dtx.enabled=true
####tx-client
tx-lcn.client.manager-address=192.168.11.13:8070
##开启日志
tx-lcn.logger.enabled=true
logging.level.com.codingapi.txlcn=DEBUG

(3) 启动类加入配置




(4)  mybatis接口的继承

@Configuration
@RegisterMapper
public interface BaseMapper<T, PK> extends Mapper<T>,IdListMapper<T, PK>, InsertListMapper<T> {
}

mapper接口继承配置mybatis同用的接口




servcie



impl


controller


api(用于远程服务调用)

说明:对应controller层方法 （如添加方法，一定要对应上）

(5) 启动查看



第三步
 创建tx-pay交易项目




跟创建第二步一样，唯一不同的视测试全局事务管理，方法的实现稍微不同

(1) 把tx-order把项目依赖添加进去
<dependency>
   <groupId>com.org.tx.order</groupId>
   <artifactId>order</artifactId>
   <version>0.0.1-SNAPSHOT</version>
</dependency>

说明:与tx-order的依赖一样，只是再添加上面的依赖即可


(2) 对应tx-order中你配置得分服务名@FeignClient(name = "tx-order") 如果不知道建议雪springboot及微服务


说明:远程调用tx-order方法重的添加业务


(3)  impl调用方法



(4) controller




第四步
      测试分布式全局事务




测试结果如图：


说明:故意添加一个有异常的方法，所以才会记录事务日志。效果如下图


