package Comandos;

import Model.Cenas;
import Model.Invetario;
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

    public static Integer atualizaItem = 1;

    public static List<Item> findItensByScene(Cenas cenas) throws SQLException {

        Connection connection = Mysql.getConnection();
            String sql = "select * from item i where id_item = ?;";
                PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setInt(atualizaItem, cenas.getId_cena());
                        ResultSet resultSet = ps.executeQuery();

        List<Item> itens = new ArrayList<>();

        while (resultSet.next()) {

            Item item = new Item();

                item.setId_item(resultSet.getInt("id_item"));
                    item.setNome_item(resultSet.getString("nome_item"));
                        item.setCheck_item(resultSet.getString("check_item"));
                            item.setUse_item(resultSet.getString("use_item"));
                                item.setGet_item(resultSet.getInt("get_item"));
                                    item.setId_proxCena(resultSet.getInt("id_proxCena"));
                                        item.setItemCenario_with(resultSet.getString("id_proxCena"));

            itens.add(item);
        }
        return itens;
    }

    public static Object findItensByScene(Integer idItem) {

        return idItem;
    }

    public static List<Item> findItensByScene(Invetario invetario1) {

        return null;
    }
}


