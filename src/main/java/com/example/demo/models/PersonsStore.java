package com.example.demo.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PersonsStore {
    private final ObservableList<Person> persons = FXCollections.observableArrayList();

    public PersonsStore() {
        this.persons.addAll(
                new Person("CPU", 100, "50", "2025-6-10", "new"),
                new Person("RAM", 50, "25", "2015-8-12", "used"),
                new Person("SSD", 40, "40", "2026-10-9", "new")
        );
    }

    public ObservableList<Person> getPersonsList() {
        return persons;
    }

    public void addPerson(Person person){
        if(person != null)
            this.persons.add(person);
    }

    public void deletePerson(Person person){
        if(person != null)
            this.persons.remove(person);
    }

    public void updatePerson(Person person, String name, Integer age, String address, String storeDate, String termOfUse)
    {
        if(person != null){
            person.setName(name);
            person.setAge(age);
            person.setAddress(address);
            person.setStoreDate(storeDate);
            person.setTermOfUse(termOfUse);
        }
    }
}
