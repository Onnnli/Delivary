package model;

import java.sql.Date;

public class Order {
    public int id;
    public String name;
    public float cost;
    public Client client;
    public Courier courier;
    public String address;
    public String createdDate;
    public Date delivered;


    public Order(String name, String address, String createdDate) {
        this.name = name;
        this.address = address;
        this.createdDate = createdDate;
    }

}
