package com.zedd.tdd.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PasswordStrengthMeterTest {
    @Test
    void 암호가_모든_조건을_충족하면_암호_강도는_강함() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.check("abcdef!@");
        assertEquals(PasswordStrength.STRONG, result);
    }
}
