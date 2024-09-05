package Model;

public class Cenas {
    private Integer idCena;
    private String nomeCena;
    private String descrcaoCena;
    private String DecricaoPositiva;
    private String DescrcaonNegativa;
    private Integer idItensCena;

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

    public Integer getIdItensCena() {
        return idItensCena;
    }

    public void setIdItensCena(Integer idItensCena) {
        this.idItensCena = idItensCena;
    }


    @Override
    public String toString() {
        return "Cenas{" +
                "idCena=" + idCena +
                ", nomeCena='" + nomeCena + '\'' +
                ", descrcaoCena='" + descrcaoCena + '\'' +
                ", DecricaoPositiva='" + DecricaoPositiva + '\'' +
                ", DescrcaonNegativa='" + DescrcaonNegativa + '\'' +
                ", idItensCena=" + idItensCena +
                '}';
    }
}
