package 게임만들기;

// 실제 게임 캐릭터로 만들어 질 클래스
public class Character extends Unit implements GameAction {
    // name : 캐릭터 이름
    // pP : 물리 힘
    // mP : 마법 힘
    // pH : 물리 적중률
    // mH : 마법 적중률
    // ultra : 특수 기술에 대한 공격력
    // hp : 체력
    // 캐릭터가 가지는 기본적인 능력치를 생성자를 통해서 결정 함 (캐릭터간의 밸런스를 맞춤)
    public Character(String name, int pP, int mP, double pH, double mH, int ultra, int hp) {
        this.name = name; // this 는 자신의 객체를 참조하는 참조 변수 임.
        this.pPower = pP;
        this.mPower = mP;
        this.pHit = pH;
        this.mHit = mH;
        this.ultraPower = ultra;
        this.hp = hp;
    }

    @Override
    // 물리 공격력 :물리적인 힘 * 원래는 확률로 계산하는게 원칙이지만 코드를 간단하기 위해서
    public double pAttack() {
        return pPower * pHit;
    }

    @Override
    // 마법 공격력
    public double mAttack() {
        return mPower * mHit;
    }

    @Override
    // 궁극기 : 특수 능력
    public int ultimate() {
        return ultraPower;
    }

    @Override
    // 해당 캐릭터가 공격을 받아서 받는 피해량 반영 함
    public boolean setDamage(double damage) {
        if (hp > damage) {
            hp -= damage;
            System.out.println("남아 있는 " + name + "의 체력은 " + hp + "입니다.");
            return false; // false 는 캐릭터가 살아 있음을 의미 함.
        } else {
            System.out.println(name + "이 죽었습니다. 게임을 종료 합니다.");
            return true;
        }
    }
}