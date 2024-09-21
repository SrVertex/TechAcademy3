package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/aula-5",
                    "root",
                    ""
            );
            return connection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao tentar connectar com o banco.");
        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao tentar importar o driver mysql");
        }
        return null;
    }
}
