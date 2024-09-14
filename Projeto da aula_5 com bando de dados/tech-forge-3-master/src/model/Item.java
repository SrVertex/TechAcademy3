package model;

public class Item {
    private Integer idItem;
    private String nome;
    private String descricaoPositiva;
    private String descricaoNegativa;
    private String comandoCorreto;
    private Integer idCenaAtual;
    private Integer idCenaDestino;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoPositiva() {
        return descricaoPositiva;
    }

    public void setDescricaoPositiva(String descricaoPositiva) {
        this.descricaoPositiva = descricaoPositiva;
    }

    public String getDescricaoNegativa() {
        return descricaoNegativa;
    }

    public void setDescricaoNegativa(String descricaoNegativa) {
        this.descricaoNegativa = descricaoNegativa;
    }

    public String getComandoCorreto() {
        return comandoCorreto;
    }

    public void setComandoCorreto(String comandoCorreto) {
        this.comandoCorreto = comandoCorreto;
    }

    public Integer getIdCenaAtual() {
        return idCenaAtual;
    }

    public void setIdCenaAtual(Integer idCenaAtual) {
        this.idCenaAtual = idCenaAtual;
    }

    public Integer getIdCenaDestino() {
        return idCenaDestino;
    }

    public void setIdCenaDestino(Integer idCenaDestino) {
        this.idCenaDestino = idCenaDestino;
    }

}
