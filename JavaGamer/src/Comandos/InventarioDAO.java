package Comandos;

import Model.Cenas;
import Model.Invetario;
import Model.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {

    public static Integer atualizaInventario = 1;


    public static Invetario SaveGame() throws SQLException {

        Connection conn = Mysql.getConnection();
            String sql = "INSERT INTO inventario (id_cenaAtual) VALUES (1)";

        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
                 ResultSet generatedKeys = stmt.getGeneratedKeys();

        Invetario save = new Invetario();

        if (generatedKeys.next()) {

            save.setId_save(generatedKeys.getInt(1));
            save.setId_cena_atual(CenasDAO.findCenaById(1));

        }

        generatedKeys.close();
        stmt.close();
        conn.close();

        return save;
    }

    public static Invetario findInvetarioById(Integer id) throws SQLException {

        Connection connection = Mysql.getConnection();
        String sql = "SELECT * FROM inventario i WHERE id_save = ?;";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Invetario invetario = new Invetario();

        if (rs.next()) {

            invetario.setId_save(rs.getInt("id_save"));
                invetario.setId_progresso(rs.getInt("id_progresso"));
                    invetario.setID_CENA_ATUAL2(rs.getInt("id_cenaAtual"));
                        invetario.setItem(rs.getInt("id_item"));

        }

        rs.close();
        stmt.close();
        connection.close();

        return invetario;
    }

    public static List<Invetario> BuscaInventario() throws SQLException {

        Connection connection = Mysql.getConnection();
        String sql = "SELECT id_item FROM inventario";

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        List<Invetario> inventario = new ArrayList<>();

        while (rs.next()) {

            int idItem = rs.getInt("id_item");
                Invetario item = new Invetario();
                    item.setItem(idItem);
                    inventario.add(item);

        }


        rs.close();
        stmt.close();
        connection.close();

        return inventario;
    }

    public static void printInventario() throws SQLException {
        List<Invetario> inventario = BuscaInventario();

        for (Invetario item : inventario) {
            System.out.println("ID do Item: " + item.getItem());
        }
    }

    public static List<Invetario> findItensByScene(Invetario inventarioBusca) {

        return null ;
    }

}