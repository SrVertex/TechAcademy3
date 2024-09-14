package Model;

import java.util.List;

public class Invetario {
    private Integer Id_save;
    private List<Item> id_item;
    private Integer Id_cena_atual;

    public Integer getId_save() {
        return Id_save;
    }

    public void setId_save(Integer id_save) {
        Id_save = id_save;
    }

    public List<Item> getId_item() {
        return id_item;
    }

    public void setId_item(List<Item> id_item) {
        this.id_item = id_item;
    }

    public Integer getId_cena_atual() {
        return Id_cena_atual;
    }

    public void setId_cena_atual(Integer id_cena_atual) {
        Id_cena_atual = id_cena_atual;
    }

    @Override
    public String toString() {
        return "Invetario{" +
                "Id_save=" + Id_save +
                ", id_item=" + id_item +
                ", Id_cena_atual=" + Id_cena_atual +
                '}';
    }
}
