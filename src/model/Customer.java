package model;

public class Customer {
    private String name;
    private String phoneNumber;

    //EFFECTS: constructs a new customer with given name and phoneNumber
    public Customer(String name, String phone) {
        this.name = name;
        this.phoneNumber = phone;
    }

    //EFFECTS: changes name
    public void setName(String newName) {
        this.name = newName;
    }

    //EFFECTS: changes name
    public void setPhone(String newPhone) {
        this.phoneNumber = newPhone;
    }

    //EFFECTS: returns name
    public String getName() {return name;}

    //EFFECTS: returns name
    public String getPhone() {return phoneNumber;}

}
