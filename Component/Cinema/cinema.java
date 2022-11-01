package SC2002.Component.Cinema;

public class cinema {
    cinemaType type;
    String ID;
    
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
}
