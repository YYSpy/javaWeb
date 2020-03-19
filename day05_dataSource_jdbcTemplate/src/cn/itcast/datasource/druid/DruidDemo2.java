package cn.itcast.datasource.druid;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        Connection  conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into stu values(NULL,?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,"dsad");
            int count=pstmt.executeUpdate();
            System.out.println(count);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }
    }
}
