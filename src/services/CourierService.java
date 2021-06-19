package services;

import database.DB;

public class CourierService {
    private final InputReader inputReader;

    public CourierService(InputReader inputReader) {

        this.inputReader = inputReader;
    }
    public String getName() {
        System.out.println("Введите имя курьера");

        return inputReader.getString();
    }

    public Integer getId() {
        String name = getName();
        String query = "SELECT * FROM Couriers WHERE name='" + name + "';";

        return DB.getId(query);
    }

    public void getAllCouriers() {
        System.out.println("Выберите курьера");
        DB.executeQuery("SELECT  * FROM Couriers");
    }
}
