package com.zedd.tdd.chap07;

import com.zedd.tdd.chap02.PasswordStrength;

public class PasswordChecker {
    public PasswordStrength checkPassword(String pw) {
        if (pw.length() <= 4)
            return PasswordStrength.WEEK;
        return PasswordStrength.NORMAL;
    }
}
