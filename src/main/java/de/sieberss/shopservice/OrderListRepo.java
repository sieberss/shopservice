package de.sieberss.shopservice;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepoInterface{

    private final List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void deliverOrder(Order order) {
        int index = orders.indexOf(order);
        if (index != -1) {
            orders.set(index, orders.get(index)).withFulfilled(true);
        }
        else{
            System.out.println("Bestellung existiert nicht: " + order);
        }
    }

    @Override
    public void setNewQuantity(Order order, int quantity) {
        if (!orders.contains(order)){
            System.out.println("Bestellung existiert nicht: " + order);
        }
        else {
            orders.set(orders.indexOf(order), order.withQuantity(quantity));
        }
    }

    @Override
    public Order getOrderById(int id) {
        for (Order order : orders) {
            if (order.orderId() == id) {
                return order;
            }
        };
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }

    @Override
    public void removeOrder(Order order) {
        if (!orders.contains(order)) {
            orders.remove(order);
        }
        else{
            System.out.println("Bestellung existiert nicht: " + order);
        }
    }

    @Override
    public String toString() {
        return "Orders: " + orders;
    }
}
