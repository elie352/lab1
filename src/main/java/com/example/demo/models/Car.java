package com.example.demo.models;

import javafx.beans.property.*;

public class Car {
    private final StringProperty brand;
    private final StringProperty model;
    private final DoubleProperty price;
    private final IntegerProperty mileage;
    private final DoubleProperty engineSize;
    private final StringProperty color;
    private final IntegerProperty year;

    // Constructor
    public Car(String brand, String model, Double price, Integer mileage,
               Double engineSize, String color, Integer year) {
        this.brand = new SimpleStringProperty(brand);
        this.model = new SimpleStringProperty(model);
        this.price = new SimpleDoubleProperty(price);
        this.mileage = new SimpleIntegerProperty(mileage);
        this.engineSize = new SimpleDoubleProperty(engineSize);
        this.color = new SimpleStringProperty(color);
        this.year = new SimpleIntegerProperty(year);
    }

    // Brand property
    public String getBrand() {
        return brand.get();
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public StringProperty brandProperty() {
        return brand;
    }

    // Model property
    public String getModel() {
        return model.get();
    }

    public void setModel(String model) {
        this.model.set(model);
    }

    public StringProperty modelProperty() {
        return model;
    }

    // Price property
    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    // Mileage property
    public int getMileage() {
        return mileage.get();
    }

    public void setMileage(int mileage) {
        this.mileage.set(mileage);
    }

    public IntegerProperty mileageProperty() {
        return mileage;
    }

    // Engine size property
    public double getEngineSize() {
        return engineSize.get();
    }

    public void setEngineSize(double engineSize) {
        this.engineSize.set(engineSize);
    }

    public DoubleProperty engineSizeProperty() {
        return engineSize;
    }

    // Color property
    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public StringProperty colorProperty() {
        return color;
    }

    // Year property
    public int getYear() {
        return year.get();
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%d %s %s - $%.2f",
                getYear(), getBrand(), getModel(), getPrice());
    }
}