package Comandos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
    private static Connection connection;

    public  static Connection getConnection() {
            // CONECXAO AO BANCO DE DADOS
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gamejava",
                    "root",
                    ""
            );

                // DE A CONECXAO FUNCIONAR IRA RETORNAS A CONNECTION E OS DADOS DO BANCO DE DADOS 
            return  connection;

        } catch (SQLException e) {
                        // MESSAGEM DE ERRO AO CONECTAR AO BANCO DE DADOS
            System.out.println("Erro ao conectar com o banco.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
                    // MESSAGEM DE ERRO AO REALIZAR A INSTALAÇÃO DOS DRIVER DO MYSQL
            System.out.println("Erro ao tentar importar o driver mysql");

        }
            // SE NADA ACONTECER A MENSAGEM SE NULL
        return null;

    }
}
