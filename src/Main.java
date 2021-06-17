import controller.InitAppController;
import database.DB;
import services.InputReader;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        DB.DBConnector();

        InputReader inputReader = new InputReader();

        InitAppController initAppController = new InitAppController(inputReader);
        initAppController.createTask();

    }
}
