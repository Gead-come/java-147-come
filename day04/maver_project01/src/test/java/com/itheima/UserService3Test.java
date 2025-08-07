package com.itheima;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserService3Test {
    @Test
    public void testGetAge() {
        Integer age = new UserService().getAge("430123199901011234");
        System.out.println("age = " + age);
    }
    @Test
    public void testGetGender() {
        String gender = new UserService().getGender("430123199901011122");
         assertEquals("男", gender, "性别测试失败");

    }

}
