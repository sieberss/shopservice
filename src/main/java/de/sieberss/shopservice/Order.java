package de.sieberss.shopservice;

import java.math.BigDecimal;

public record Order(int orderId, Product product, int quantity, boolean fulfilled) {

    private static int count = 1;

    public Order(int orderId, Product product, int quantity, boolean fulfilled) {
        this.orderId = count++;
        this.product = product;
        this.quantity = quantity;
        this.fulfilled = fulfilled;
    }
    public Order(Product product, int quantity) {
        this(0, product, quantity, false);
    }

    public Order withFulfilled(boolean fulfilled) {
        return new Order(orderId, product, quantity, fulfilled);
    }
    public Order withQuantity(int quantity) {
        return new Order(orderId, product, quantity, fulfilled);
    }


    BigDecimal getOrderTotal(){
        return product.price().multiply(BigDecimal.valueOf(quantity));
    };

}
