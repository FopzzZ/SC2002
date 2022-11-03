package Entity.Cinema;

public class cinema {
    private cinemaType type;
    private String ID;

    public cinema() {
        this.type = cinemaType.NORMAL;
    }

    public cinema(cinemaType type, String ID) {
        this.type = type;
        this.ID = ID;
    }

    public cinemaType getType() {
        return this.type;
    }

    public void setType(cinemaType type) {
        this.type = type;
    }

    public String getID() {
        return this.ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
}
