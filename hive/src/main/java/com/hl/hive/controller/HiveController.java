package com.hl.hive.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.hl.hive.config.HiveConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zy
 * @Date: 2020/11/26 14:27
 */
@Controller
@RequestMapping("/hive")
@Slf4j
public class HiveController {

    @Autowired
    @Qualifier("hiveDruidDataSource")
    private DruidDataSource druidDataSource;


    @RequestMapping("/test")
    @ResponseBody
    public List<Object> test() throws Exception {

        Connection conn = druidDataSource.getConnection();
        Statement stmt = null;
        List<Object> list = new ArrayList<>();
        if (conn == null) {
            //error
        } else {
            stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("select * from accounting.user_bean_price limit 100 ");

            while (res.next()) {

            }
        }
        stmt.close();
        HiveConfig.closeConn(conn);
        return list;
    }
}
