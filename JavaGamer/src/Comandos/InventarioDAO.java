package Comandos;

import Model.Invetario;
import Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {

public static Invetario findInventarioById(Integer id) {
    return  new Invetario();
}


 public static List<Invetario> findInventarioScaner(Invetario invetario) throws SQLException {

     Connection connection = Mysql.getConnection();

     String sql = "select * from inventario i where id_inventario =?;";

     PreparedStatement ps = connection.prepareStatement(sql);
     ps.setInt(1, invetario.getIdInventario());
     ResultSet resultSet = ps.executeQuery();

     List<Invetario> invetarios = new ArrayList<>();


     while (resultSet.next()) {

       Invetario invetario1 = new Invetario();

         invetario1.setIdInventario(resultSet.getInt("id_inventario"));
         invetario1.setItens(ItemDAO.findItensByScene(invetario1));


     }

     return invetarios;

    }

 }

