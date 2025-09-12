public class Run {
    public static void main(String[] args) {
        System.out.println("It is a run configurations sample");
        for (String arg: args) {
            System.out.println("Passed argument: " + arg);
        }
    }
}
