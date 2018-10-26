package com.alibaba.druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author gzd
 * @date 2018-10-25 下午 2:44
 * @desc 测试的main方法
 */
public class MyMain {


    public static void main(String[] args) throws ClassNotFoundException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setDriverClassLoader(null);
        dataSource.setUrl("jdbc:mysql://101.200.83.54:3306/blog_log");
        dataSource.setUsername("root");
        dataSource.setPassword("Password!1");
        dataSource.setInitialSize(1);
        dataSource.setMaxActive(2);
        dataSource.setMaxWait(1000);

        DruidDataSource dataSource1 = new DruidDataSource();
        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource1.setDriverClassLoader(null);
        dataSource1.setUrl("jdbc:mysql://101.200.83.54:3306/blog_log");
        dataSource1.setUsername("root");
        dataSource1.setPassword("Password!1");
        dataSource1.setInitialSize(2);
        dataSource1.setMaxActive(2);
        dataSource1.setMaxWait(1000);

        try {
            DruidPooledConnection connection2 = dataSource1.getConnection();
            DruidPooledConnection connection3 = dataSource1.getConnection();
            System.out.println("---2---"+connection2);
            System.out.println("---3---"+connection3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            DruidPooledConnection connection = dataSource.getConnection();
            System.out.println("---0000---"+connection);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM t_read_num");
            while (resultSet.next()) {
//                System.out.print("id = " + resultSet.getInt(1));
//                System.out.println(" title= " + resultSet.getString(2).replace("\n", "").replace("\r", ""));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
