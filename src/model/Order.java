package model;

public class Order {
    public String name;
    public Float cost;
    public Integer clientId;
    public Integer courierId;
    public Integer productId;
    public String address;
    public String createdDate;
    public String delivered;

    public Order(String name,
                 Integer courierId,
                 Integer clientId,
                 Integer productId,
                 Float cost,
                 String address,
                 String createdDate,
                 String delivered) {

        this.name = name;
        this.courierId = courierId;
        this.clientId = clientId;
        this.productId = productId;
        this.cost = cost;
        this.address = address;
        this.createdDate = createdDate;
        this.delivered = delivered;

    }

}
