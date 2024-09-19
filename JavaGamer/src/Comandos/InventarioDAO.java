package Comandos;

import Model.Invetario;

import java.sql.*;

public class InventarioDAO {


    public static Invetario SaveGame() throws SQLException {

        Connection conn = Mysql.getConnection();
        String sql = "INSERT INTO inventario (id_save) VALUES (1)";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();

        Invetario save = new Invetario();

        if(generatedKeys.next()){

            save.setId_save(generatedKeys.getInt(1));

        } else {

            return null;

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
            invetario.setId_cena_atual(rs.getInt("id_cenaAtual"));
            invetario.setId_progresso(rs.getInt("id_progresso"));

        }

        return invetario;

    }



        // CAPITURA DOS ITENS DO INVENTARIO

    public static Invetario findInventarioItemByid(Integer id) throws SQLException {

        Connection connection = Mysql.getConnection();
        String sql = "select id_item from inventario where id_save = ?;";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Invetario invetario = new Invetario();

        if (rs.next()) {

            invetario.setItenss(ItemDAO.findItensByScene(invetario));

        }

        return invetario;

    }

    // AJUSTES DO INVENTARIO/SAVE

//    public static Invetario fandInvetarioSaveByid(Integer id) throws SQLException {
//
//        Connection connection = Mysql.getConnection();
//        String sql = "insert into inventario (id_save ,id_cenaAtual ,id_progresso ,id_item)\n" +
//                "values ('?', null, null, null);";
//
//        PreparedStatement stmt = connection.prepareStatement(sql);
//        stmt.setInt(1, id);
//        ResultSet rs = stmt.executeQuery();
//
//        Invetario invetario = new Invetario();
//
//        if (rs.next()) {
//
//            invetario.setId_save(rs.getInt("id_save"));
//        }
//
//        return invetario;
//
//    }

}