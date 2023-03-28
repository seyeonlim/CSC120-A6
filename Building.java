/**
 * Course: CSC 120 (section 2)
 * 
 * @author Seyeon Lim
 * @version March 00, 2023
 *          Description: A class that creates a building with a certain name, address, and number of floors.
 *          Allows access to the name, address, and number of floors of the building.
 */

public class Building {

    protected String name = "<Name Unknown>";
    protected String address = "<Address Unknown>";
    protected int nFloors = 1;

    /**
     * Creates a building and throws an exception when the building has less than 1
     * floor
     * @param name    the name of the building
     * @param address the address of the building
     * @param nFloors the number of floors of the building
     * @throws RuntimeException when the building has less than 1 floor.
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) {
            this.name = name;
        }
        if (address != null) {
            this.address = address;
        }
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /**
     * An accessor for accessing the name of the building
     * @return the name of the building
     */
    public String getName() {
        return this.name;
    }

    /**
     * An accessor for accessing the address of the building
     * @return the address of the building
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * An accessor for accessing the number of floors of the building
     * @return the number of floors of the building
     */
    public int getFloors() {
        return this.nFloors;
    }

    /**
     * A method to print out the building information
     * @return the building information
     */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address;
    }

    /**
     * Demonstrates the making of a building and printing out the information of
     * that building
     * @param args
     */
    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
    }

}
