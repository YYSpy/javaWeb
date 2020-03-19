package cn.itcast.jdbc;

import java.sql.*;

/**
 * 执行DDL语句
 */
public class JDBCDemo6 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            //3.定义sql
            String sql  = "select * from stu";
            //4.获取执行sql对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.处理结果
            //6.1 让游标向下移动一行
            rs.next();
            //6.2 获取数据
            int id = rs.getInt(1);
            String phone_name = rs.getString("phone_num");

            System.out.println(id + "---" + phone_name);


            //6.1 让游标向下移动一行
            rs.next();
            //6.2 获取数据
            int id2 = rs.getInt(1);
            String name2 = rs.getString("phone_num");


            System.out.println(id2 + "---" + name2 );

//            //6.1 让游标向下移动一行
//            rs.next();
//            //6.2 获取数据
//            int id3 = rs.getInt(1);
//            String name3 = rs.getString("phone_num");
//
//            System.out.println(id3 + "---" + name3 );


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源

            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
