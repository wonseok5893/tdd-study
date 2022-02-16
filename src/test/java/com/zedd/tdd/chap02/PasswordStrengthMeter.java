package com.zedd.tdd.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength check(String password) {
        if (password.length() < 8)
            return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }
}
