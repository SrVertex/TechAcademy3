package Model;

import java.util.List;

public class Item {
   private Integer id_item;
   private String nome_item;
   private String check_item;
   private String use_item;
   private Integer get_item;
   private Integer id_proxCena;
   private Integer id_cena;
   private String itemCenario_with;

    public String getItemCenario_with() {
        return itemCenario_with;
    }

    public void setItemCenario_with(String itemCenario_with) {
        this.itemCenario_with = itemCenario_with;
    }

    public Integer getId_item() {
        return id_item;
    }

    public void setId_item(Integer id_item) {
        this.id_item = id_item;
    }

    public String getNome_item() {
        return nome_item;
    }

    public void setNome_item(String nome_item) {
        this.nome_item = nome_item;
    }

    public String getCheck_item() {
        return check_item;
    }

    public void setCheck_item(String check_item) {
        this.check_item = check_item;
    }

    public String getUse_item() {
        return use_item;
    }

    public void setUse_item(String use_item) {
        this.use_item = use_item;
    }

    public Integer getGet_item() {
        return get_item;
    }

    public void setGet_item(Integer get_item) {
        this.get_item = get_item;
    }

    public Integer getId_proxCena() {
        return id_proxCena;
    }

    public void setId_proxCena(Integer id_proxCena) {
        this.id_proxCena = id_proxCena;
    }

    public Integer getId_cena() {
        return id_cena;
    }

    public void setId_cena(Integer id_cena) {
        this.id_cena = id_cena;
    }


    @Override
    public String toString() {
        return "Item{" +
                "id_item=" + id_item +
                ", nome_item='" + nome_item + '\'' +
                ", check_item='" + check_item + '\'' +
                ", use_item='" + use_item + '\'' +
                ", get_item=" + get_item +
                ", id_proxCena=" + id_proxCena +
                ", id_cena=" + id_cena +
                ", itemCenario_with='" + itemCenario_with + '\'' +
                '}';
    }

    public String getNome() {
        return nome_item;
    }
}
