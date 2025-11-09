package com.example.demo.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CarsStore {
    private final ObservableList<Car> cars = FXCollections.observableArrayList();

    public CarsStore() {
        initializeSampleData();
    }

    private void initializeSampleData() {
        cars.addAll(
                new Car("Toyota", "Corolla", 20000.0, 15000, 1.8, "White", 2021),
                new Car("Ford", "Mustang", 55000.0, 5000, 5.0, "Red", 2023),
                new Car("Tesla", "Model 3", 45000.0, 12000, 0.0, "Black", 2022),
                new Car("BMW", "X5", 60000.0, 8000, 3.0, "Blue", 2023)
        );
    }

    public ObservableList<Car> getCarsList() {
        return cars;
    }

    public boolean addCar(Car car) {
        if (car == null) {
            return false;
        }
        return cars.add(car);
    }

    public boolean deleteCar(Car car) {
        if (car == null) {
            return false;
        }
        return cars.remove(car);
    }

    public boolean updateCar(Car car, String brand, String model, Double price,
                             Integer mileage, Double engineSize, String color, Integer year) {
        if (car == null || !cars.contains(car)) {
            return false;
        }

        car.setBrand(brand);
        car.setModel(model);
        car.setPrice(price);
        car.setMileage(mileage);
        car.setEngineSize(engineSize);
        car.setColor(color);
        car.setYear(year);

        return true;
    }
}