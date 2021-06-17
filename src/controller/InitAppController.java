package controller;

import model.Client;
import model.Courier;
import model.Order;
import services.InputReader;

import java.sql.SQLException;

public class InitAppController {
    private static InputReader inputReader;

    public InitAppController(InputReader inputReader) {

        this.inputReader = inputReader;
    }

    public void createTask() throws SQLException {
        String task = getNumberTask();
        InitAppController.someTask(task);
    }

    private static void someTask(String task) throws SQLException {
        switch (task) {
            case "1" -> {
                ClientController clientController = new ClientController(inputReader);
                Client client = clientController.createClient();
                System.out.println(client.name);
            }
            case "2" -> {
                CourierController courierController = new CourierController(inputReader);
                Courier courier = courierController.createCourier();
                System.out.println(courier.name);
            }
            case "3" -> {
                OrderController orderController = new OrderController(inputReader);
                Order order = orderController.createOrder();
                System.out.println(order.name);
            }
            default -> System.out.println("Выход");
        }
    }

    private String getNumberTask() {
        System.out.println("1: Добавить клиента");
        System.out.println("2: Создать курьера");
        System.out.println("3: Создать заказ");

        return inputReader.getString();
    }

}
