package Comandos;

import Model.Cenas;
import Model.Invetario;

import java.sql.*;

public class InventarioDAO {


    public static Invetario SaveGame() throws SQLException {

        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO inventario (id_cenaAtual) VALUES (1)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();

        Invetario save = new Invetario();

        if(generatedKeys.next()){

            save.setId_save(generatedKeys.getInt(1));
            save.setId_cena_atual(CenasDAO.findCenaById(1));

        }

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

        }
        return invetario;
    }



}