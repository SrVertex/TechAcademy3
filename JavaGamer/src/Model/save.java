package Model;

public class save {
    private Integer idSave;
    private String nomeSave;
    private Integer usuarioId;

    public Integer getIdSave() {
        return idSave;
    }

    public void setIdSave(Integer idSave) {
        this.idSave = idSave;
    }

    public String getNomeSave() {
        return nomeSave;
    }

    public void setNomeSave(String nomeSave) {
        this.nomeSave = nomeSave;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public String toString() {
        return "save{" +
                "idSave=" + idSave +
                ", nomeSave='" + nomeSave + '\'' +
                ", usuarioId=" + usuarioId +
                '}';
    }
}
