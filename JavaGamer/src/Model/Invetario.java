package Model;

import Comandos.CenasDAO;

import java.util.List;

public class Invetario {

    private Integer Id_save;
    private Integer Id_progresso;
    private List<Item> itenss;
    private Integer Id_cena_atual;

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
                ", Id_progresso=" + Id_progresso +
                ", itenss=" + itenss +
                ", Id_cena_atual=" + Id_cena_atual +
                '}';
    }
}
