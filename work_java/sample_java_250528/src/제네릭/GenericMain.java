package 제네릭;

public class GenericMain {
    public static void main(String[] args) {
        GenericPrinter<Powder> powderPrinter = new GenericPrinter<>();
        powderPrinter.setMaterial(new Powder());
        System.out.println(powderPrinter);
        powderPrinter.getMaterial().doPrinting();

        GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<>();
        plasticPrinter.setMaterial(new Plastic());
        System.out.println(plasticPrinter);
        plasticPrinter.getMaterial().doPrinting();

        GenericPrinter<Water> waterPrinter = new GenericPrinter<>();
        waterPrinter.setMaterial(new Water());
        System.out.println(waterPrinter);
        waterPrinter.getMaterial().doPrinting();
    }
}