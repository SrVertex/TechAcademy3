package Comandos;

import Model.Cenas;
import Model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    public static Item findItemById(Integer id) {
        return new Item();
    }

    public static List<Item> findItensByScene(Cenas cenas) throws SQLException {

        Connection connection = Mysql.getConnection();

        String sql = "select * from item i where id_item = ?;";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, cenas.getIdCena());
        ResultSet resultSet = ps.executeQuery();

        List<Item> itens = new ArrayList<>();

        while (resultSet.next()) {

            Item item = new Item();

            item.setIdItem(resultSet.getInt("id_item"));
            item.setNomeItem(resultSet.getString("nome_item"));
            item.setComandoUse(resultSet.getString("comando_use"));

            itens.add(item);

        }

        return itens;

    }

    public static Object findItensByScene(Integer idItem) {
        return idItem;
    }
}


