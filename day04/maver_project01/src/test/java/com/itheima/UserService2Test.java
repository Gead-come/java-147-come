package com.itheima;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserService2Test {
    @DisplayName("测试性别") // 起别名
    @ParameterizedTest  // 参数化测试
    @ValueSource(strings = {"430123199901011234", "43012319911011122", "430123199901011133"})
    public void testGetGender(String idcard) {
        String gender = new UserService().getGender(idcard);
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
