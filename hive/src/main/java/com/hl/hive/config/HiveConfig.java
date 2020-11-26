package com.hl.hive.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author: zy
 * @Date: 2020/11/26 11:39
 */
@Configuration
@Slf4j
public class HiveConfig {

    private static DruidDataSource hiveDataSource = new DruidDataSource();

    private static String hiveUrl = "jdbc:hive2://localhost:10000/hive_1";
    private static String hiveJdbcUserName = "root";
    private static String hiveJdbcPassword = "root";
    private static Integer hiveInitialSize = 20;
    private static Integer hiveMinIdle = 20;
    private static Integer hiveMaxActive = 500;
    private static Integer hiveMaxWait = 60000;


    @Bean
    public  DruidDataSource getHiveDataSource() throws Exception {
        if (hiveDataSource.isInited()) {
            return hiveDataSource;
        }
        try {
            //基本属性 url、user、password
            hiveDataSource.setUrl(hiveUrl);
            hiveDataSource.setUsername(hiveJdbcUserName);
            hiveDataSource.setPassword(hiveJdbcPassword);

            //配置初始化大小、最小、最大
            hiveDataSource.setInitialSize(hiveInitialSize);
            hiveDataSource.setMinIdle(hiveMinIdle);
            hiveDataSource.setMaxActive(hiveMaxActive);
            //配置获取连接等待超时的时间
            hiveDataSource.setMaxWait(hiveMaxWait);
            //配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
            hiveDataSource.setTimeBetweenEvictionRunsMillis(60000);
            //配置一个连接在池中最小生存的时间，单位是毫秒
            hiveDataSource.setMinEvictableIdleTimeMillis(300000);
            hiveDataSource.setTestWhileIdle(false);
            //打开PSCache，并且指定每个连接上PSCache的大小
            hiveDataSource.setPoolPreparedStatements(true);
            hiveDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
            hiveDataSource.init();
        } catch (SQLException e) {
            log.error("初始化 druid-hive连接池错误");
            closeHiveDataSource();
            throw new Exception();
        }
        log.info("初始化hiveDataSource成功");
        return hiveDataSource;
    }

    /**
     * @Description:关闭Hive连接池
     */
    public static void closeHiveDataSource() {
        if (hiveDataSource != null) {
            hiveDataSource.close();
        }
    }

    /**
     * @Description:关闭Hive数据连接
     */
    public static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            log.error("--" + e + ":关闭Hive-conn连接失败！");
        }
    }


}
