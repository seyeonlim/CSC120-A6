import java.util.Hashtable;
import java.util.Map;
/* This is a stub for the Library class */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }
  
  public void addTitle(String title) {
    if (this.collection.containsKey(title)) {
      throw new RuntimeException(title + " is already in " + this.name);
    }
    this.collection.put(title, true);
    System.out.println(title + " has been added to " + this.name + ".");
  }

  public String removeTitle(String title) {
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException(title + " is not in " + this.name);
    } 
    this.collection.remove(title);
    System.out.println(title + " removed from " + this.name);
    return title;
  }

  //unavailable when 1. the book is not in the library
  //2. the book is already checked out
  public void checkOut(String title) {
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException(title + " is not in " + this.name);
    } else if (this.collection.get(title) == false) {
      throw new RuntimeException(title + " is already checked out.");
    }
    this.collection.replace(title, true, false);
    System.out.println(title + " has been succesfully checked out.");
  }

  public void returnBook(String title) {
    if (this.collection.get(title) == true) {
      throw new RuntimeException(title + " is already returned.");
    }
    this.collection.replace(title, false, true);
    System.out.println(title + " has been succesfully returned.");
  }

  public boolean containsTitle(String title) {
    if (this.collection.contains(title)) {
      return true;
    } else {
      return false;
    }
  } 
  
  public boolean isAvailable(String title) {
    if (this.collection.get(title) == true) {
      return true;
    } else {
      return false;
    }
  } 
  
  public void printCollection() {
    System.out.println("=====Collection=====");
    for (Map.Entry<String, Boolean> collection : this.collection.entrySet()) {
      System.out.println("Title: " + collection.getKey() + "\nAvailability: " + collection.getValue());
    }
    System.out.println("====================");
  }
  // prints out the entire collection in an easy-to-read way (including checkout status)
  public static void main(String[] args) {
    Library neilson = new Library("Neilson", "Blah Blah Street", 4);
    neilson.addTitle("Sheep");
    neilson.addTitle("Dog");
    neilson.addTitle("Cat");
    neilson.printCollection();
    neilson.removeTitle("Sheep");
    neilson.printCollection();
    //neilson.removeTitle("Sheep");
    //neilson.addTitle("Dog");
    neilson.checkOut("Cat");
    neilson.printCollection();
    neilson.returnBook("Cat");
    neilson.printCollection();
    //neilson.returnBook("Cat");
    neilson.checkOut("Dog");
    neilson.printCollection();
    neilson.checkOut("Dog");
  }
  
  }