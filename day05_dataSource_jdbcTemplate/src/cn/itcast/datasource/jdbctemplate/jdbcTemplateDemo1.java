package cn.itcast.datasource.jdbctemplate;

import cn.itcast.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class jdbcTemplateDemo1 {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建jdbcTemplatede对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update stu set phone_num='qqq' where id=?";
        int count = template.update(sql,4);

        System.out.println(count);
    }
}
