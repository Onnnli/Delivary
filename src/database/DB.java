package database;

import org.jetbrains.annotations.Nullable;

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
            statement.executeUpdate(query);
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
    }

    public static void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Qwerty123!")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static @Nullable
    Integer getId(String query) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Qwerty123!")) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.first();

            return resultSet.getInt("id");

        } catch (Exception ex) {
            System.out.println("error");
            System.out.println(ex.getMessage());

            return null;
        }
    }

    public static @Nullable
    Float getPrice(String query) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Qwerty123!")) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.first();

            return resultSet.getFloat("price");

        } catch (Exception ex) {
            System.out.println("error");
            System.out.println(ex.getMessage());

            return null;
        }
    }
    public static String getLastOrder(String query) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Qwerty123!")) {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.first();
            String nameOrder = resultSet.getString("name");
            String deliveredDate = resultSet.getString("deliveredDate");
            String result = "" + nameOrder  +" " + deliveredDate + "";
            System.out.println(result);
            return result;
        } catch (Exception ex) {

            System.out.println(ex.getMessage());
            return null;
        }
    }
}
