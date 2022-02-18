package com.zedd.tdd.chap07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceTest {
    UserService userService;

    @BeforeEach
    void setUp() {
        PasswordChecker passwordChecker = new PasswordChecker();
        UserRepository userRepository = new MemoryUserRepository();
        userService = new UserService(passwordChecker, userRepository);
    }

    @Test
    void 비밀번호_강도가_약함인_경우_throw_exception() {
        assertThrows(WeekPasswordException.class, () -> userService.register("zedd", "1234", "zedd@example.com"));
    }

    @Test
    void 비밀번호_강도가_정상인_경우_success() {
        assertDoesNotThrow(() -> {
            userService.register("zedd", "12345", "zedd@example.com");
        });
    }

    @Test
    void 동일한_id가_존재() {
        userService.register("zedd", "12345", "zedd@example.com");
        assertThrows(DuplicateIdException.class,
                () -> userService.register("zedd", "12345", "zedd.@example.com"));
    }
}
