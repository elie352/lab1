package com.example.miniproject4.models;

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

    // Utility methods
    @Override
    public String toString() {
        return String.format("%d %s %s - $%.2f",
                getYear(), getBrand(), getModel(), getPrice());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Car car = (Car) obj;
        return getBrand().equals(car.getBrand()) &&
                getModel().equals(car.getModel()) &&
                getYear() == car.getYear() &&
                Double.compare(car.getPrice(), getPrice()) == 0 &&
                getMileage() == car.getMileage() &&
                Double.compare(car.getEngineSize(), getEngineSize()) == 0 &&
                getColor().equals(car.getColor());
    }

    @Override
    public int hashCode() {
        int result = getBrand().hashCode();
        result = 31 * result + getModel().hashCode();
        result = 31 * result + Double.hashCode(getPrice());
        result = 31 * result + getMileage();
        result = 31 * result + Double.hashCode(getEngineSize());
        result = 31 * result + getColor().hashCode();
        result = 31 * result + getYear();
        return result;
    }

    // Validation helper
    public boolean isValid() {
        return brand.get() != null && !brand.get().trim().isEmpty() &&
                model.get() != null && !model.get().trim().isEmpty() &&
                color.get() != null && !color.get().trim().isEmpty() &&
                price.get() >= 0 &&
                mileage.get() >= 0 &&
                engineSize.get() > 0 &&
                year.get() >= 1886 && year.get() <= 2025;
    }

    // Copy constructor
    public Car(Car other) {
        this(other.getBrand(), other.getModel(), other.getPrice(),
                other.getMileage(), other.getEngineSize(),
                other.getColor(), other.getYear());
    }

    // Builder pattern (optional, for more complex construction)
    public static class Builder {
        private String brand;
        private String model;
        private Double price = 0.0;
        private Integer mileage = 0;
        private Double engineSize = 0.0;
        private String color;
        private Integer year;

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder model(String model) {
            this.model = model;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder mileage(Integer mileage) {
            this.mileage = mileage;
            return this;
        }

        public Builder engineSize(Double engineSize) {
            this.engineSize = engineSize;
            return this;
        }

        public Builder color(String color) {
            this.color = color;
            return this;
        }

        public Builder year(Integer year) {
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(brand, model, price, mileage, engineSize, color, year);
        }
    }
}