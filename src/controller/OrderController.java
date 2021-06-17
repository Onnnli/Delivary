package controller;

import database.DB;
import model.Order;
import services.InputReader;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderController {
    private final InputReader inputReader;

    public OrderController(InputReader inputReader) {

        this.inputReader = inputReader;
    }

    public Order createOrder() throws SQLException {
        String name = getName();
        String address = getAddress();
        int courierId = getCourier();
        int clientId = getClient();

        String createdDate = getCreatedDate();
        String query = "INSERT Orders(name, courierId, clientId, address, createdDate) VALUES ('" + name + "','"+ courierId + "','"+ clientId + "','" + address + "','" + createdDate + "');";

        try {
            DB.executeUpdate(query);
            System.out.println("Success");
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }

        return new Order(name, createdDate, address);
    }

    private String getName() {
        System.out.println("Введите имя заказа");

        return inputReader.getString();
    }

    private int getCourier() {
        CourierController courierController = new CourierController(inputReader);

        return courierController.getId();
    }


    private String getAddress() {
        System.out.println("Введите адрес доставки");

        return inputReader.getString();
    }

    private int getClient()  {
        ClientController clientController = new ClientController(inputReader);

        return clientController.getId();
    }

    private String getCreatedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));

        return formatter.format(date);
    }

}
