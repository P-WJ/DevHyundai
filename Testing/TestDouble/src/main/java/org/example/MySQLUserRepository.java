package org.example;

import java.util.HashMap;
import java.util.Map;

// 실제 레포지토리 구현체라고 생각하자.
public class MySQLUserRepository implements UserRepository {
    private final Map<Integer, String> userTable = new HashMap<>();
    private int nextId = 1;

    @Override
    public String findUserById(int id) {
        return userTable.getOrDefault(id, null); // MySQL SELECT 쿼리 흉내
    }

    @Override
    public void saveUser(String user) {
        userTable.put(nextId++, user); // MySQL INSERT 쿼리 흉내
    }

    @Override
    public int countUsers() {
        return userTable.size(); // MySQL COUNT 쿼리 흉내
    }
}
