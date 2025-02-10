package edu.mu.Library;

public class Library {
	private Book[] books;
	private int count;
	
	/**
	 * Default constructor of Library
	 */
	public Library() {
		this.books = new Book[5];
		this.count = 0;
	}
	
	public Book[] getBooks() {
		return books;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Adds a book to the array if there is space
	 * @param book
	 * This argument is a Book object
	 * @return
	 * Returns true if book is added, false if not
	 */
	public boolean addBook(Book book) {
		System.out.println("Adding book...");
		
		if(this.count < getBooks().length) {
			for(int i = 0; i < getBooks().length; i++) {
				if(this.books[i] == null) {
					this.books[i] = book;
					this.count++;
					System.out.println("Book added successfully");
					return true;
				}
			}
			
		}
		System.out.println("Failed to add book");
		return false;
	}
	
	/**
	 * Removes book from array if the book exists
	 * @param book
	 * This is the book object the method will look for
	 * @return
	 * returns true if book is removed, false if not
	 */
	public boolean removeBook(Book book) {
		System.out.println("Removing book...");
		for(int i =0; i < getBooks().length; i++) {
			System.out.println(i + ": " +getBooks()[i].equals(book));
			if(getBooks()[i].equals(book)) {
				this.books[i] = null;
				this.count--;
				fixArray();
				System.out.println("Book removed");
				return true;
			}
		}
		System.out.println("Book not found");
		return false;
	}
	
	private void fixArray() {
		for(int i = 0; i < getBooks().length; i++) {
			try {
				if(this.books[i] == null && this.books[i+1] != null) {
					this.books[i] = this.books[i+1];
					this.books[i+1] = null;
				}
			}
			catch(Exception e) {
				break;
			}
			
		}
	}
	
	/**
	 * Searches for book by ISBN
	 * @param ISBN
	 * This is the ISBN string the method will look for
	 * @return
	 * returns the book with the matching ISBN, else returns null
	 */
	public Book searchByISBN(String ISBN) {
		System.out.println("Searching for book with ISBN " + ISBN);
		for(int i = 0; i< getBooks().length; i++) {
			if(this.books[i].getISBN()==ISBN) {
				System.out.println("Book found: " + this.books[i].toString());
				return this.books[i];
			}
		}
		System.out.println("Book not found");
		return null;
	}
	
	/**
	 * Prints all book information in library
	 */
	public void displayBooks() {
		System.out.println("All books in the library");
		for(int i = 0; i < this.count; i++) {
			System.out.print(i + ". " + books[i].toString());
		}
	}
	
}
