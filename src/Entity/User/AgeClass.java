package Entity.User;
/**
* AgeClass is an entity containing the categories of the age of the user
*/
public enum AgeClass {
    ADULT("Adult"),
    CHILD("Child"),
    SENIORCITIZEN("Senior Citizen");

    private final String text;
    /**
    * A constructor for the AgeClass class
    * 
    * @param text Determines the AgeClass category
    */
    private AgeClass(String text) {
        this.text = text;
    }
    /** 
     * A method that returns the AgeClass category as a string
     * 
     * @return double This returns AgeClass category
     */
    public String toString() {
        return this.text;
    }
}
