import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
/* This is a stub for the Library class */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;

  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    System.out.println("You have built a library: 📖");
  }
  
  public void addTitle(String title) {
    if (this.collection.contains(title)) {
      throw new RuntimeException(title + " is already in " + this.name);
    }
    // if we're good to go, add to roster
    this.collection.put(title, true);
    System.out.println(title + " has been added to " + this.name + ".");
  }

  public String removeTitle(String title) {
    if (!this.collection.contains(title)) {
      throw new RuntimeException(title + " is not in " + this.name);
    }
    this.collection.remove(title);
    return title + " removed from " + this.name;
  }

  //unavailable when 1. the book is not in the library
  //2. the book is already checked out
  public void checkOut(String title) {
    if (!this.collection.contains(title)) {
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
    Set<Map.Entry<String, Boolean>> collections = this.collection.entrySet();
    for (Map.Entry<String, Boolean> collection : collections) {
      System.out.println("Title: " + collection.getKey() + "\nAvailability: " + collection.getValue());
    }
  }
  // prints out the entire collection in an easy-to-read way (including checkout status)
  public static void main(String[] args) {
    Library neilson = new Library("Neilson", "Blah Blah Street", 4);
    neilson.addTitle("Sheep");
    neilson.addTitle("Dog");
    neilson.addTitle("Cat");
    neilson.printCollection();
  }
  
  }