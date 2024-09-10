package Comandos;

import Model.Invetario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class InventarioDAO {

public static Invetario findInventarioById(Integer id) {
    return  new Invetario();
}
 public static List<Invetario> findInventarioScaner(Invetario invetario) {

     Connection connection = Mysql.getConnection();

     String sql = "select * from inventario i where id_inventario =?;";

     PreparedStatement ps = connection.prepareStatement(sql);
     ps.setInt(1, invetario.getIdInventario());
     ResultSet resultSet = ps.executeQuery();

 }
}
