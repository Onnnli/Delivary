package services;

import database.DB;

public class ProductService {
    private final InputReader inputReader;

    public ProductService(InputReader inputReader) {

        this.inputReader = inputReader;
    }

    public String getName() {
        System.out.println("Введите имя курьера");

        return inputReader.getString();
    }

    public String getPrice() {
        System.out.println("Введите цену");

        return inputReader.getString();
    }

    public void getAllProducts() {
        DB.executeQuery("SELECT  * FROM Products");
    }

    public Integer addProduct(String productId) {
        String query = "SELECT * FROM Products WHERE id='" + productId + "';";
        return DB.getId(query);
    }

}
