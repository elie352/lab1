package com.example.miniproject3.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductsStore {

    private final ObservableList<Product> products = FXCollections.observableArrayList();

    public ProductsStore() {
        // Sample starting products
        this.products.addAll(
                new Product("Apple", "Fruit", 120, 2.5, "Lebanon", "Fresh Farms", true),
                new Product("Potato", "Vegetable", 200, 1.2, "Syria", "Green Valley", false),
                new Product("Banana", "Fruit", 150, 1.8, "Ecuador", "Tropical Trade", true)
        );
    }

    public ObservableList<Product> getProductsList() {
        return products;
    }

    public void addProduct(Product product) {
        if (product != null)
            this.products.add(product);
    }

    public void deleteProduct(Product product) {
        if (product != null)
            this.products.remove(product);
    }

    public void updateProduct(Product product, String name, String category, int quantity,
                              double pricePerKg, String origin, String supplier, boolean organic) {
        if (product != null) {
            product.setName(name);
            product.setCategory(category);
            product.setQuantity(quantity);
            product.setPricePerKg(pricePerKg);
            product.setOrigin(origin);
            product.setSupplier(supplier);
            product.setOrganic(organic);
        }
    }
}
