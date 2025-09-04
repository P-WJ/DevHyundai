package org.example;

import java.util.HashMap;
import java.util.Map;

public class FakeUserRepository implements UserRepository {
    private final Map<Integer, String> fakeDb = new HashMap<>();
    private int nextId = 1;

    @Override
    public String findUserById(int id) {
        return fakeDb.getOrDefault(id, null);
    }

    @Override
    public void saveUser(String user) { fakeDb.put(nextId++, user); }

    @Override
    public int countUsers() { return fakeDb.size(); }
}
