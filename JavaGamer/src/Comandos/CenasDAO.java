package Comandos;

import Model.Cenas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CenasDAO {
    public static Cenas findCenaById(Integer id) throws SQLException {

        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM cena WHERE id_cena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Cenas cenas = new Cenas();

        if (rs.next()) {

            cenas.setId_cena(rs.getInt("id_cena"));
            cenas.setDescricao(rs.getString("descricao_cena"));
            cenas.setItem_cenario(rs.getString("item_cenario"));
            cenas.setListe_Item(ItemDAO.findItensByScene(cenas));

        }

            return cenas;

    }
    public static void insertCena(Cenas cenas) throws SQLException {
        Connection connection = Mysql.getConnection();
        String insert = "INSERT INTO cena (descricao_cena) VALUES (?);";
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setString(1, cenas.getDescricao());
        ps.execute();
    }
    public static List<Cenas> findAll() throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "select * from cena;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        List<Cenas> cenas = new ArrayList<>();
        while (resultSet.next()) {
            Cenas cena = new Cenas();

            cena.setId_cena(resultSet.getInt("id_cena"));
            cena.setDescricao(resultSet.getString("descricao_cena"));
            cena.setItem_cenario(resultSet.getString("item_cenario"));

            cenas.add(cena);
        }
        return cenas;
    }
}
