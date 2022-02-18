package com.zedd.tdd.chap05;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Junit5Study {

    List<String> list = new ArrayList<String>();


    @Test
    void 활용_assertThrows() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("zedd make test");
        });
        assertTrue(exception.getMessage().contains("zedd"));
    }

    @Test
    void 활용_assertAll() {
        assertAll(
                () -> assertEquals(1, 1),
                () -> assertEquals(10, 10)
        );
    }

    @BeforeEach
    void setUp() {
        System.out.println("beforeEach is going to start.");
    }

    @AfterEach
    void setDown() {
        System.out.println("beforeEach was completed.");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("afterAll");
    }

    @Test
    void 필드_공유_하지_않기() {
        list.add("1");
        assertEquals(list.size(), 1);
    }

    @Test
    void 필드_공유_하지_않기_2() {
        list.add("2");
        assertEquals(list.size(), 1);
    }
}
