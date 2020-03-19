package cn.itcast.test;

import cn.itcast.Dao.UserDao;
import cn.itcast.domain.User;

public class UserDaoTest {


    @org.junit.Test
    public void testLogin(){

        User user = new User();
        user.setUsername("superbaby");
        user.setPassword("123");

        UserDao userDao = new UserDao();
        User login = userDao.login(user);

        System.out.println(login);
    }

}
