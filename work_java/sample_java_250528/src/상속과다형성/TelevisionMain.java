package 상속과다형성;

public class TelevisionMain {
    public static void main(String[] args) {
        ProductTV productTV1 = new ProductTV(false, 11, 20, false);
        productTV1.setName("곰돌이 TV");
        productTV1.setVolume(20);
        productTV1.setChannel(20, true);
        productTV1.viewTV();
    }
}
