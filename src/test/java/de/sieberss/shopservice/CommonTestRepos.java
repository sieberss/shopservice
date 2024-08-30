package de.sieberss.shopservice;

public class CommonTestRepos {

    //public static CommonTestRepos instance = new CommonTestRepos();

    public static final Product[] testProducts = {
            new Product(1, "Bananen 1kg", "Super tolle Bananen", 1.79, "Dole", 347),
            new Product(54, "1kg Tomaten", "deutsche Strauchtomaten", 1.99, "Food Producer", 555),
            new Product(12, "Birnen 1kg", "Birnen Conference", 1.69, "Agrarmulti", 134),
            new Product(56, "1kg Zwetschgen", "frische deutsche Zwetschgen", 1.99, "Obsthandel Hamburg", 340)
    };

    public static final Order[] testOrders = {
            new Order(testProducts[2], 7),
            new Order(testProducts[1], 5),
            new Order(testProducts[0], 1),
            new Order(testProducts[1], 8),
            new Order(testProducts[3], 7),
            new Order(testProducts[3], 2),
            new Order(testProducts[2], 4)
    };

    public static final ProductRepo productRepo = new ProductRepo();
    public static final OrderListRepo orderListRepo = new OrderListRepo();

    private CommonTestRepos(){
            for (Product product : testProducts){
                productRepo.addProduct(product);
            }
            for (Order order : testOrders){
                orderListRepo.addOrder(order);
            }
    }


}