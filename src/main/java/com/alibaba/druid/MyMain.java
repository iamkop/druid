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
//        dataSource.wait

        try {
            DruidPooledConnection connection = dataSource.getConnection();
            System.out.println(connection);
//            connection.close();
            DruidPooledConnection connection1 = dataSource.getConnection();
            System.out.println(connection1);
            Statement statement = connection1.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM t_read_num");
            while (resultSet.next()) {
//                System.out.print("id = " + resultSet.getInt(1));
//                System.out.println(" title= " + resultSet.getString(2).replace("\n", "").replace("\r", ""));

            }
            statement.close();
            connection1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
