package de.sieberss.shopservice;

import java.math.BigDecimal;
import java.util.Objects;

public record Product(int id, String name, String description, BigDecimal price, String manufacturer, int quantity) {

    public Product(int id, String name, String description, double price, String manufacturer, int quantity) {
        this(id, name, description, BigDecimal.valueOf(price), manufacturer, quantity);
    }

   public Product withQuantity(int quantity){
        return new Product(id, name, description, price, manufacturer, quantity);
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return id == product.id && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", " + name +
                ", " + description  +
                ", " + price +
                ", manufacturer:' " + manufacturer +
                ", on Stock: " + quantity +
                '}';
    }
}
