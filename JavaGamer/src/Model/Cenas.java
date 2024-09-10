package Model;

import java.util.List;

public class Cenas {
    private Integer idCena;
    private String nomeCena;
    private String descrcaoCena;
    private String DecricaoPositiva;
    private String DescrcaonNegativa;
    private List<Item> itens;

    public Integer getIdCena() {
        return idCena;
    }

    public void setIdCena(Integer idCena) {
        this.idCena = idCena;
    }

    public String getNomeCena() {
        return nomeCena;
    }

    public void setNomeCena(String nomeCena) {
        this.nomeCena = nomeCena;
    }

    public String getDescrcaoCena() {
        return descrcaoCena;
    }

    public void setDescrcaoCena(String descrcaoCena) {
        this.descrcaoCena = descrcaoCena;
    }

    public String getDecricaoPositiva() {
        return DecricaoPositiva;
    }

    public void setDecricaoPositiva(String decricaoPositiva) {
        DecricaoPositiva = decricaoPositiva;
    }

    public String getDescrcaonNegativa() {
        return DescrcaonNegativa;
    }

    public void setDescrcaonNegativa(String descrcaonNegativa) {
        DescrcaonNegativa = descrcaonNegativa;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Cenas{" +
                "idCena=" + idCena +
                ", nomeCena='" + nomeCena + '\'' +
                ", descrcaoCena='" + descrcaoCena + '\'' +
                ", DecricaoPositiva='" + DecricaoPositiva + '\'' +
                ", DescrcaonNegativa='" + DescrcaonNegativa + '\'' +
                ", itens=" + itens +
                '}';
    }
}
