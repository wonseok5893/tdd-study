package com.zedd.tdd.chap03;

import java.time.LocalDateTime;

public class ExpirationDeterminer {

    public LocalDateTime determine(LocalDateTime before, int i) {
        return before.plusYears(1);
    }
}
