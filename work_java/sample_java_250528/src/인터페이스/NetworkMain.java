package 인터페이스;

import java.util.Scanner;

public class NetworkMain {
    public static void main(String[] args) {
        NetworkAdapter adapter;
        Scanner sc = new Scanner(System.in);
        System.out.print("연결할 네트워크를 선택 하세요[1]LAN, [2]WiFi, [3]LTE : ");
        int num = sc.nextInt();
        switch (num) {
            case 1:
                adapter = new LAN("KT Magapass");
                adapter.connect();
                break;
            case 2:
                adapter = new WiFi("SK Telecom");
                adapter.connect();
                break;
            case 3:
                adapter = new LTE("LG U+");
                adapter.connect();
                break;
            default:
                System.out.println("네트워크 선택이 잘 못 되었습니다.");
        }
    }
}


interface NetworkAdapter {
    public abstract void connect();
}

class LAN implements NetworkAdapter {
    String company;

    LAN(String company) {
        this.company = company;
    }

    @Override
    public void connect() {
        System.out.println(company + " LAN에 연결 되었습니다.");
    }
}

class WiFi implements NetworkAdapter {
    String company;

    WiFi(String company) {
        this.company = company;
    }

    @Override
    public void connect() {
        System.out.println(company + " WiFi에 연결 되었습니다.");
    }
}

class LTE implements NetworkAdapter {
    String company;

    LTE(String company) {
        this.company = company;
    }

    @Override
    public void connect() {
        System.out.println(company + " LTE에 연결 되었습니다.");
    }
}