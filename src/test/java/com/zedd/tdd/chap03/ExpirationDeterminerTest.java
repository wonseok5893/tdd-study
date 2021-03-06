package com.zedd.tdd.chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpirationDeterminerTest {
    LocalDateTime beforeDateTime = LocalDateTime.now();

    private void assertExpireDate(int pay, LocalDateTime expectedDateTime) {
        ExpirationDeterminer determiner = new ExpirationDeterminer();
        LocalDateTime newExpiredDate = determiner.determine(beforeDateTime, pay);
        assertEquals(newExpiredDate, expectedDateTime);
    }

    @Test
    void 십만원을_납부하면_서비스를_1년_제공() {
        assertExpireDate(100000, beforeDateTime.plusYears(1));
    }

    @Test
    void 만원을_납부하면_서비스를_1달_제공() {
        assertExpireDate(10000, beforeDateTime.plusMonths(1));
    }

    @Test
    void 두달이상_요금을_납부할_수_있다() {
        assertExpireDate(20000, beforeDateTime.plusMonths(2));
        assertExpireDate(30000, beforeDateTime.plusMonths(3));
    }

    @Test
    void 이십만원을_납부_하는_경우() {
        assertExpireDate(200000, beforeDateTime.plusYears(2));
    }

    @Test
    void N만원을_납부_하는_경우() {
        IntStream.rangeClosed(1, 9)
                .forEach(num -> assertExpireDate(num * 10000, beforeDateTime.plusMonths(num)));
        IntStream.rangeClosed(10, 19)
                .forEach(num -> {
                    LocalDateTime temp = beforeDateTime.plusYears(1);
                    assertExpireDate(num * 10000, temp.plusMonths(num % 10));
                });

    }

    @Test
    void 지불을_안한_경우() {
        assertExpireDate(0, beforeDateTime);
    }
}
