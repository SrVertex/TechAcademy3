package Model;

public class Invetory {
    private Integer idInventario;
    private Integer usuarioSaveId;

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Integer getUsuarioSaveId() {
        return usuarioSaveId;
    }

    public void setUsuarioSaveId(Integer usuarioSaveId) {
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
