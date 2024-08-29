package de.sieberss.shopservice;

import java.math.BigDecimal;
import java.util.List;

public interface OrderRepoInterface {

    void addOrder(Order order);
    void deliverOrder(Order order);
    void setNewQuantity(Order order, int quantity);
    Order getOrderById(int id);
    List<Order> getAllOrders();
    void removeOrder(Order order);
}
