package com.zedd.tdd.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength check(String password) {
        if (password.length() < 8)
            return PasswordStrength.NORMAL;
        boolean containsNum = isContainsNum(password);
        if (!containsNum) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private boolean isContainsNum(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }
}
