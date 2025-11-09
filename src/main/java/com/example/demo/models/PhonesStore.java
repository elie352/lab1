package com.example.demo.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PhonesStore {
    private final ObservableList<Phone> phones = FXCollections.observableArrayList();

    public PhonesStore() {
        // Sample data
        phones.addAll(
                new Phone("iPhone 15 Pro", 256, 999.99),
                new Phone("Samsung Galaxy S24", 128, 849.99),
                new Phone("Google Pixel 8", 128, 699.99)
        );
    }

    public ObservableList<Phone> getPhonesList() {
        return phones;
    }

    public boolean addPhone(Phone phone) {
        if (phone == null) return false;
        return phones.add(phone);
    }

    public boolean deletePhone(Phone phone) {
        if (phone == null) return false;
        return phones.remove(phone);
    }

    public boolean updatePhone(Phone phone, String model, Integer storage, Double price) {
        if (phone == null || !phones.contains(phone)) return false;
        phone.setModel(model);
        phone.setStorage(storage);
        phone.setPrice(price);
        return true;
    }
}