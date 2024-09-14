package Comandos;

import Model.Cenas;
import Model.Invetario;
import Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
             invetario.setId_item(ItemDAO.findItensByScene(invetario));

         }
         return invetario;
    }

}


