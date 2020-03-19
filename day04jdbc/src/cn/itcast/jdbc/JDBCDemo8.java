package cn.itcast.jdbc;

import cn.itcast.domain.Student;
import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo8 {

    public List<Student> findAll(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Student> list = null;
        try {
            //1. 注册驱动
//            Class.forName("com.mysql.jdbc.Driver");
//            //2.获取连接对象
//            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            JDBCUtils.getConnection();
            //3.定义sql
            String sql  = "select * from student";
            //4.获取执行sql对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Student student = null;
             list = new ArrayList<>();
            while (rs.next()){
                //获取数据
//                private int id;
//                private String name;
//                private int age;
//                private String sex;
//                private String address;
//                private int math;
//                private int english;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                String address = rs.getString("address");
                int math = rs.getInt("math");
                int english = rs.getInt("english");

                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                student.setSex(sex);
                student.setAddress(address);
                student.setMath(math);
                student.setEnglish(english);
                list.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }
        return list;
    }



    public List<Student> findAll2(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Student> list = null;
        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            //3.定义sql
            String sql  = "select * from student";
            //4.获取执行sql对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.遍历结果集，封装对象，装载集合
            Student student = null;
            list = new ArrayList<>();
            while (rs.next()){
                //获取数据
//                private int id;
//                private String name;
//                private int age;
//                private String sex;
//                private String address;
//                private int math;
//                private int english;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String sex = rs.getString("sex");
                String address = rs.getString("address");
                int math = rs.getInt("math");
                int english = rs.getInt("english");

                student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAge(age);
                student.setSex(sex);
                student.setAddress(address);
                student.setMath(math);
                student.setEnglish(english);
                list.add(student);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
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

            if(stmt != null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Student> students = new JDBCDemo8().findAll2();

        System.out.println(students);
    }
}
