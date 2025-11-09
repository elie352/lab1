package com.example.demo.models;

import javafx.beans.property.*;

public class Phone {
    private final StringProperty model;
    private final IntegerProperty storage;
    private final DoubleProperty price;

    public Phone(String model, Integer storage, Double price) {
        this.model = new SimpleStringProperty(model);
        this.storage = new SimpleIntegerProperty(storage);
        this.price = new SimpleDoubleProperty(price);
    }

    // Model
    public String getModel() { return model.get(); }
    public void setModel(String value) { model.set(value); }
    public StringProperty modelProperty() { return model; }

    // Storage
    public int getStorage() { return storage.get(); }
    public void setStorage(int value) { storage.set(value); }
    public IntegerProperty storageProperty() { return storage; }

    // Price
    public double getPrice() { return price.get(); }
    public void setPrice(double value) { price.set(value); }
    public DoubleProperty priceProperty() { return price; }
}