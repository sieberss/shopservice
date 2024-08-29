package de.sieberss.shopservice;

public class ShopService {
    private OrderRepoInterface orderRepo;

    public ShopService(OrderRepoInterface orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order createOrder(Product product, int quantity) {
        return new Order(product, quantity);
    }

    public boolean canOrderBeFulfilled(Order order) {
        return order.product().quantity() >= order.quantity();
    }

    public void submitOrder(Order order) {
        if (canOrderBeFulfilled(order)) {
            orderRepo.addOrder(order);
        }
        else {
            notEnoughOnStock(order.product(), order.quantity());
        }
    }

    public void removeOrder(Order order) {
        orderRepo.removeOrder(order);
    }

    public void deliverOrder(Order order) {
        orderRepo.deliverOrder(order);
    }
    public void setNewQuantity(Order order, int quantity) {
        Order newOrder = order.withQuantity(quantity);
        if (canOrderBeFulfilled(newOrder)) {
            orderRepo.setNewQuantity(order, quantity);
        }
        else {
            notEnoughOnStock(order.product(), quantity);
        }
    }

    private void notEnoughOnStock(Product product, int quantity) {
        System.out.printf("Keine %d Exemplare von %s vorhanden\n", quantity, product);
    }

    @Override
    public String toString() {
        return "orderRepo{" + orderRepo +
                '}';
    }
}
