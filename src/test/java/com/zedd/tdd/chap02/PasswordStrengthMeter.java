package com.zedd.tdd.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength check(String password) {
        if (password.length() < 8)
            return PasswordStrength.NORMAL;
        boolean containsNum = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                containsNum = true;
                break;
            }
        }
        if (!containsNum) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }
}
