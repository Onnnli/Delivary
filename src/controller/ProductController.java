package controller;

import database.DB;
import model.Product;
import services.InputReader;
import services.ProductService;

public class ProductController {
    private final InputReader inputReader;

    public ProductController(InputReader inputReader) {

        this.inputReader = inputReader;
    }

    public Product createProduct() {
        ProductService productService = new ProductService(inputReader);
        String name = productService.getName();
        float price = Float.parseFloat(productService.getPrice());

        String query = "INSERT Product(name, price) VALUES ('" + name + "', '" + price + "');";

        try {
            DB.executeUpdate(query);
            System.out.println("Success");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return new Product(name, price);
    }
}

