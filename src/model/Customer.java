package model;

public class Customer {
    String name;
    String phoneNumber;

    //EFFECTS: constructs a new customer with given name and phoneNumber
    public Customer(String name, String phone) {
        this.name = name;
        this.phoneNumber = phone;
    }

}
