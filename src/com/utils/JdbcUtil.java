package com.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class JdbcUtil {
    //1.声明连接池
    private static DataSource ds;
    //2.实例化连接池
    static {
        try{
            Properties p = new Properties();
            p.load(JdbcUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds= DruidDataSourceFactory.createDataSource(p);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //3.返回连接池
        public static DataSource getDs(){
                return ds;
        }
}
