package com.zedd.tdd.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PasswordStrengthMeterTest {
    @Test
    void 암호가_모든_조건을_충족하면_암호_강도는_강함() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.check("abcdef!@A12");
        assertEquals(PasswordStrength.STRONG, result);
    }
    @Test
    void 암호가_8글자_미만_조건을_제외한_모든_조건을_충족하면_암호_강도는_보통() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.check("abcd@A1");
        assertEquals(PasswordStrength.NORMAL, result);
    }

    @Test
    void 암호가_숫자를_포함하지_않는_조건을_제외한_모든_조건을_충족하면_암호_강도는_보통() {
        PasswordStrengthMeter meter = new PasswordStrengthMeter();
        PasswordStrength result = meter.check("abcasdAasdsad");
        assertEquals(PasswordStrength.NORMAL, result);
    }
}
