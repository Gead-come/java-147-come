package com.itheima;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserServiceTest {
    @Test
    public void testGetAge() {
        Integer age = new UserService().getAge("430123199901011234");
        System.out.println("age = " + age);
    }
    @Test
    public void testGetGender() {
        String gender = new UserService().getGender("430123199901011122");
        System.out.println("gender = " + gender);

    }
    @DisplayName("测试年龄")
    @ParameterizedTest  // 参数化测试
    @ValueSource(strings = {"430123199901011234", "43012319911011122", "430123199901011133"})
    public void testGetAge(String idcard) {
        Integer age = new UserService().getAge(idcard);
        System.out.println("age = " + age);
    }
}
