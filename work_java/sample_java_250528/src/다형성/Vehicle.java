package 다형성;

public class Vehicle {
    public void run() {
        System.out.println("차량이 달립니다.");
    }
}

class SportsCar extends Vehicle {
    @Override
    public void run() {
        System.out.println("파나메라가 달립니다.");
    }
}

class Sedan extends Vehicle {
    @Override
    public void run() {
        System.out.println("그랜저가 달립니다.");
    }
}

class Suv extends Vehicle {
    @Override
    public void run() {
        System.out.println("GV80이 달립니다.");
    }
}