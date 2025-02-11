package edu.mu.LibraryApp;
import edu.mu.Library.*;

public class LibraryApp {
	public static void main(String[] args) {
		//create Library object
		Library lib = new Library();
		
		//add 3 books to library
		Book b1 = new Book("Clean Code", "Robert C. Martin", "978-0135166307", 40.99);
		Book b2 = new Book("Design Patterns", "Erich Gamma", "978-0201633610", 50.99);
		Book b3 = new Book("The Pragmatic Programmer", "Andrew Hunt", "978-0135957059", 45.99);
		
		lib.addBook(b1);
		lib.addBook(b2);
		lib.addBook(b3);
		
		//searches for a book by ISBN and displays the result
		lib.searchByISBN("978-0135166307");
		
		lib.displayBooks(); // TEMP
		
		//remove a book that exists and does not exist
		lib.removeBook(b2); //removing book that exists
		
		lib.displayBooks(); //TEMP
		
		Book b4 = new Book("Coding for Dummies", "Somebody", "978-0175166307", 100.99); //book not in library
		lib.removeBook(b4); //removing book that is not in library
		
		
		//Displays all books in the library
		lib.displayBooks();
	}
}