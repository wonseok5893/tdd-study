package com.zedd.tdd.chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpirationDeterminerTest {

    private void assertExpireDate(LocalDateTime beforeDateTime, int pay, LocalDateTime expectedDateTime) {
        ExpirationDeterminer determiner = new ExpirationDeterminer();
        LocalDateTime newExpiredDate = determiner.determine(beforeDateTime, pay);
        assertEquals(newExpiredDate, expectedDateTime);
    }

    @Test
    void 십만원을_납부하면_서비스를_1년_제공() {
        LocalDateTime beforeDateTime = LocalDateTime.now();
        assertExpireDate(beforeDateTime, 100000, beforeDateTime.plusYears(1));
    }

    @Test
    void 만원을_납부하면_서비스를_1달_제공() {
        LocalDateTime beforeDateTime = LocalDateTime.now();
        assertExpireDate(beforeDateTime, 10000, beforeDateTime.plusMonths(1));
    }

    @Test
    void 두달이상_요금을_납부할_수_있다() {
        LocalDateTime beforeDateTime = LocalDateTime.now();
        assertExpireDate(beforeDateTime, 20000, beforeDateTime.plusMonths(2));
        assertExpireDate(beforeDateTime, 30000, beforeDateTime.plusMonths(3));
    }
}
