package Model;

import java.util.List;

public class Cenas {

  private Integer id_cena;
  private String descricao_cena;
  private Integer id_useWith;
  private String item_cenario;
  private String nome_cena;
  private String textoPositivo_cena;
  private String textoNegativo_cena;
  private List<Item> Itens1;

    public Integer getId_cena() {
        return id_cena;
    }

    public void setId_cena(Integer id_cena) {
        this.id_cena = id_cena;
    }

    public String getDescricao_cena() {
        return descricao_cena;
    }

    public void setDescricao_cena(String descricao_cena) {
        this.descricao_cena = descricao_cena;
    }

    public Integer getId_useWith() {
        return id_useWith;
    }

    public void setId_useWith(Integer id_useWith) {
        this.id_useWith = id_useWith;
    }

    public String getItem_cenario() {
        return item_cenario;
    }

    public void setItem_cenario(String item_cenario) {
        this.item_cenario = item_cenario;
    }

    public String getNome_cena() {
        return nome_cena;
    }

    public void setNome_cena(String nome_cena) {
        this.nome_cena = nome_cena;
    }

    public String getTextoPositivo_cena() {
        return textoPositivo_cena;
    }

    public void setTextoPositivo_cena(String textoPositivo_cena) {
        this.textoPositivo_cena = textoPositivo_cena;
    }

    public String getTextoNegativo_cena() {
        return textoNegativo_cena;
    }

    public void setTextoNegativo_cena(String textoNegativo_cena) {
        this.textoNegativo_cena = textoNegativo_cena;
    }

    public List<Item> getItens1() {
        return Itens1;
    }

   public void setItens1(List<Item> liste_Item) {
        this.Itens1 = liste_Item;
    }

    @Override
    public String toString() {
        return "Cenas{" +
                "id_cena=" + id_cena +
                ", descricao_cena='" + descricao_cena + '\'' +
                ", id_useWith=" + id_useWith +
                ", item_cenario='" + item_cenario + '\'' +
                ", nome_cena='" + nome_cena + '\'' +
                ", textoPositivo_cena='" + textoPositivo_cena + '\'' +
                ", textoNegativo_cena='" + textoNegativo_cena + '\'' +
                ", liste_Item=" + Itens1 +
                '}';
    }

}
