package 게임만들기;

// 게임 캐릭터를 만들기 위해 기본 클래스 정의
// 게임캐릭터가 가져야 할 필수 요소 포함
// 상속을 주기 위해서 접근제한자는 protected(상속관계, 같은 패키지 접근 가능)
abstract public class Unit {
    protected String name; // 캐릭터 이름 설정
    protected int pPower; // 피지컬 Power (물리적인 힘)
    protected int mPower; // 매지컬 Power (마법의 힘)
    protected double pHit; // 물리 적중률
    protected double mHit; // 마법 적중률
    protected int ultraPower; // 궁극기 (해당 캐릭터가 가진 특수 능력)
    protected int hp; // 체력
}
