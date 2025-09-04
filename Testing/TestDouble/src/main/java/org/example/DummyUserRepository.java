package org.example;

class DummyUserRepository implements UserRepository {
    @Override
    public String findUserById(int id) { // 더미에서는 호출 안 함
//        return "";
        throw new UnsupportedOperationException("Dummy: Not implemented");
    }

    @Override
    public void saveUser(String user) { // 더미에서는 호출 안 함
        throw new UnsupportedOperationException("Dummy: Not implemented");
    }

    @Override
    public int countUsers() { // 더미에서는 호출 안 함
        throw new UnsupportedOperationException("Dummy: Not implemented");
    }
}
