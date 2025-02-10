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
		if(this.count < getBooks().length) {
			for(int i = 0; i < getBooks().length; i++) {
				if(this.books[i] == null) {
					this.books[i] = book;
					this.count++;
					return true;
				}
			}
			
		}
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
		for(int i =0; i < getBooks().length; i++) {
			if(getBooks()[i].equals(book)) {
				this.books[i] = null;
				this.count--;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Searches for book by ISBN
	 * @param ISBN
	 * This is the ISBN string the method will look for
	 * @return
	 * returns the book with the matching ISBN, else returns null
	 */
	public Book searchByISBN(String ISBN) {
		for(int i = 0; i< getBooks().length; i++) {
			if(this.books[i].getISBN()==ISBN) {
				return this.books[i];
			}
		}
		return null;
	}
	
	/**
	 * Prints all book information in library
	 */
	public void displayBooks() {
		for(int i = 0; i < getBooks().length; i++) {
			System.out.print(this.books[i].toString());
		}
	}
	
}
