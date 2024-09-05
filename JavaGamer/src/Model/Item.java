package Model;

public class Item {
    private Integer idItem;
    private String nomeItem;
    private String comandoUse;
    private Invetario inventarioId;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getComandoUse() {
        return comandoUse;
    }

    public void setComandoUse(String comandoUse) {
        this.comandoUse = comandoUse;
    }

    public Invetario getInventarioId() {
        return inventarioId;
    }

    public void setInventarioId(Invetario inventarioId) {
        this.inventarioId = inventarioId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", nomeItem='" + nomeItem + '\'' +
                ", comandoUse='" + comandoUse + '\'' +
                ", inventarioId=" + inventarioId +
                '}';
    }
}
