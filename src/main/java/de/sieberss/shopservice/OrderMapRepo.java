package de.sieberss.shopservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo  implements OrderRepoInterface{

    private final Map<Integer, Order> orders  = new HashMap<>();
    @Override
    public void addOrder(Order order) {
        orders.put(order.orderId(), order);
    }

    @Override
    public void deliverOrder(Order order) {
        if (!orders.containsKey(order.orderId())) {
            System.out.println("Order " + order.orderId() + " not found");
        }
        else {
            orders.put(order.orderId(), order.withFulfilled(true));
        }
    }

    @Override
    public void setNewQuantity(Order order, int quantity) {
        if (!orders.containsKey(order.orderId())) {
            System.out.println("Order " + order.orderId() + " not found");
        }
        else {
            orders.put(order.orderId(), order.withQuantity(quantity));
        }
    }

    @Override
    public Order getOrderById(int id) {
        return orders.get(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public void removeOrder(Order order) {
        if (!orders.containsKey(order.orderId())) {
            System.out.println("Order " + order.orderId() + " not found");
        }
        else {
            orders.remove(order.orderId());
        }
    }

    @Override
    public String toString() {
        return "Orders: " + orders;
    }
}
