package com.zedd.tdd.chap02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PasswordStrengthMeterTest {
    PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String s, PasswordStrength strong) {
        PasswordStrength result = meter.check(s);
        assertEquals(strong, result);
    }

    @Test
    void 암호가_모든_조건을_충족하면_암호_강도는_강함() {
        assertStrength("abcdef!@A12", PasswordStrength.STRONG);
    }


    @Test
    void 암호가_8글자_미만_조건을_제외한_모든_조건을_충족하면_암호_강도는_보통() {
        assertStrength("abcd@A1", PasswordStrength.NORMAL);
    }

    @Test
    void 암호가_숫자를_포함하지_않는_조건을_제외한_모든_조건을_충족하면_암호_강도는_보통() {
        assertStrength("abcasdAasdsad", PasswordStrength.NORMAL);
    }

    @Test
    void 값이_없는_경우() {
        assertStrength(null, PasswordStrength.INVALID);
    }

    @Test
    void 암호가_대문자를_포함하지_않는_조건을_제외한_모든_조건을_충족하면_암호_강도는_보통() {
        assertStrength("aasdasdasdsad12", PasswordStrength.NORMAL);
    }

    @Test
    void 암호가_길이가_8글자_이상_조건만_충족하면_암호_강도는_약함() {
        assertStrength("aasdasdasdsasd", PasswordStrength.WEEK);
    }

    @Test
    void 암호가_숫자를_포함하는_조건만_충족하는_암호_강도는_약함() {
        assertStrength("12312",PasswordStrength.WEEK);
    }
    @Test
    void 암호가_대문자를_포함하는_조건만_충족하는_암호_강도는_약함() {
        assertStrength("asdABCD",PasswordStrength.WEEK);
    }
}
