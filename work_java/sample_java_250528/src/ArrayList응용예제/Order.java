package ArrayList응용예제;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Order {
    ArrayList<Product> products;
    BigDecimal total;

    public Order() {
        this.products = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }

    public void addItem(Product p) {
        products.add(p);
        total = total.add(p.getPrice());
    }

    public Product getItem(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public boolean removeItem(String name) {
        for (Product product : products) {
            if(product.getName().equals(name)) {
                products.remove(product);
                total = total.subtract(product.getPrice());
                return true;
            }
        }
        return false;
    }

    public BigDecimal calculateFinalPrice(BigDecimal taxRate) {
        BigDecimal taxAmount = total.multiply(taxRate);
        BigDecimal finalPrice = total.add(taxAmount);
        return finalPrice.setScale(2, RoundingMode.HALF_UP);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
