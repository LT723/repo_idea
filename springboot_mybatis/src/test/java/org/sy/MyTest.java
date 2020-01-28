package org.sy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.sy.bean.User;
import org.sy.mapper.UserMapper;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SyApplication.class)
public class MyTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void queryUser(){
        List<User> users = mapper.selectUsers();
        for (User user:users
             ) {
            System.out.println(user);
        }
    }
}
