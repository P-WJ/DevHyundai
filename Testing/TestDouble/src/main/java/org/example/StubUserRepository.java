package org.example;

public class StubUserRepository implements UserRepository {
    @Override
    public String findUserById(int id) {
        // 미리 정의된 응답: ID가 1이면 "Alice" 반환, 그 외 null
        return id == 1 ? "Alice" : null;
    }

    @Override
    public void saveUser(String user) {
        // 스텁에서는 실제 저장 동작을 하지 않음 (필요 시 동작 추가 가능)
    }

    @Override
    public int countUsers() {
        // 미리 정의된 응답: 항상 5 반환
        return 5;
    }
}
