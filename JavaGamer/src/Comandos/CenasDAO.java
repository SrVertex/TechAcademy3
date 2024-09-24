package Comandos;

import Model.Cenas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CenasDAO {

    public static Integer proximaCenas = 1;

    public static Cenas findCenaById(Integer id) throws SQLException {

            Connection conn = null;
                PreparedStatement stmt = null;
                    ResultSet rs = null;
                        Cenas cenas = new Cenas();

        try {

            conn = Mysql.getConnection();
                String sql = "SELECT * FROM cena WHERE id_cena = ?";
                    stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, id);
                            rs = stmt.executeQuery();

            if (rs.next()) {

                cenas.setId_cena(rs.getInt("id_cena"));
                    cenas.setDescricao_cena(rs.getString("descricao_cena"));
                        cenas.setNome_cena(rs.getString("nome_cena"));
                            cenas.setItem_cenario(rs.getString("item_cenario"));
                                cenas.setTextoPositivo_cena(rs.getString("textoPositivo_cena"));
                                    cenas.setTextoNegativo_cena(rs.getString("textoNegativo_cena"));
                                        cenas.setItens1(ItemDAO.findItensByScene(cenas));

            }

        } finally {

            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();

        }

        return cenas;

    }

    public static void insertCena(Cenas cenas) throws SQLException {

        Connection connection = null;
        PreparedStatement ps = null;

        try {

            connection = Mysql.getConnection();
                String insert = "INSERT INTO cena (descricao_cena) VALUES (?);";
                    ps = connection.prepareStatement(insert);
                        ps.setString(1, cenas.getDescricao_cena());
                            ps.execute();

        } finally {

            if (ps != null) ps.close();
            if (connection != null) connection.close();

        }
    }

    public static List<Cenas> findAll() throws SQLException {

        Connection connection = null;
            PreparedStatement ps = null;
                ResultSet resultSet = null;
                    List<Cenas> cenas = new ArrayList<>();

        try {

            connection = Mysql.getConnection();
                String sql = "SELECT * FROM cena;";
                    ps = connection.prepareStatement(sql);
                        resultSet = ps.executeQuery();

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

        } finally {

            if (resultSet != null) resultSet.close();
                if (ps != null) ps.close();
                    if (connection != null) connection.close();

        }
        return cenas;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
