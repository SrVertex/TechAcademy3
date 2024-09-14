package Comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
    private static Connection connection;

    public  static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bancotechacademy3",
                    "root",
                    ""
            );


            return  connection;

        } catch (SQLException e) {

            System.out.println("Erro ao conectar com o banco.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erro ao tentar importar o driver mysql");

        }

        return null;

    }
}
