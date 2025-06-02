package ArrayList응용예제;

import java.math.BigDecimal;

public class Product {
    String name;
    BigDecimal price;

    public Product(String name, String price) {
        this.name = name;
        this.price = new BigDecimal(price);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}