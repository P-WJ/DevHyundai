package 다형성;

public class Driver {
    String name;

    public Driver(String name) {
        this.name = name;
    }

    void drive(Vehicle v) {
        System.out.println(name + "의");
        v.run();
    }
}
