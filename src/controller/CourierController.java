package controller;

import database.DB;
import model.Courier;
import services.InputReader;

public class CourierController {
    private final InputReader inputReader;

    public CourierController(InputReader inputReader) {

        this.inputReader = inputReader;
    }

    public Courier createCourier() {
        String name = getName();
        String query = String.format("INSERT Couriers(name) VALUES ('%s');", name);
        try {
            DB.executeUpdate(query);
            System.out.println("Success");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return new Courier(name);
    }


    public String getName() {
        System.out.println("Введите имя курьера");

        return inputReader.getString();
    }

    public int getId() {
        String name = getName();
        String query = "SELECT * FROM Couriers WHERE name='" + name + "';";

       return DB.getId(query);
    }
}
