package Entity.Cinema;

import java.io.Serializable;

public class Cinema implements Serializable {
    private CinemaType type;
    private String name;

    public Cinema() {
        this.type = CinemaType.NORMAL;
    }

    public Cinema(CinemaType type, String name) {
        this.type = type;
        this.name = name;
    }

    public Cinema(String name) {
        this.type = CinemaType.NORMAL;
        ;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(CinemaType type) {
        this.type = type;
    }

    public CinemaType getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

}
