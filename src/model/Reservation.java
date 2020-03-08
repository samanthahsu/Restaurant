package model;

public class Reservation {

    private Table table;
    private Customer customer;

    public Reservation(Table table, Customer customer) {
        this.table = table;
        this.customer = customer;
    }

    public Table getTable() {
        return table;
    }

    public Customer getCustomer() {
        return customer;
    }
}
