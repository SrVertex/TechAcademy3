package Model;

import java.util.List;

public class Invetario extends Item {

    private Integer Id_save;
    private Integer Id_progresso;
    private List<Item> itenss;
    private Cenas Id_cena_atual;
    private Integer ID_CENA_ATUAL2;
    private Integer item;

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getId_save() {
        return Id_save;
    }

    public void setId_save(Integer id_save) {
        Id_save = id_save;
    }

    public Integer getId_progresso() {
        return Id_progresso;
    }

    public void setId_progresso(Integer id_progresso) {
        Id_progresso = id_progresso;
    }

    public List<Item> getItenss() {
        return itenss;
    }

    public void setItenss(List<Item> itenss) {
        this.itenss = itenss;
    }

    public Cenas getId_cena_atual() {
        return Id_cena_atual;
    }

    public void setId_cena_atual(Cenas id_cena_atual) {
        Id_cena_atual = id_cena_atual;
    }

    public Integer getID_CENA_ATUAL2() {
        return ID_CENA_ATUAL2;
    }

    public void setID_CENA_ATUAL2(Integer ID_CENA_ATUAL2) {
        this.ID_CENA_ATUAL2 = ID_CENA_ATUAL2;
    }

    @Override
    public String toString() {
        return "Invetario{" +
                "Id_save=" + Id_save +
                ", Id_progresso=" + Id_progresso +
                ", itenss=" + itenss +
                ", Id_cena_atual=" + Id_cena_atual +
                ", ID_CENA_ATUAL2=" + ID_CENA_ATUAL2 +
                ", item=" + item +
                '}';
    }
}
