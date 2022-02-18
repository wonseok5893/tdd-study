package com.zedd.tdd.chap07;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {
    private Map<String, User> map = new HashMap<>();

    @Override
    public User save(User user) {
        return map.put(user.getId(),user);
    }

    @Override
    public User findById(String id) {
        return map.get(id);
    }
}
