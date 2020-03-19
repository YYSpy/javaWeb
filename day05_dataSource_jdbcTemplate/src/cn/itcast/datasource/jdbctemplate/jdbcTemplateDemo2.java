package cn.itcast.datasource.jdbctemplate;

import cn.itcast.datasource.domain.Student;
import cn.itcast.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class jdbcTemplateDemo2 {
    public static void main(String[] args) {
    }
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void test1(){
        String sql = "update stu set phone_num='qqq' where id=?";
        int count = template.update(sql,3);

        System.out.println(count);
    }

    @Test
    public void test2(){

        String sql = "insert into stu values (NULL,?)";
        int count = template.update(sql,"sdad");

        System.out.println(count);
    }

    @Test
    public void test3(){

        String sql = "delete from stu where id = ?";
        int count = template.update(sql,"5");

        System.out.println(count);
    }

    @Test
    public void test4(){

        String sql = "select * from stu where id=?";
        Map<String, Object> map = template.queryForMap(sql, 1);

        System.out.println(map);
    }

    @Test
    public void test5(){

        String sql = "select * from stu";
        List<Map<String, Object>> list = template.queryForList(sql);

        System.out.println(list);
    }

    @Test
    public void test6(){

        String sql = "select * from student";

        List<Student> list = template.query(sql, new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet resultSet, int i) throws SQLException {
                Student student = new Student();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                String address = resultSet.getString("address");
                int math = resultSet.getInt("math");
                int english = resultSet.getInt("english");

                student.setId(id);
                student.setName(name);
                student.setAge(age);
                student.setSex(sex);
                student.setAddress(address);
                student.setMath(math);
                student.setEnglish(english);

                return student;
            }
        });

        for (Student student:
                list    ) {
            System.out.println(student);
        }
    }

    @Test
    public void test6_2(){
        String sql = "select * from student";
        List<Student> list = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class));

        for (Student student:
           list  ) {
            System.out.println(student);
        }
    }


    @Test
    public void test7(){
        String sql = "select count(id) from student";

        long student = template.queryForObject(sql, long.class);
        System.out.println(student);

    }
}
