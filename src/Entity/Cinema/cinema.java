package Entity.Cinema;

public class Cinema {
    private CinemaType type;
    private String ID;

    public Cinema() {
        this.type = CinemaType.NORMAL;
    }

    public Cinema(CinemaType type, String ID) {
        this.type = type;
        this.ID = ID;
    }

    public CinemaType getType() {
        return this.type;
    }

    public void setType(CinemaType type) {
        this.type = type;
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
