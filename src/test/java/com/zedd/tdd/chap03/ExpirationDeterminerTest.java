package com.zedd.tdd.chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpirationDeterminerTest {
    @Test
    void 십만원을_납부하면_서비스를_1년_제공() {
        ExpirationDeterminer determiner = new ExpirationDeterminer();
        LocalDateTime beforeExpiredDate = LocalDateTime.now();
        LocalDateTime newExpiredDate = determiner.determine(beforeExpiredDate, 100000);
        assertEquals(newExpiredDate, beforeExpiredDate.plusYears(1));
    }
}
