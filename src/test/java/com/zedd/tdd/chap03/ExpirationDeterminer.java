package com.zedd.tdd.chap03;

import java.time.LocalDateTime;

public class ExpirationDeterminer {

    public LocalDateTime determine(LocalDateTime before, int pay) {
        LocalDateTime temp = before.plusYears(pay / 100000);
        return temp.plusMonths((pay % 100000) / 10000);
    }
}
