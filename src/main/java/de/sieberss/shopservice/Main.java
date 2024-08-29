package de.sieberss.shopservice;

public class Main {
    public static void main(String[] args) {
        Product cup = new Product(1, "Coffee cup VMJK", "classical white coffee cup", 2.5, "Villeroy", 120);
        Product spoon = new Product(2, "Spoon A257", "Just a normal spoon", 1.19, "Schiller", 470);
        Product plate = new Product(3, "Plate P345", "standard white plate", 3.27, "Villeroy", 25);
        ProductRepo repo = new ProductRepo();
        repo.addProduct(cup);
        repo.addProduct(spoon);
        repo.addProduct(plate);
        System.out.println(repo);
        repo.addProduct(cup);
        System.out.println(repo);

        ShopService service = new ShopService(new OrderListRepo());
        System.out.println(service);
        Order first = service.createOrder(cup, 735);
        service.submitOrder(first);
        System.out.println(service);

        Order second = service.createOrder(cup, 178);
        service.submitOrder(second);
        System.out.println(second);
        System.out.println(service);
        service.setNewQuantity(second, 34);  // does not work because second is not in repo
        System.out.println(service);
        service.submitOrder(second);

        Order third = service.createOrder(cup, 34);
        service.submitOrder(third);
        System.out.println(service);
        service.setNewQuantity(third, 200);
        System.out.println();
        service.setNewQuantity(third, 100);
        System.out.println();
    }
}
