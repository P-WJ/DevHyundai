package 게임만들기;

// Thread로 상속 받아 쓰레드 구현
// GameThA : 전사 캐릭터로 간주
public class GameThA extends Thread {
    private Character warrior; // 외부에서 접근 허용을 막기 위해 private 설정
    private Character wizard; // Character 클래스로 참조 변수를 생성

    // 생성자 호출 시 매개변수로 생성된 캐릭터의 객체를 넘겨 받음
    public GameThA(Character warrior, Character wizard) {
        this.warrior = warrior; // 매개변수로 넘겨 받은 객체를 인스턴스 필드 변수에 넘겨 줌
        this.wizard = wizard;
    }

    @Override // 생략 해도 됨, 어노테이션을 널어주는 이유는 컴파일 시 체크를 위함
    public void run() {
        int normal; // 일반공격에 대한 확률 구하기
        int special; // 특수 공격에 대한 확률 구하기
        boolean endGame = false; // 게임의 진행 여부 판단하는 플래그
        while (true) { // 해당 쓰레드를 무한 반복하도록 만듬
            try {
                sleep(3000); // 게임의 진행 속도를 맞추기 위함. (3초 대기)
                normal = (int) (Math.random() * 2); // 50% 확률을 구한다.
                special = (int) (Math.random() * 20); // 5% 확률을 구함.
                if (normal == 1) { // normal 은 0/1 만 있음
                    System.out.println("물리 공격 : " + wizard.name + "에게"
                            + warrior.pAttack() + "데미지를 입혔습니다.");
                    endGame = wizard.setDamage(warrior.pAttack());
                } else {
                    System.out.println("마법 공격 : " + wizard.name + "에게"
                            + warrior.mAttack() + "데미지를 입혔습니다.");
                    endGame = wizard.setDamage(warrior.mAttack());
                }
                if (special == 10) { // 10이라는 값이 나올 확률은 1/20 이다.
                    System.out.println(warrior.name + " 궁극기 발동 !!!, "
                            + wizard.name + "에게" + warrior.ultimate() +
                            "데미지를 입혔습니다.");
                    endGame = wizard.setDamage(warrior.ultimate());
                }
                if (endGame) {
                    System.exit(0);
                }

            } catch (InterruptedException e) {
            }
        }
    }
}