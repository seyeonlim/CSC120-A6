/**
 * Course: CSC 120 (section 2)
 * @author Seyeon Lim
 * @version March 00, 2023
 * Description: A class that creates a library with a certain name, address,
 *              and number of floors. Allows to add or remove a certain book from the collection,
 *              check out or return a book, and returns the availability of the book or whether the collection
 *              has a certain book or not.
 */
import java.util.Hashtable;
import java.util.Map;
/* This is a stub for the Library class */
public class Library extends Building{

  private Hashtable<String, Boolean> collection;

  /**
   * Creates a library with a certain name, address, and number of floors. Makes a hashtable
   * for storing the title of the books in the library along with their availability.
   * Creates a hashtable for making a collection of books and recording their availability.
   * @param name the name of the library
   * @param address the address of the library
   * @param nFloors the number of floors of the library
   */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
  }
  
  /**
   * A method that adds a book to the library collection.
   * @param title the title of the book being added
   * @throws RuntimeException when the book is already in the collection.
   */
  public void addTitle(String title) {
    if (this.collection.containsKey(title)) {
      throw new RuntimeException(title + " is already in " + this.name);
    }
    this.collection.put(title, true);
    System.out.println(title + " has been added to " + this.name + ".");
  }

  /**
   * A method that removes a book from the library collection.
   * @param title the title of the book being removed
   * @return the title of the book being removed
   * @throws RuntimeException if the book being removed does not exist in the collection.
   */
  public String removeTitle(String title) {
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException(title + " is not in " + this.name);
    } 
    this.collection.remove(title);
    System.out.println(title + " removed from " + this.name);
    return title;
  }

  /**
   * A method that checks out a book.
   * @param title the title of the book being checked out.
   * @throws RuntimeException when the book does not exist in the collection.
   * @throws RuntimeException when the book is already checked out.
   */
  public void checkOut(String title) {
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException(title + " is not in " + this.name);
    } else if (this.collection.get(title) == false) {
      throw new RuntimeException(title + " is already checked out.");
    }
    this.collection.replace(title, true, false);
    System.out.println(title + " has been succesfully checked out.");
  }

  /**
   * A method that returns a book.
   * @param title the title of the book being returned. 
   * @throws RuntimeException when the book does not exist in the collection
   * @throws RuntimeException when the book is already returned.
   */
  public void returnBook(String title) {
    if (!this.collection.containsKey(title)) {
      throw new RuntimeException(title + " is not in " + this.name);
    } else if (this.collection.get(title) == true) {
      throw new RuntimeException(title + " is already returned.");
    }
    this.collection.replace(title, false, true);
    System.out.println(title + " has been succesfully returned.");
  }

  /**
   * A method that checks if a certain book is in the collection.
   * @param title the title of the book
   * @return whether the book is in the collection or not
   */
  public boolean containsTitle(String title) {
    if (this.collection.containsKey(title)) {
      return true;
    } else {
      return false;
    }
  } 
  
  /**
   * A method that checks if a certain book is available.
   * @param title the title of the book
   * @return whether the book is available or not
   */
  public boolean isAvailable(String title) {
    if (this.collection.get(title) == true) {
      return true;
    } else {
      return false;
    }
  } 
  
  /**
   * A method that prints out the collection along with each book's availability. 
   */
  public void printCollection() {
    System.out.println("=====Collection=====");
    for (Map.Entry<String, Boolean> collection : this.collection.entrySet()) {
      System.out.println("Title: " + collection.getKey() + "\nAvailability: " + collection.getValue());
    }
    System.out.println("====================");
  }
  
  /**
   * Demonstration of making a library and using addTitle(...), removeTitle(...),
   * printCollection(), checkOut(...), and returnBook(...) methods.
   * @param args
   */
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
    //neilson.checkOut("Dog");
    neilson.returnBook("Goose");
  }
  
  }