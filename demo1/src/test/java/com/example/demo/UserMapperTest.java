package com.example.demo;


import com.example.demo.entiyt.User11;
import com.example.demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@SpringBootTest(classes = Demo1ApplicationTests.class)
@SpringBootTest
public class UserMapperTest {
   @Autowired
   private UserMapper userMapper;

@Test
    public void test(){

    List<User11> list = userMapper.list();
    for (User11 user : list) {
        System.out.println(user);
    }
}


}
