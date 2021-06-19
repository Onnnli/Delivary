package services;

import database.DB;

public class ClientService {
    private final InputReader inputReader;

    public ClientService(InputReader inputReader) {

        this.inputReader = inputReader;
    }


    public String getName() {
        System.out.println("Введите имя клиента");

        return inputReader.getString();
    }

    public Integer getId() {
        String name = getName();
        String query = "SELECT * FROM Clients WHERE name='" + name + "';";
        return DB.getId(query);
    }

    public void getAllClient() {
        System.out.println("Выберите клиента");
        DB.executeQuery("SELECT  * FROM Clients");
    }

}
