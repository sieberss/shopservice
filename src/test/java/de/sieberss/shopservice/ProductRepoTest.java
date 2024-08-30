package de.sieberss.shopservice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ProductRepoTest {

    // private static final ProductRepo repo = new ProductRepo();

    public static final Product[] testProducts = {
            new Product(1, "Bananen 1kg", "Super tolle Bananen", 1.79, "Dole", 347),
            new Product(54, "1kg Tomaten", "deutsche Strauchtomaten", 1.99, "Food Producer", 555),
            new Product(12, "Birnen 1kg", "Birnen Conference", 1.69, "Agrarmulti", 134),
            new Product(56, "1kg Zwetschgen", "frische deutsche Zwetschgen", 1.99, "Obsthandel Hamburg", 340)
    };

    private ProductRepo createTestRepo(){
        ProductRepo repo = new ProductRepo();
        for (Product product : testProducts){
            repo.addProduct(product);
        }
        return repo;
    }

    @Test
    void getAllProducts() {
        ProductRepo repo = createTestRepo();
        List<Product> products = repo.getAllProducts();
        assertThat(products).isEqualTo(Arrays.asList(CommonTestRepos.testProducts));
    }

    @Test
    void getProductById() {
        ProductRepo repo = createTestRepo();
        assertThat(repo.getProductById(1)).isEqualTo(CommonTestRepos.testProducts[0]);
        assertThat(repo.getProductById(54)).isEqualTo(CommonTestRepos.testProducts[1]);
        assertThat(repo.getProductById(12)).isEqualTo(CommonTestRepos.testProducts[2]);
        assertThat(repo.getProductById(56)).isEqualTo(CommonTestRepos.testProducts[3]);
        assertThat(repo.getProductById(78)).isNull();
    }

    @Test
    void getProductByName() {
        ProductRepo repo = createTestRepo();
        assertThat(repo.getProductByName("Bananen 1kg")).isEqualTo(CommonTestRepos.testProducts[0]);
        assertThat(repo.getProductByName("1kg Tomaten")).isEqualTo(CommonTestRepos.testProducts[1]);
        assertThat(repo.getProductByName("Birnen Conference")).isNull();
        assertThat(repo.getProductByName("Birnen 1kg")).isEqualTo(CommonTestRepos.testProducts[2]);
        assertThat(repo.getProductByName("1kg Zwetschgen")).isEqualTo(CommonTestRepos.testProducts[3]);
    }

    @Test
    void addProduct() {
        ProductRepo repo = createTestRepo();
        Product newProduct = new Product(11, "Sack Zwiebeln", "5kg deutsche Zwiebeln", 3.55, "Bauer Schulze", 50);
        assertThat(repo.getAllProducts().contains(newProduct)).isFalse();
        repo.addProduct(newProduct);
        assertThat(repo.getAllProducts().contains(newProduct)).isTrue();
    }
}