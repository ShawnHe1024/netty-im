package pers.shawn.nettyIm.config;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

/**
 * @author shawn
 * @create 2020/11/12 18:21
 * @desc
 **/
public class MybatisPlusConfig {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        MybatisSqlSessionFactoryBuilder mybatisSqlSessionFactoryBuilder = new MybatisSqlSessionFactoryBuilder();
        Configuration configuration = new MybatisConfiguration();
        configuration.setLogImpl(Log4j2Impl.class);
        TransactionFactory transactionFactory = new ManagedTransactionFactory();
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setJdbcUrl("jdbc:postgresql://127.0.0.1:54320/private_chat");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");
        Environment environment = new Environment("dev", transactionFactory, dataSource);
        configuration.setEnvironment(environment);
        configuration.addMappers("pers.shawn.nettyIm.mapper");
        sqlSessionFactory = mybatisSqlSessionFactoryBuilder.build(configuration);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

}
