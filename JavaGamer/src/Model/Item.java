package Model;

public class Item {
    private Integer idItem;
    private String nomeItem;
    private String comandoUse;
    private Integer inventarioId;

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

    public Integer getInventarioId() {
        return inventarioId;
    }

    public void setIdInventario(Integer inventarioId) {
        this.inventarioId = inventarioId;
    }

    @Override
    public String toString() {
        return "Item{" +
                "idItem=" + idItem +
                ", nomeItem='" + nomeItem + '\'' +
                ", comandoUse='" + comandoUse + '\'' +
                ", idInventario=" + inventarioId +
                '}';
    }
}
