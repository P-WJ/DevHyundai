package 인터페이스2;

public class FiveG implements NetworkAdapter {
    @Override
    public void connect() {
        System.out.println("5G에 연결되었습니다.");
    }

    @Override
    public void send(String msg) {
        System.out.println("5G >> " + msg);
    }
}