package com.zedd.tdd.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength check(String password) {
        if (password == null || password.isEmpty()) return PasswordStrength.INVALID;
        int metCount = 0;
        boolean lengthEnough = password.length() >= 8;
        boolean containsNum = isContainsNum(password);
        boolean containsUpper = isContainsUpper(password);

        if (lengthEnough) metCount++;
        if (containsNum) metCount++;
        if (containsUpper) metCount++;

        if (metCount == 1) return PasswordStrength.WEEK;

        if (!lengthEnough) return PasswordStrength.NORMAL;
        if (!containsNum) return PasswordStrength.NORMAL;
        if (!containsUpper) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
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
