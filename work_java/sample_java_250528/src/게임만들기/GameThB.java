package 게임만들기;

// 마법사 쓰레드 만들기
public class GameThB extends Thread {
    private Character warrior; // 외부에서 접근 허용을 막기 위해 private 설정
    private Character wizard; // Character 클래스로 참조 변수를 생성

    // 생성자 호출 시 매개변수로 생성된 캐릭터의 객체를 넘겨 받음
    public GameThB(Character warrior, Character wizard) {
        this.warrior = warrior; // 매개변수로 넘겨 받은 객체를 인스턴스 필드 변수에 넘겨 줌
        this.wizard = wizard;
    }

    @Override
    public void run() {
        int normal; // 일반공격에 대한 확률 구하기
        int special; // 특수 공격에 대한 확률 구하기
        boolean endGame = false; // 게임의 진행 여부 판단하는 플래그
        while (true) { // 해당 쓰레드를 무한 반복하도록 만듬
            try {
                sleep(3300);
                normal = (int) (Math.random() * 2);
                special = (int) (Math.random() * 18);
                if (normal == 1) {
                    System.out.println("마법 공격 : " + warrior.name + " 에게" +
                            wizard.mAttack() + " 데미지를 입혔습니다.");
                    endGame = warrior.setDamage(wizard.mAttack());
                } else {
                    System.out.println("물리 공격 : " + warrior.name + " 에게" +
                            wizard.pAttack() + " 데미지를 입혔습니다.");
                    endGame = warrior.setDamage(wizard.pAttack());
                }
                if (special == 10) { // 1/18 확률로 발동
                    System.out.println(wizard.name + " 궁극기 발동 !!!!, "
                            + warrior.name + "에게" + wizard.ultimate()
                            + "데미지를 입혔습니다.");
                    endGame = warrior.setDamage(wizard.ultimate());
                }
                if (endGame) System.exit(0);
            } catch (InterruptedException e) {
            }
        }
    }
}