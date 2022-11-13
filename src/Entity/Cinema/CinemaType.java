package Entity.Cinema;
/**
* CinemaType is an entity
*/
public enum CinemaType {
    GOLDCLASS("Gold Class"),
    PLATINUM("Platinum"),
    IMAX("IMax"),
    NORMAL("Normal");

    private final String text;

    /**
    * A constructor for the CinemaType Class
    * 
    * @param text Determines the type of the cinema
    */
    private CinemaType(String text) {
        this.text = text;
    }
    /**
    * A method to convert the CinemaType to a String
    * 
    * @return String Type of the cinema
    */
    public String toString() {
        return this.text;
    }
}
