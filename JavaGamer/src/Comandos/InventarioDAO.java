package Comandos;

import Model.Invetario;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventarioDAO {

    public static Invetario findInvetarioById(Integer id) throws SQLException {

        Connection connection = Mysql.getConnection();
        String sql = "SELECT * FROM inventario i WHERE id_save = ?;";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Invetario invetario = new Invetario();

         if (rs.next()) {

             invetario.setId_save(rs.getInt("id_save"));
             invetario.setId_cena_atual(rs.getInt("id_progresso"));

         }

         return invetario;

    }
}