package Entity.User;

public enum AgeClass {
    ADULT("Adult"),
    CHILD("Child"),
    SENIORCITIZEN("Senior Citizen");

    private final String text;

    private AgeClass(String text) {
        this.text = text;
    }

    public String toString() {
        return this.text;
    }
}
