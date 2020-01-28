package org.sy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.sy.bean.User;
import org.sy.dao.UserDao;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SyApplication.class)
public class MyTest {

    @Autowired
    public UserDao dao;

    @Test
    public void tets1(){
        List<User> all = dao.findAll();
        System.out.println(all);
    }
}
