package com.hl.hive.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.hl.hive.config.HiveConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @Author: zy
 * @Date: 2020/11/26 14:27
 */
@Controller
@RequestMapping("/hive")
@Slf4j
public class HiveController {

    @Autowired
    private DruidDataSource druidDataSource;


    @RequestMapping("/test")
    @ResponseBody
    public String test() throws Exception {

        Connection conn = druidDataSource.getConnection();
        Statement stmt = null;
        if (conn == null) {
            //error
        } else {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("select * from hive_01 ");
            while (res.next()) {
                log.info(res.getString(1) + "|" + res.getString(2));
            }
        }
        stmt.close();
        HiveConfig.closeConn(conn);
        return "test";
    }
}
