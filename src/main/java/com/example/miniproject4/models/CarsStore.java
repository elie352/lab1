package com.example.miniproject4.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    /**
     * Returns the observable list of cars.
     * Changes to this list will automatically update bound UI components.
     */
    public ObservableList<Car> getCarsList() {
        return cars;
    }

    /**
     * Adds a new car to the store.
     * @param car The car to add
     * @return true if the car was added successfully, false otherwise
     */
    public boolean addCar(Car car) {
        if (car == null) {
            return false;
        }
        return cars.add(car);
    }

    /**
     * Removes a car from the store.
     * @param car The car to remove
     * @return true if the car was removed successfully, false otherwise
     */
    public boolean deleteCar(Car car) {
        if (car == null) {
            return false;
        }
        return cars.remove(car);
    }

    /**
     * Updates an existing car with new values.
     * @param car The car to update
     * @param brand New brand
     * @param model New model
     * @param price New price
     * @param mileage New mileage
     * @param engineSize New engine size
     * @param color New color
     * @param year New year
     * @return true if the car was updated successfully, false otherwise
     */
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

    /**
     * Finds a car by brand and model.
     * @param brand The brand to search for
     * @param model The model to search for
     * @return Optional containing the car if found, empty otherwise
     */
    public Optional<Car> findCar(String brand, String model) {
        return cars.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand) &&
                        car.getModel().equalsIgnoreCase(model))
                .findFirst();
    }

    /**
     * Filters cars by brand.
     * @param brand The brand to filter by
     * @return List of cars matching the brand
     */
    public List<Car> filterByBrand(String brand) {
        return cars.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    /**
     * Filters cars by price range.
     * @param minPrice Minimum price (inclusive)
     * @param maxPrice Maximum price (inclusive)
     * @return List of cars within the price range
     */
    public List<Car> filterByPriceRange(double minPrice, double maxPrice) {
        return cars.stream()
                .filter(car -> car.getPrice() >= minPrice && car.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    /**
     * Filters cars by year range.
     * @param minYear Minimum year (inclusive)
     * @param maxYear Maximum year (inclusive)
     * @return List of cars within the year range
     */
    public List<Car> filterByYearRange(int minYear, int maxYear) {
        return cars.stream()
                .filter(car -> car.getYear() >= minYear && car.getYear() <= maxYear)
                .collect(Collectors.toList());
    }

    /**
     * Gets all unique brands in the store.
     * @return List of unique brands
     */
    public List<String> getAllBrands() {
        return cars.stream()
                .map(Car::getBrand)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Gets all unique colors in the store.
     * @return List of unique colors
     */
    public List<String> getAllColors() {
        return cars.stream()
                .map(Car::getColor)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Calculates the total inventory value.
     * @return Sum of all car prices
     */
    public double getTotalInventoryValue() {
        return cars.stream()
                .mapToDouble(Car::getPrice)
                .sum();
    }

    /**
     * Gets the average price of all cars.
     * @return Average price, or 0 if no cars exist
     */
    public double getAveragePrice() {
        return cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0.0);
    }

    /**
     * Counts the number of cars in the store.
     * @return Number of cars
     */
    public int getCarCount() {
        return cars.size();
    }

    /**
     * Clears all cars from the store.
     */
    public void clearAllCars() {
        cars.clear();
    }

    /**
     * Checks if a car exists in the store.
     * @param car The car to check
     * @return true if the car exists, false otherwise
     */
    public boolean contains(Car car) {
        return car != null && cars.contains(car);
    }

    /**
     * Sorts cars by price in ascending order.
     */
    public void sortByPriceAscending() {
        FXCollections.sort(cars, (c1, c2) -> Double.compare(c1.getPrice(), c2.getPrice()));
    }

    /**
     * Sorts cars by price in descending order.
     */
    public void sortByPriceDescending() {
        FXCollections.sort(cars, (c1, c2) -> Double.compare(c2.getPrice(), c1.getPrice()));
    }

    /**
     * Sorts cars by year in descending order (newest first).
     */
    public void sortByYearDescending() {
        FXCollections.sort(cars, (c1, c2) -> Integer.compare(c2.getYear(), c1.getYear()));
    }

    /**
     * Sorts cars by brand alphabetically.
     */
    public void sortByBrand() {
        FXCollections.sort(cars, (c1, c2) -> c1.getBrand().compareToIgnoreCase(c2.getBrand()));
    }
}