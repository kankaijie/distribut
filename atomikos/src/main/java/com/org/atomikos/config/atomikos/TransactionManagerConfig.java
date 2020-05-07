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
