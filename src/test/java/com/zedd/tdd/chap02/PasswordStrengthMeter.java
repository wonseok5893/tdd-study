package com.zedd.tdd.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength check(String password) {
        if (password == null || password.isEmpty()) return PasswordStrength.INVALID;
        int metCount = getMetCriteriaCounts(password);
        if (metCount <= 1) return PasswordStrength.WEEK;
        if (metCount == 2) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }

    private int getMetCriteriaCounts(String password) {
        int metCount = 0;
        if (password.length() >= 8) metCount++;
        if (isContainsNum(password)) metCount++;
        if (isContainsUpper(password)) metCount++;
        return metCount;
    }

    private boolean isContainsUpper(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) return true;
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
