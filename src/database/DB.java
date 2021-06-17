package database;

import java.sql.*;

public class DB {



    public static void DBConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Qwerty123!");
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            System.out.println("Connection successfully!");
        } catch (Exception ex) {
            System.out.println("Connection failed...");
            System.out.println(ex.getMessage());
        }
    }

    public static void executeUpdate(String query) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Qwerty123!")) {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            System.out.println(result);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static int getId(String query) {
        int id = 0; // правильно написать
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Qwerty123!")) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.first();
            id = resultSet.getInt("id");

        } catch (Exception ex) {
            System.out.println("error");
            System.out.println(ex.getMessage());
        }
        return id;
    }
}
