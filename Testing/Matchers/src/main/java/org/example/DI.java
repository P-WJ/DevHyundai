package org.example;

public class DI {
    // 의존성 주입
    OrderService orderService = new OrderService(new MySQLUserRepository());

    void addUser(User user){
        // 여기서 user을 삽입

    }
}

class User{
    static Long INDEX = 0L;
    private Long id;
    private String name;
    private int age;

    public User(String name, int age) {
        this.id = INDEX++;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Long getId(){
        return id;
    }
}


interface UserRepository{
    public User findById(Long id);
}

class MySQLUserRepository implements UserRepository {
    public User findById(Long id){
        return new User("사용자",30);
    }
}

class OrderService{
    private final UserRepository userRepository;

    public OrderService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void placeOrder(Long userId){
        User user = userRepository.findById(userId);
        System.out.println(user.getName() + "주문 처리 완료");
    }
}




// * 의존성을 줄이는 방법 : interface를 만들어서 어떤 행위에 대해서만 제약을 줌
// ! 테스트 용이성 : 가짜(모킹) 구현체를 쉽게 만들 수 있음
// ! 유연성 : DB교체, 외부 API 교체시 코드 수정 최소화
// ! 재사용성 : 서비스 계층은 구현제에 구애받지 않고 사용 가능
// ! OCP(Open-closed Principle) : 기존 코드를 수정하지 않고 기능 확장 가능
// ! 확장에는 열려있고, 수정에는 닫혀 있어야 한다.
// ! open : 기능을 확장하는 것이 열려있다.
// ! close : 기존의 코드를 수정하지 않아야 한다.
// ! 프로그램을 설계할 때 새로운 요구사항이나 기능 추가가 생기면
// ! 기존 코드를 고치지 않고 새로운 코드를 추가하는 방식으로 해결

// * 의존성 역전
// ! OrderService(상위 모듈) -> MySQLUserRepository ( 하위 모듈, 구현체 )
// ! OrderService(상위 모듈) -> UserRepository (추상화, 인터페이스) <- MySQLUserRepository, InMemoryRepository ( 하위 모듈 )
// ! 즉, "즉, 상위 모듕리 구현체에 끌려다니는 게아니라, 구현체가 상위 모듈의 요구(인터페이스)에 맞춘다" -> 의존 바향이 역전된 것 입니다.
// !