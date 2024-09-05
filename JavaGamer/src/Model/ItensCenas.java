package Model;

public class ItensCenas {
    private Integer idItensCenas;
    private Item itemId;
    private Cenas cenasId;


    public Integer getIdItensCenas() {
        return idItensCenas;
    }

    public void setIdItensCenas(Integer idItensCenas) {
        this.idItensCenas = idItensCenas;
    }

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public Cenas getCenasId() {
        return cenasId;
    }

    public void setCenasId(Cenas cenasId) {
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
