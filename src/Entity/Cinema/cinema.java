package Entity.Cinema;

import java.io.Serializable;

public class Cinema implements Serializable {
    private CinemaType type;
    private String name;
    private int ID;

    public Cinema() {
        this.type = CinemaType.NORMAL;
    }

    public Cinema(CinemaType type, String name, int ID) {
        this.type = type;
        this.name = name;
        this.ID = ID;
    }

    protected void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(CinemaType type) {
        this.type = type;
    }

    public int getID() {
        return this.ID;
    }

    public CinemaType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

}
