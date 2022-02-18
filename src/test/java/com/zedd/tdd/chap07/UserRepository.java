package com.zedd.tdd.chap07;

public interface UserRepository {
    User save(User user);

    User findById(String id);
}
