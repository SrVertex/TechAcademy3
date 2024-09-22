package Comandos;

import Model.Cenas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CenasDAO {


        public static Integer proximaCenas = 1;



    public static Cenas findCenaById(Integer id) throws SQLException {

                    // CONECXAO A TABLA CENAS
        Connection conn = Mysql.getConnection();
        String sql = "SELECT * FROM cena WHERE id_cena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(proximaCenas, id);
        ResultSet rs = stmt.executeQuery();

        Cenas cenas = new Cenas();

        if (rs.next()) {

                    // ITENS DO BANCO DE DADOS
            cenas.setId_cena(rs.getInt("id_cena"));
            cenas.setDescricao_cena(rs.getString("descricao_cena"));
            cenas.setNome_cena(rs.getString("nome_cena"));
            cenas.setItem_cenario(rs.getString("item_cenario"));
            cenas.setTextoPositivo_cena(rs.getString("textoPositivo_cena"));
            cenas.setTextoNegativo_cena(rs.getString("textoNegativo_cena"));
            cenas.setItens1(ItemDAO.findItensByScene(cenas));

        }

        return cenas;

    }
    public static void insertCena(Cenas cenas) throws SQLException {
        Connection connection = Mysql.getConnection();
        String insert = "INSERT INTO cena (descricao_cena) VALUES (?);";
        PreparedStatement ps = connection.prepareStatement(insert);
        ps.setString(CenasDAO.proximaCenas, cenas.getDescricao_cena());
        ps.execute();
    }

                     // LISTA DE ITENS DA CENAS
    public static List<Cenas> findAll() throws SQLException {
        Connection connection = Mysql.getConnection();
        String sql = "select * from cena;";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();

        List<Cenas> cenas = new ArrayList<>();
        while (resultSet.next()) {

            Cenas cena = new Cenas();

            cena.setId_cena(resultSet.getInt("id_cena"));
            cena.setDescricao_cena(resultSet.getString("descricao_cena"));
            cena.setNome_cena(resultSet.getString("nome_cena"));
            cena.setItem_cenario(resultSet.getString("item_cenario"));
            cena.setTextoPositivo_cena(resultSet.getString("textoPositivo_cena"));
            cena.setTextoNegativo_cena(resultSet.getString("textoNegativo_cena"));

            cenas.add(cena);
        }
        return cenas;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
