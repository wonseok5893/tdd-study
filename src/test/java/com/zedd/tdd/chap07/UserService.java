package com.zedd.tdd.chap07;

import com.zedd.tdd.chap02.PasswordStrength;

public class UserService {
    private PasswordChecker passwordChecker;
    private UserRepository userRepository;

    public UserService(PasswordChecker passwordChecker, UserRepository userRepository) {
        this.passwordChecker = passwordChecker;
        this.userRepository = userRepository;
    }

    public User register(String id, String pw, String email) {
        if(passwordChecker.checkPassword(pw)==PasswordStrength.WEEK)
            throw new WeekPasswordException();
        User user = userRepository.findById(id);
        if(user!=null)
            throw new DuplicateIdException();
        return userRepository.save(new User(id, pw, email));
    }
}
