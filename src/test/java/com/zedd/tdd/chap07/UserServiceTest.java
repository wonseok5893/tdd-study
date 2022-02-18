package com.zedd.tdd.chap07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {
    UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
    }

    @Test
    void 비밀번호가_약함인_경우_throw_exception() {
        assertThrows(WeekPasswordException.class,()->userService.register("zedd","1234","zedd@example.com"));
    }
}
