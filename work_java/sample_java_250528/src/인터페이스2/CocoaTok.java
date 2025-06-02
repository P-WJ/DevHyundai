package 인터페이스2;

public class CocoaTok {
    private String to;
    private String msg;
    private NetworkAdapter adapter;

    public CocoaTok(String to, NetworkAdapter adapter) {
        this.to = to;
        this.adapter = adapter;
    }

    public void writeMsg(String msg) {
        this.msg = msg;
    }

    public void send() {
        adapter.connect();
        adapter.send(to + " : " + msg);
    }
}
