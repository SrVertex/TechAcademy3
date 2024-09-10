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
        String sql = "SELECT * FROM cenas WHERE id_cena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Cenas cenas = new Cenas();

        if (rs.next()) {

            cenas.setIdCena(rs.getInt("id_cena"));
            cenas.setNomeCena(rs.getString("nome_cena"));
            cenas.setDescrcaoCena(rs.getString("descricao_cena"));
            cenas.setDecricaoPositiva(rs.getString("descricao_positiva"));
            cenas.setDescrcaonNegativa(rs.getString("descricao_negativa"));
            cenas.setItens(ItemDAO.findItensByScene(cenas));


        }
        return cenas;

    }
    public static void insertCena(Cenas cenas) throws SQLException {
        Connection connection = Mysql.getConnection();
        String insert = "INSERT INTO cenas(descricao) VALUES (?);";
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setString(1, cenas.getDescrcaoCena());
        ps.execute();
    }
    public static List<Cenas> findAll() throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "select * from cenas;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        List<Cenas> cenas = new ArrayList<>();
        while (resultSet.next()) {
            Cenas cena = new Cenas();
            cena.setIdCena(resultSet.getInt("id_cena"));
            cena.setNomeCena(resultSet.getString("nome_cena"));
            cena.setDescrcaoCena(resultSet.getString("descricao_cena"));
            cena.setDecricaoPositiva(resultSet.getString("descricao_positiva"));
            cena.setDescrcaonNegativa(resultSet.getString("descricao_negativa"));



            cenas.add(cena);
        }
        return cenas;
    }
}
