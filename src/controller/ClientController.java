package controller;

import database.DB;
import model.Client;
import services.InputReader;

import java.sql.SQLException;

public class ClientController {
    private final InputReader inputReader;

    public ClientController(InputReader inputReader) {

        this.inputReader = inputReader;
    }

    public Client createClient() {
        String name = getName();
        String query = String.format("INSERT Clients(name) VALUES ('%s');", name);
        try {
            DB.executeUpdate(query);
            System.out.println("Success");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return new Client(name);
    }


    private String getName() {
        System.out.println("Введите имя клиента");

        return inputReader.getString();
    }

    public int getId() {
        String name = getName();
        String query = "SELECT * FROM Clients WHERE name='" + name + "';";

        return DB.getId(query);
    }

}
