package com.xeg.cores.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;

/**
 * @author ningpeng
 * @description: TODO
 * @date 2021/5/7 11:41
 */
//@Configuration
public class TransactionConfig {
    public final static String MONGO_TX = "mongoTransactionManager";

    @Bean(name = TransactionConfig.MONGO_TX)
    MongoTransactionManager transactionManager(MongoDatabaseFactory factory) {
        return new MongoTransactionManager(factory);
    }
}
