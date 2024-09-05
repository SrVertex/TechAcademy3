package Model;

public class Invetario {
    private Integer idInventario;
    private Usuario usuarioSaveId;


    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Usuario getUsuarioSaveId() {
        return usuarioSaveId;
    }

    public void setUsuarioSaveId(Usuario usuarioSaveId) {
        this.usuarioSaveId = usuarioSaveId;
    }

    @Override
    public String toString() {
        return "Invetory{" +
                "idInventario=" + idInventario +
                ", usuarioSaveId=" + usuarioSaveId +
                '}';
    }
}
