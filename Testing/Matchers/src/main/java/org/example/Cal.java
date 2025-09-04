package org.example;

public class Cal {
    public int getSum(int a, int b) {
        return a + b;
    }

    public String reverseName(String str) {
        if(str.isEmpty()) throw new IllegalArgumentException();
        return new StringBuilder(str).reverse().toString();
    }
}
