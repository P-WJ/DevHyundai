package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    public int getItemCount() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public String[] getItemsAsArray() {
        return items.toArray(new String[items.size()]);
    }
}
