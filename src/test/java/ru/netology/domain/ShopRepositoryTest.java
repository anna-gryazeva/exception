package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void removingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(5, "Арбуз", 300);
        Product product2 = new Product(55, "Дыня", 400);
        Product product3 = new Product(555, "Кальмар", 500);
        Product product4 = new Product(5555, "Ананас", 600);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.remove(555);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeProductWhichNotFound() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(5, "Арбуз", 300);
        Product product2 = new Product(55, "Дыня", 400);
        Product product3 = new Product(555, "Кальмар", 500);
        Product product4 = new Product(5555, "Ананас", 600);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(15);
        });

    }

}
