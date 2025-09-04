package org.example;

public interface UserRepository {
    String findUserById(int id);
    void saveUser(String user);
    int countUsers();
}
