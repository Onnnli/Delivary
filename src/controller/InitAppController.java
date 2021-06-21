package controller;

import database.DB;
import model.Client;
import model.Courier;
import model.Order;
import services.*;

public class InitAppController {
    private static InputReader inputReader;

    public InitAppController(InputReader inputReader) {

        InitAppController.inputReader = inputReader;
    }

    public static void createTask(){
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
            case "8" -> {
                DB.executeQuery("SELECT * FROM Orders WHERE isnull(deliveredDate)");

                InitAppController.createTask();
            }
            case "9" -> {
                DB.executeQuery("SELECT * FROM Orders WHERE deliveredDate");

                InitAppController.createTask();
            }
            case "10" -> {
                CourierService courierService = new CourierService(inputReader);
                courierService.getCouriersNotDelivered();

                InitAppController.createTask();
            }
            case "11" -> {
                ClientService clientService = new ClientService(inputReader);
                clientService.getClientsNotDelivered();

                InitAppController.createTask();
            }
            case "12" -> {
                CourierService courierService = new CourierService(inputReader);
                courierService.getCouriersDelivered();

                InitAppController.createTask();
            }
            case "13" -> {
                ClientService clientService = new ClientService(inputReader);
                clientService.getClientsDelivered();

                InitAppController.createTask();
            }
            case "14" -> {
                OrderService orderService = new OrderService(inputReader);
                orderService.getClientsOrderCertainTime();

                InitAppController.createTask();
            }
            case "15" -> {
                OrderService orderService = new OrderService(inputReader);
                orderService.getClientsOrderNotDeliveredCertainTime();

                InitAppController.createTask();
            }
            case "16" -> {
                OrderService orderService = new OrderService(inputReader);
                orderService.getCouriersOrderCertainTime();

                InitAppController.createTask();
            }
            case "17" -> {
                OrderService orderService = new OrderService(inputReader);
                orderService.getCourierOrderNotDeliveredCertainTime();

                InitAppController.createTask();
            }
            case "18" -> {
                OrderService orderService = new OrderService(inputReader);
                orderService.getExpensiveOrder();

                InitAppController.createTask();
            }
            case "19" -> {
                OrderService orderService = new OrderService(inputReader);
                orderService.getCheapOrder();

                InitAppController.createTask();
            }
            case "20" -> {
                OrderService orderService = new OrderService(inputReader);
                orderService.getLastOrder();

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
        System.out.println("7: Создать новый продукт");
        System.out.println("8: Вывести имена всех не доставленных заказов");
        System.out.println("9: Вывести имена всех доставленных заказов");
        System.out.println("10: Вывести имена всех не доставленных заказов определенного курьера");
        System.out.println("11: Вывести имена всех не доставленных заказов определенного клиента");
        System.out.println("12: Вывести имена всех доставленных заказов определенного курьера");
        System.out.println("13: Вывести имена всех доставленных заказов определенного клиента");
        System.out.println("14: Вывести имена всех доставленных заказов определенного клиента за определенную дату");
        System.out.println("15: Вывести имена всех не доставленных заказов определенного клиента за определенную дату");
        System.out.println("16: Вывести имена всех доставленных заказов определенного курьера за определенную дату");
        System.out.println("17: Вывести имена всех не доставленных заказов определенного курьера за определенную дату");
        System.out.println("18: Вывести имя самого дорогого заказа");
        System.out.println("19: Вывести имя самого дешевого заказа");
        System.out.println("20: Вывести последний доставленный заказ");

        return inputReader.getString();
    }
}
