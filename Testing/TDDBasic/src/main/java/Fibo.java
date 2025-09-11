public class Fibo {
    public int fibo(int i) {
        if (i < 2) return i;
        return fibo(i - 2)  + fibo(i - 1);
    }

    public int fiboWithFor(int order) {
        int previous = 0;
        int next = 1;
        int current = 0;

        if (order == 0) {
            return previous;
        } else if (order == 1) {
            return next;
        }

        for (int i = 2; i <= order; i++) {
            current = previous + next;
            previous = next;
            next = current;
        }

        return current;
    }
}
