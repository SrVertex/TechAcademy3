package Repository;

import Model.Item;
import Model.Cena;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {
  public static Item findItemById(Integer id) {
      return new Item();
  }

    public static List<Item> findItensByScene(Cena cena) throws SQLException {

        Connection connection = Mysql.getConnection();

        String sql = "select * from itens i where id_cena_atual = ?;";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cena.getIdCena());
        ResultSet resultSet = ps.executeQuery();

        List<Item> itens = new ArrayList<>();

        while (resultSet.next()) {

            Item item = new Item();
            item.setIdItem(resultSet.getInt("id_item"));
            item.setNome(resultSet.getString("nome"));

            Integer idCenaAtual = resultSet.getInt("id_cena_atual");
//            Cena cenaAtual = CenaDAO.finalCenabyid(idCenaAtual);

            item.setIdCenaAtual(idCenaAtual);

            itens.add(item);

        }

        return itens;

    }
}

