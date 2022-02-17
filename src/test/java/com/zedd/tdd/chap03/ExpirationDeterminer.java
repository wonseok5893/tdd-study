package com.zedd.tdd.chap03;

import java.time.LocalDateTime;

public class ExpirationDeterminer {

    public LocalDateTime determine(LocalDateTime before, int pay) {
        if(pay<100000)
            return before.plusMonths(1);
        return before.plusYears(1);
    }
}
