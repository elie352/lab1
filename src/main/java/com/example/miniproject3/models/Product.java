package com.example.miniproject3.models;

import javafx.beans.property.*;

public class Product {

    private final StringProperty name;          // e.g. "Apple"
    private final StringProperty category;      // e.g. "Fruit" or "Vegetable"
    private final IntegerProperty quantity;     // e.g. 50
    private final DoubleProperty pricePerKg;    // e.g. 3.5
    private final StringProperty origin;        // e.g. "Lebanon"
    private final StringProperty supplier;      // e.g. "Fresh Farms"
    private final BooleanProperty organic;      // e.g. true / false

    public Product(String name, String category, int quantity, double pricePerKg,
                   String origin, String supplier, boolean organic) {
        this.name = new SimpleStringProperty(name);
        this.category = new SimpleStringProperty(category);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.pricePerKg = new SimpleDoubleProperty(pricePerKg);
        this.origin = new SimpleStringProperty(origin);
        this.supplier = new SimpleStringProperty(supplier);
        this.organic = new SimpleBooleanProperty(organic);
    }

    // --- name ---
    public String getName() { return name.get(); }
    public void setName(String name) { this.name.set(name); }
    public StringProperty nameProperty() { return name; }

    // --- category ---
    public String getCategory() { return category.get(); }
    public void setCategory(String category) { this.category.set(category); }
    public StringProperty categoryProperty() { return category; }

    // --- quantity ---
    public int getQuantity() { return quantity.get(); }
    public void setQuantity(int quantity) { this.quantity.set(quantity); }
    public IntegerProperty quantityProperty() { return quantity; }

    // --- pricePerKg ---
    public double getPricePerKg() { return pricePerKg.get(); }
    public void setPricePerKg(double pricePerKg) { this.pricePerKg.set(pricePerKg); }
    public DoubleProperty pricePerKgProperty() { return pricePerKg; }

    // --- origin ---
    public String getOrigin() { return origin.get(); }
    public void setOrigin(String origin) { this.origin.set(origin); }
    public StringProperty originProperty() { return origin; }

    // --- supplier ---
    public String getSupplier() { return supplier.get(); }
    public void setSupplier(String supplier) { this.supplier.set(supplier); }
    public StringProperty supplierProperty() { return supplier; }

    // --- organic ---
    public boolean isOrganic() { return organic.get(); }
    public void setOrganic(boolean organic) { this.organic.set(organic); }
    public BooleanProperty organicProperty() { return organic; }
}
