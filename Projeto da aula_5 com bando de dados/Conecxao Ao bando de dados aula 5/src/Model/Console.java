package Model;

public class Console {
    private  String mensagem;
    private Integer idSena;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Integer getIdSena() {
        return idSena;
    }

    public void setIdSena(Integer idSena) {
        this.idSena = idSena;
    }

    @Override
    public String toString() {
        return "Console{" +
                "mensagem='" + mensagem + '\'' +
                ", idSena=" + idSena +
                '}';
    }
}
