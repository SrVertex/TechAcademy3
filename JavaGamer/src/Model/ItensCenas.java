package Model;

public class ItensCenas {
    private Integer idItensCenas;
    private Integer itemId;
    private Integer cenasId;

    public Integer getIdItensCenas() {
        return idItensCenas;
    }

    public void setIdItensCenas(Integer idItensCenas) {
        this.idItensCenas = idItensCenas;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCenasId() {
        return cenasId;
    }

    public void setCenasId(Integer cenasId) {
        this.cenasId = cenasId;
    }

    @Override
    public String toString() {
        return "ItensCenas{" +
                "idItensCenas=" + idItensCenas +
                ", itemId=" + itemId +
                ", cenasId=" + cenasId +
                '}';
    }
}
