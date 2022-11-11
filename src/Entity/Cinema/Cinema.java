package Entity.Cinema;

import java.io.Serializable;

/**
 * Cinema is an entity
 */

public class Cinema implements Serializable {
    private CinemaType type;
    private String name;

    public Cinema() {
        this.type = CinemaType.NORMAL;
    }

    /**
     * A constructor for the Cinema Class
     * 
     * @param type Determines the type of the cinema
     * @param name Determines the name of the cinema
     */
    public Cinema(CinemaType type, String name) {
        this.type = type;
        this.name = name;
    }

    /**
     * A constructor for the Cinema Class where default type NORMAL is given to the
     * cinema
     * 
     * @param name Determines the name of the cinema
     */
    public Cinema(String name) {
        this.type = CinemaType.NORMAL;
        ;
        this.name = name;
    }

    /**
     * A method to set the name of the cinema
     * 
     * @param String Name to be given to the cinema
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A method to set the name of the cinema
     * 
     * @param CinemaType Type to be given to the cinema
     */
    public void setType(CinemaType type) {
        this.type = type;
    }

    /**
     * Method to get the type of the Cinema object
     *
     * @return CinemaType This returns the type of the Cinema object
     */

    public CinemaType getType() {
        return this.type;
    }

    /**
     * Method to get the name of the Cinema object
     *
     * @return String This returns the name of the Cinema object
     */

    public String getName() {
        return this.name;
    }

}
