package controller;

import database.DB;
import model.Order;
import services.*;

public class OrderController {
    private final InputReader inputReader;

    public OrderController(InputReader inputReader) {

        this.inputReader = inputReader;
    }

    public Order createOrder() {
        OrderService orderService = new OrderService(inputReader);

        String name = orderService.getName();

        Integer clientId = orderService.getClientId();

        String address = orderService.getAddress();

        Integer productId = addProduct();
        Float cost = getCost(productId);

        Integer courierId = orderService.getCourierId();

        String createdDate = getCreatedDate();

        String query = "INSERT Orders(name, courierId, clientId, productId, cost, address, createdDate)" +
                " VALUES ('" + name + "','" + courierId + "','" +
                clientId + "','" + productId + "','" +  cost + "','"
                + address + "','"  + createdDate +"');";

        try {
            DB.executeUpdate(query);
            System.out.println("Success");
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        String deliveredDate = getDeliveredDate();

        if(deliveredDate != null) {
            updateDeliveredDate(name);
        }

        return new Order(name, courierId, clientId, productId, cost, address, createdDate, deliveredDate);
    }

    private Integer addProduct() {
        ProductService productService = new ProductService(inputReader);

        productService.getAllProducts();

        System.out.println("Добавьте товар");

        String product = inputReader.getString();

        return productService.addProduct(product);
    }

    private Float getCost(Integer productId) {
        String query = "SELECT * FROM Products WHERE id='" + productId + "';";

        return  DB.getPrice(query);
    }

    private String getDeliveredDate() {
        OrderService orderService = new OrderService(inputReader);
        return orderService.getDeliveredDate();
    }

    private String getCreatedDate() {
        DateService dateService = new DateService();

        return dateService.getCreatedDate();
    }

    private void updateDeliveredDate(String  name) {
        DateService dateService = new DateService();
        String  deliveredDate = dateService.getCreatedDate();
        String query = "UPDATE Orders  SET deliveredDate = '" +  deliveredDate + "' WHERE name='" + name + "';";
        DB.executeUpdate(query);
    }
}
