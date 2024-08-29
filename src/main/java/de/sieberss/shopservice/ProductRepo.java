package de.sieberss.shopservice;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {

    final private List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.id() == id) return product;
        }
        return null;
    }
    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.name().equals(name)) return product;
        }
        return null;
    }

    public void addProduct(Product product) {
        int indexOfProduct = products.indexOf(product);
        if (indexOfProduct == -1) {
            products.add(product);
        }
        else {
            int oldQuantity = products.get(indexOfProduct).quantity();
            product= product.withQuantity(oldQuantity + product.quantity());
            products.set(indexOfProduct, product);
        }
    }

    @Override
    public String toString() {
        return "ProductRepo{" + products + '}';
    }
}
