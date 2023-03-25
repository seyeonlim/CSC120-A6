/* This is a stub for the Cafe class */
public class Cafe extends Building {

    private int nCoffeeOunces; 
    // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; 
    // The number of sugar packets remaining in inventory
    private int nCreams; 
    // The number of "splashes" of cream remaining in inventory
    private int nCups; 
    // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 100;
        System.out.println("You have built a cafe: ☕");
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams) {
        if (this.nCoffeeOunces < size) {
            restock(50, 0, 0,0);
        } 
        if (this.nSugarPackets < nSugarPackets) {
            restock(0, 50, 0,0);
        } 
        if (this.nCreams < nCreams) {
            restock(0, 0, 50,0);
        } 
        if (this.nCups <= 0) {
            restock(0, 0, 0,50);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }
    
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
    }

    public void printInventory() {
        System.out.println("Current Inventory: ");
        System.out.println("Coffee Ounces: " + this.nCoffeeOunces);
        System.out.println("Sugar Packets: " + this.nSugarPackets);
        System.out.println("Creams: " + this.nCreams);
        System.out.println("Cups: " + this.nCups);
    }

    public static void main(String[] args) {
        Cafe compass = new Cafe("Compass Cafe", "Blah Blah Street", 1);
        compass.printInventory();
        compass.sellCoffee(100, 100, 100);
        compass.printInventory();
        compass.sellCoffee(10, 10, 10);
        compass.printInventory();

    }
    
}
