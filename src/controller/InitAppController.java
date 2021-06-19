package controller;

import database.DB;
import model.Client;
import model.Courier;
import model.Order;
import services.InputReader;

public class InitAppController {
    private static InputReader inputReader;

    public InitAppController(InputReader inputReader) {

        InitAppController.inputReader = inputReader;
    }

    public static void createTask() {
        String task = getNumberTask();
        InitAppController.someTask(task);
    }

    private static void someTask(String task) {

        switch (task) {
            case "1" -> {
                ClientController clientController = new ClientController(inputReader);
                Client client = clientController.createClient();
                System.out.println(client.name);

                InitAppController.createTask();
            }
            case "2" -> {
                CourierController courierController = new CourierController(inputReader);
                Courier courier = courierController.createCourier();
                System.out.println(courier.name);

                InitAppController.createTask();
            }
            case "3" -> {
                OrderController orderController = new OrderController(inputReader);
                Order order = orderController.createOrder();
                System.out.println(order.name);

                InitAppController.createTask();
            }
            case "4" -> {
                DB.executeQuery("SELECT * FROM Clients");

                InitAppController.createTask();
            }
            case "5" -> {
                DB.executeQuery("SELECT * FROM Couriers");

                InitAppController.createTask();
            }
            case "6" -> {
                DB.executeQuery("SELECT * FROM Orders");

                InitAppController.createTask();
            }
            case "7" -> {
                ProductController productController = new ProductController(inputReader);
                productController.createProduct();

                InitAppController.createTask();
            }
            default -> System.out.println("Выход");
        }
    }

    private static String getNumberTask() {
        System.out.println("1: Добавить клиента");
        System.out.println("2: Создать курьера");
        System.out.println("3: Создать заказ");
        System.out.println("4: Вывести имена всех клиентов");
        System.out.println("5: Вывести имена всех курьеров");
        System.out.println("6: Вывести имена всех заказов");
        System.out.println("7: Создать продукт продукт");

        return inputReader.getString();
    }

}
