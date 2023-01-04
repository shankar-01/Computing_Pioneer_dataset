/**
 * each object of pioneer class contain data of pioneer
 * getter for first name, last name, and notoriety field
 * toString method return first name, last name , notoriety
 * compareTo method: compare object w.r.t to first name (helper method for sort method in sort class)
 * */
public class Pioneer implements Comparable{
    private String firstName = "";
    private String secondName = "";
    private String notoriety = "";

    public Pioneer(String firstName, String secondName, String notoriety){
        this.firstName = firstName;
        this.secondName = secondName;
        this.notoriety = notoriety;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getNotoriety() {
        return notoriety;
    }

    @Override
    public String toString() {
        return firstName +" , "+ secondName +" , "+ notoriety;
    }

    @Override
    public int compareTo(Object o) {
        return firstName.compareTo(((Pioneer)o).getFirstName());
    }
}
