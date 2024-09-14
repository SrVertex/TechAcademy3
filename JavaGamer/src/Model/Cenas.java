package Model;

import java.util.List;

public class Cenas {
  private Integer id_cena;
  private String descricao;
  private String item_cenario;
  private List<Item> liste_Item;

    public Integer getId_cena() {
        return id_cena;
    }

    public void setId_cena(Integer id_cena) {
        this.id_cena = id_cena;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getItem_cenario() {
        return item_cenario;
    }

    public void setItem_cenario(String item_cenario) {
        this.item_cenario = item_cenario;
    }

    public List<Item> getListe_Item() {
        return liste_Item;
    }

    public void setListe_Item(List<Item> liste_Item) {
        this.liste_Item = liste_Item;
    }

    @Override
    public String toString() {
        return "Cenas{" +
                "id_cena=" + id_cena +
                ", descricao='" + descricao + '\'' +
                ", item_cenario='" + item_cenario + '\'' +
                ", liste_Item=" + liste_Item +
                '}';
    }
}
