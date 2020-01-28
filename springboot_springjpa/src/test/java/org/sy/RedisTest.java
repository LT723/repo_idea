package org.sy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.sy.bean.User;
import org.sy.dao.UserDao;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SyApplication.class)
public class RedisTest {
    @Autowired
    private UserDao dao;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test1() throws Exception{
        //从redis缓存中获得指定的数据
        String s = redisTemplate.boundValueOps("user.findAll").get();

        //如果redis中没有数据的话
        if (null == s){
            //查询数据库获得数据
            List<User> all = dao.findAll();
            //转换成json格式字符串
            ObjectMapper objectMapper = new ObjectMapper();
            s = objectMapper.writeValueAsString(all);
            //将数据存储到redis中，下次在查询直接从redis中获得数据，不用在查询数据库
            redisTemplate.boundValueOps("user.findAll").set(s);
            System.out.println("===============从数据库获得数据===============");
        }else {
            System.out.println("===============从redis缓存中获得数据===============");
        }
        System.out.println(s);
    }

}
