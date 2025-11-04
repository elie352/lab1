package com.example.demo.models;

import javafx.beans.property.*;

public class Person {
    private final SimpleStringProperty Name;
    private final SimpleIntegerProperty Age;
    private final SimpleStringProperty Address;
    private final SimpleStringProperty StoreDate;
    private final SimpleStringProperty TermOfUse;

    public Person(String name, Integer age, String address, String storeDate, String termOfUse) {
        this.Name = new SimpleStringProperty(name);
        this.Age = new SimpleIntegerProperty(age);
        this.Address = new SimpleStringProperty(address);
        this.StoreDate = new SimpleStringProperty(storeDate);
        this.TermOfUse = new SimpleStringProperty(termOfUse);
    }

    // Keep old constructor for existing code
    public Person(String name, Integer age, String address) {
        this(name, age, address, "", "");
    }

    public String getName() { return Name.get(); }
    public void setName(String name) { this.Name.set(name); }
    public StringProperty nameProperty() { return this.Name; }

    public int getAge() { return Age.get(); }
    public void setAge(int age) { this.Age.set(age); }
    public IntegerProperty ageProperty() { return this.Age; }

    public String getAddress() { return Address.get(); }
    public void setAddress(String address) { this.Address.set(address); }
    public StringProperty addressProperty() { return this.Address; }

    public String getStoreDate() { return StoreDate.get(); }
    public void setStoreDate(String storeDate) { this.StoreDate.set(storeDate); }
    public StringProperty storeDateProperty() { return this.StoreDate; }

    public String getTermOfUse() { return TermOfUse.get(); }
    public void setTermOfUse(String termOfUse) { this.TermOfUse.set(termOfUse); }
    public StringProperty termOfUseProperty() { return this.TermOfUse; }
}
