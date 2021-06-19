package services;

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
}
