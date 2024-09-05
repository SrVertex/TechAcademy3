package Model;

public class Save {
    private Integer idSave;
    private String nomeSave;
    private Usuario usuarioId;

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

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
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
