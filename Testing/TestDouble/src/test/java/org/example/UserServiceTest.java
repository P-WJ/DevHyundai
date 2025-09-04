package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    // 더미, 스텁, 페이크는 가짜 구현체 만들어야 한다.
    // 더미는 실제로 호출하지 않으나 목으로 대체가 가능"은" 하다.
    ///  실무에서의 활용: 가짜 구현체 직접 구현하지 않음
    // Dummy
    @Mock
    UserRepository dummyRepo;

    // Stub
    @Mock
    private UserRepository stubRepo;

    // Mock
    @Mock
    UserRepository mockRepo;

    // Spy
    @Spy
    UserRepository spyRepo = new MySQLUserRepository();


    // 서비스 대상 인스턴스
    @InjectMocks // @InjectMocks : userService에 테스트 더블"들" 주입
    UserService userService;






    /// Dummy
    // - UserService를 테스트하기 위해 의존성만 주입하기 위해
    // -객체를 채우기 위해 사용, 메서드 호출하지 않음

    @Test
    void testDummy() {
        // Dummy: 단순히 객체를 채우기 위해 사용, 실제로 호출되지 않음
        UserRepository dummy = new DummyUserRepository();
        UserService userService = new UserService(dummy);
        // 테스트에서 dummy의 메서드는 호출되지 않음

        // 의존하고 있는 구현체의 메소드를 호출하면 안된다. 아래는 잘못된 테스트
//        assertThat(userService.getUserById(1)).isEqualTo("User1");

        // 가짜 객체(테스트 더블) 호출 안하고 테스트 대상(userService)의 인스턴스가 잘 생성되는지만 확인
        assertThat(userService).isNotNull();

        // 의존하고 있는 인터페이스의 구현체의 메소드를 호출하지 않는다.
        // userService가 의존하고 있지 않은 메소드만 호출한다.
        assertThat(userService.notUseUserRepository()).isEqualTo("NotUseUserRepository");
    }

    @Test
    void  우리_코드는_더미의_메소드를_호출했을_때의_테스트_케이스도_만들어놨어요() {
        UserRepository dummy = new DummyUserRepository();
        UserService userService = new UserService(dummy);
        assertThatThrownBy(() -> {
            userService.getUserById(1);
        })
                .isInstanceOf(UnsupportedOperationException.class);
    }


    @Test
    // Stub
    // - 테스트 대상 객체가 의존하는 객체의 동작을 미리 정의된 응답을 대체하여 테스트를 단순화
    // - 더미와 달리 스텁은 메서드 호출에 대해 특정 값을 반환하도록 설정
    // - 스텁은 주로 테스트 대상의 동작이(테스트 결과가) 의존 객체의 반환값에 따라 달라질 떄 사용
    ///  실무에서 언제 , 왜 사용할까?
    /// - 테스트 대상 객체가 의존 객체의 반환값에 따라 다른 동작을 할때
    /// - 특정 시나리오(예: 성공, 실패, 예외 등) 시물레이션 할떄
    /// 실제 구현체 RealUserRepository를 대신해 StubUserRepository를 토해
    /// 테스트 시나리오를 정해놓는다. 원하는 시나리오 미리 셋팅하기 위해
    void testWithStub() {

        // 스텁 생성
        UserRepository stub = new StubUserRepository();
        UserService userService = new UserService(stub);

        // 테스트 1: getUserById 호출
        assertThat(userService.getUserById(1)).isEqualTo("Alice");
        assertThat(userService.getUserById(2)).isNull(); // 스텁이 null 반환

        // 테스트 2: getUserCount 호출
        assertThat(userService.getUserCount()).isEqualTo(5); // 스텁이 5 반환

        // 테스트 3: UserService 인스턴스 확인
        assertThat(userService).isNotNull();
    }

    ///  Spy
    // - 스파이는 실제 객체를 감싼다. ex> spy(MySqlUserRepository()), spy(RealRepository())
    // - 기본적으로 실제 메서드 호출, 일부 스텁 가능
    // - 호출 검증 가능
    ///  실무에서 언제 사용할까?
    // 실제 객체의 동작을 테스트하고 싶지만, 특정 메서드의 반환값을 제어해야 할 때.
    // 메서드 호출 여부나 횟수를 검증하면서 실제 로직도 일부 실행하고 싶을 때.
    // 실제 구현체의 동작이 복잡하거나 외부 의존성(예: DB)이 없어도 동작해야 할 때.

    @Test void testWithSpy() {
        // 실제 UserRepository 구현체
        UserRepository realRepo = new MySQLUserRepository();
        // 스파이 생성
        UserRepository spyRepo = spy(realRepo);

        // UserService 인스턴스 생성
        UserService userService = new UserService(spyRepo);

        // 테스트 1: 실제 동작 확인 (스파이의 기본 동작은 실제 메서드 호출)
        userService.saveUser("Alice");
        assertThat(userService.getUserById(1)).isEqualTo("Alice"); // 실제 로직 실행
        assertThat(userService.getUserCount()).isEqualTo(1); // 실제 로직 실행

        // 테스트 2: 특정 메서드 스텁처럼 동작 설정
        when(spyRepo.findUserById(2)).thenReturn("Bob"); // findUserById(2)를 스텁
        assertThat(userService.getUserById(2)).isEqualTo("Bob"); // 스텁 동작
        assertThat(userService.getUserCount()).isEqualTo(1); // 실제 로직 (여전히 1)

        // 테스트 3: 메서드 호출 검증
        userService.saveUser("Charlie");
        verify(spyRepo, times(2)).saveUser(anyString()); // saveUser가 2번 호출됨
        verify(spyRepo).saveUser("Charlie"); // 특정 인자로 호출됨

        // 테스트 4: UserService 인스턴스 확인
        assertThat(userService).isNotNull();
    }

    ///  Mock
    // - 목은 스파이와 비슷하게 호출 검증 등이 가능하다.
    // - 완전히 가짜 객체 UserRepository 인터페이스를 mock()으로 묶어서 주입한다.
    /// 실무에서 언제 사용할까?
    /// - 테스트 대상 객체가 의존 객체의 특정 메서드를 정확히 호출하는지, 올바른 인자로 호출하는지 확인할 때.

    @Test
    void testWithMock() {
        // 목 생성: 실제 구현체 없이 가짜 UserRepository
        UserRepository mockRepo = mock(UserRepository.class);

        // UserService 인스턴스 생성
        UserService userService = new UserService(mockRepo);

        // 목 동작 정의 (스텁처럼)
        when(mockRepo.findUserById(1)).thenReturn("Alice");
        when(mockRepo.findUserById(2)).thenReturn("Bob");
        when(mockRepo.countUsers()).thenReturn(1);

        // 테스트 1: getUserById 호출
        assertThat(userService.getUserById(1)).isEqualTo("Alice"); // 모크 반환값
        assertThat(userService.getUserById(2)).isEqualTo("Bob"); // 모크 반환값

        // 테스트 2: getUserCount 호출
        assertThat(userService.getUserCount()).isEqualTo(1); // 모크 반환값

        // 테스트 3: 메서트 호출 검증
        userService.saveUser("Charlie");
        verify(mockRepo, times(1)).saveUser("Charlie"); // saveUser("Charlie") 1번 호출
        verify(mockRepo, times(1)).saveUser(anyString()); // saveUser 총 1번 호출

        // 테스트 4: 추가 검증 - 다른 인자로 호출되지 않음
        verify(mockRepo, never()).saveUser("Alice"); // saveUser("Alice") 호출 안됨

        // 테스트 5: UserService 인스턴스 확인
        assertThat(userService).isNotNull();
    }

    ///  Fake
    // - 페이크는 실제 동작을 시뮬레이션 하기 위해 만든다.
    // - 실제 구현체에 접근을 하진 않지만 최대한 비슷하게 구현해서 테스트하기 위해.
    // - In-Memory 에서 실제 DB에 접근하는 것 같은 동작은 구현할 수 있다.

    @Test
    void testWithFake() {
        // 페이크 레포지토리 생성
        UserRepository fakeRepo = new FakeUserRepository();
        UserService userService = new UserService(fakeRepo);

        // 테스트 1: 유저 저장 및 조회
        userService.saveUser("Alice");
        assertThat(userService.getUserById(1)).isEqualTo("Alice"); // 저장된 유저 조회
        assertThat(userService.getUserCount()).isEqualTo(1); // 유저 수 확인

        // 테스트 2: 추가 유저 저장 및 조회
        userService.saveUser("Bob");
        assertThat(userService.getUserById(2)).isEqualTo("Bob"); // 두 번째 유저 조회
        assertThat(userService.getUserCount()).isEqualTo(2); // 유저 수 증가

        // 테스트 3: 존재하지 않는 유저 조회
        assertThat(userService.getUserById(3)).isNull(); // 없는 ID는 null 반환

        // 테스트 4: UserService 인스턴스 확인
        assertThat(userService).isNotNull();
    }

    @Test
    void testWithMock2() {
        // 목 생성: 실제 구현체 없이 가짜 UserRepository
//        UserRepository mockRepo = mock(UserRepository.class);

        // UserService 인스턴스 생성
//        UserService userService = new UserService(mockRepo);

        // 목 동작 정의 (스텁처럼)
        when(mockRepo.findUserById(1)).thenReturn("Alice");
        when(mockRepo.findUserById(2)).thenReturn("Bob");
        when(mockRepo.countUsers()).thenReturn(1);

        // 테스트 1: getUserById 호출
        assertThat(userService.getUserById(1)).isEqualTo("Alice"); // 모크 반환값
        assertThat(userService.getUserById(2)).isEqualTo("Bob"); // 모크 반환값

        // 테스트 2: getUserCount 호출
        assertThat(userService.getUserCount()).isEqualTo(1); // 모크 반환값

        // 테스트 3: 메서트 호출 검증
        userService.saveUser("Charlie");
        verify(mockRepo, times(1)).saveUser("Charlie"); // saveUser("Charlie") 1번 호출
        verify(mockRepo, times(1)).saveUser(anyString()); // saveUser 총 1번 호출

        // 테스트 4: 추가 검증 - 다른 인자로 호출되지 않음
        verify(mockRepo, never()).saveUser("Alice"); // saveUser("Alice") 호출 안됨

        // 테스트 5: UserService 인스턴스 확인
        assertThat(userService).isNotNull();
    }
}

// Dummy
@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {
    @Mock
    UserRepository dummyRepo;

    @InjectMocks
    UserService userService;

    @Test
    void testDummy() {
        assertThat(userService).isNotNull();
    }
}

// Stub
@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {
    @Mock
    UserRepository stubRepo;

    @InjectMocks
    UserService userService;

    @Test
    void testStub() {
        when(stubRepo.findById(1L)).thenReturn(Optional.of(new User(1L, "Alice")));
        when(stubRepo.count()).thenReturn(1L);

        assertThat(userService.getUserNameById(1L)).isEqualTo("Alice");
        assertThat(userService.getUserCount()).isEqualTo(1);
    }
}

// Spy
@ExtendWith(MockitoExtension.class)
class UserServiceUnitTest {
    @Spy
    UserRepository spyRepo = new InMemoryUserRepository();

    @InjectMocks
    UserService userService;

    @Test
    void testSpy() {
        userService.saveUser("Alice");
        assertThat(userService.getUserNameById(1L)).isEqualTo("Alice");

        when(spyRepo.findById(2L)).thenReturn(Optional.of(new User(2L, "Bob")));
        assertThat(userService.getUserNameById(2L)).isEqualTo("Bob");

        verify(spyRepo).save(any(User.class));
    }
}

//// Mock
//@ExtendWith(MockitoExtension.class)
//class UserServiceUnitTest {
//    @Mock
//    UserRepository mockRepo;
//
//    @InjectMocks
//    UserService userService;
//
//    @Test
//    void testMock() {
//        when(mockRepo.findById(1L)).thenReturn(Optional.of(new User(1L, "Alice")));
//        when(mockRepo.count()).thenReturn(1L);
//
//        assertThat(userService.getUserNameById(1L)).isEqualTo("Alice");
//        assertThat(userService.getUserCount()).isEqualTo(1);
//
//        userService.saveUser("Bob");
//        verify(mockRepo).save(any(User.class));
//    }
//}
//
//// Fake
//@DataJpaTest
//class UserServiceIntegrationTest {
//    @Autowired
//    UserRepository userRepository;
//
//    UserService userService;
//
//    @BeforeEach
//    void setUp() {
//        userService = new UserService(userRepository);
//    }
//
//    @Test
//    void testH2() {
//        userService.saveUser("Alice");
//        assertThat(userService.getUserNameById(1L)).isEqualTo("Alice");
//        assertThat(userService.getUserCount()).isEqualTo(1);
//    }
//}