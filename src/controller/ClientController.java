package controller;

import database.DB;
import model.Client;
import services.ClientService;
import services.InputReader;

public class ClientController {
    private final InputReader inputReader;

    public ClientController(InputReader inputReader) {

        this.inputReader = inputReader;
    }

    public Client createClient() {
        ClientService clientService = new ClientService(inputReader);

        String name = clientService.getName();

        String query = String.format("INSERT Clients(name) VALUES ('%s');", name);

        try {
            DB.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return new Client(name);
    }
}
