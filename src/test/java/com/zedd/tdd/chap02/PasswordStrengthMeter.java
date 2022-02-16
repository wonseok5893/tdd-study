package com.zedd.tdd.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength check(String password) {
        if (password == null) return PasswordStrength.INVALID;
        if (password.length() < 8)
            return PasswordStrength.NORMAL;
        boolean containsNum = isContainsNum(password);
        if (!containsNum) return PasswordStrength.NORMAL;
        boolean containsUpper = isContainsUpper(password);
        if(!containsUpper) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private boolean isContainsUpper(String password) {
        for (char c : password.toCharArray()) {
            if(Character.isUpperCase(c))return true;
        }
        return false;
    }

    private boolean isContainsNum(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) return true;
        }
        return false;
    }
}
