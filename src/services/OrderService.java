package services;

import database.DB;

public class OrderService {
    private final InputReader inputReader;

    public OrderService(InputReader inputReader) {

        this.inputReader = inputReader;
    }

    public String getName() {
        System.out.println("Введите имя заказа");

        return inputReader.getString();
    }

    public int getCourierId() {
        CourierService courierService = new CourierService(inputReader);
        courierService.getAllCouriers();

        return courierService.getId();
    }

    public String getDeliveredDate() {
        System.out.println("Заказ доставлен? 1 - да, 2 - нет");

        String delivered = inputReader.getString();

        if (delivered.equals("1")) {
            DateService dateService = new DateService();
            return dateService.getDeliveredDate();
        } else {
            return null;
        }
    }

    public String getAddress() {
        System.out.println("Введите адрес доставки");

        return inputReader.getString();
    }

    public int getClientId() {
        ClientService clientService = new ClientService(inputReader);
        clientService.getAllClient();

        return clientService.getId();
    }

    public void getClientsOrderCertainTime() {
        ClientService clientService = new ClientService(inputReader);
        Integer clientId = clientService.getId();
        System.out.println("Введите старт временного промежутка");
        String startDate = inputReader.getString();
        System.out.println("Введите конец временного промежутка");
        String endDate = inputReader.getString();

        DB.executeQuery("SELECT * FROM Orders WHERE clientId = '" + clientId + "' AND  deliveredDate between '" + startDate + "' and '" + endDate + "' ");

    }

    public void getClientsOrderNotDeliveredCertainTime() {
        ClientService clientService = new ClientService(inputReader);

        Integer clientId = clientService.getId();
        System.out.println("Введите старт временного промежутка");
        String startDate = inputReader.getString();
        System.out.println("Введите конец временного промежутка");
        String endDate = inputReader.getString();

        DB.executeQuery("SELECT * FROM Orders WHERE clientId = '" + clientId + "' AND  createdDate between '" + startDate + "' and '" + endDate + "' and isnull(deliveredDate)");

    }

    public void getCouriersOrderCertainTime() {
        CourierService courierService = new CourierService(inputReader);

        Integer courierId = courierService.getId();

        System.out.println("Введите старт временного промежутка");
        String startDate = inputReader.getString();
        System.out.println("Введите конец временного промежутка");
        String endDate = inputReader.getString();

        DB.executeQuery("SELECT * FROM Orders WHERE courierId = '" + courierId + "' AND  deliveredDate between '" + startDate + "' and '" + endDate + "' ");

    }

    public void getCourierOrderNotDeliveredCertainTime() {
        CourierService courierService = new CourierService(inputReader);
        Integer courierId = courierService.getId();
        System.out.println("Введите старт временного промежутка");
        String startDate = inputReader.getString();
        System.out.println("Введите конец временного промежутка");
        String endDate = inputReader.getString();
        DB.executeQuery("SELECT * FROM Orders WHERE courierId = '" + courierId + "' AND  createdDate between '" + startDate + "' and '" + endDate + "' and isnull(deliveredDate)");
    }

    public void getExpensiveOrder() {
        DB.executeQuery("SELECT * FROM Orders ORDER BY cost DESC");
    }

    public void getCheapOrder() {
        DB.executeQuery("SELECT * FROM Orders ORDER BY cost");
    }

    public void getLastOrder() {
        DB.getLastOrder("SELECT * FROM Orders ORDER BY deliveredDate DESC");
    }

}
