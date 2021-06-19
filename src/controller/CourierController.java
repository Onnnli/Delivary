package controller;

import database.DB;
import model.Courier;
import services.CourierService;
import services.InputReader;

public class CourierController {

    private final InputReader inputReader;

    public CourierController(InputReader inputReader) {

        this.inputReader = inputReader;
    }

    public Courier createCourier() {
        CourierService courierService = new CourierService(inputReader);
        String name = courierService.getName();

        String query = String.format("INSERT Couriers(name) VALUES ('%s');", name);

        try {
            DB.executeUpdate(query);
            System.out.println("Success");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return new Courier(name);
    }
}
