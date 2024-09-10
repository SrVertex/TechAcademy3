package Model;

import java.util.List;

public class Invetario {
    private Integer idInventario;
    private List<Item> itens;

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    @Override
    public String toString() {
        return "Invetario{" +
                "idInventario=" + idInventario +
                ", itens=" + itens +
                '}';
    }
}
