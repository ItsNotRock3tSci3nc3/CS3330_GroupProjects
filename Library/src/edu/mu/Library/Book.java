package edu.mu.Library;

public class Book {
	private String title;
	private String author;
	private String ISBN;
	private double price;
	
	/**
	 * This is the default constructor
	 * initializes title, author, and ISBN to "Unknown"
	 * initializes price to 0
	 */
	public Book() {
		this.title = "Unknown";
		this.author = "Unknown";
		this.ISBN = "Unknown";
		this.price = 0;
	}
	
	/**
	 * This is a parameterized constructor
	 * @param title
	 * This argument is the title of the book
	 * @param author
	 * This argument is the author of the book
	 * @param ISBN
	 * This argument is the ISBN of the book
	 * @param price
	 * This argument is the price of the book
	 */
	public Book(String title, String author, String ISBN, double price) {
		this.title = title;
		this.author = author;
		this.ISBN = ISBN;
		this.price = price;
	}
	
	/**
	 * This is a copy constructor, creates new book from another book object
	 * @param book
	 * Takes an object Book as an argument and copies to make new book object
	 */
	public Book(Book book) {
		this.title = book.getTitle();
		this.author = book.getAuthor();
		this.ISBN = book.getISBN();
		this.price = book.getPrice();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean equals(Object other) {
		if(this.ISBN == ((Book) other).getISBN()) {
			return true;
		}
		return false;
	}
	

	@Override
	public String toString() {
		return "Title = " + this.getTitle() + "\nAuthor = " + this.getAuthor() + "\nISBN = " + this.getISBN() + "\nPrice = " + this.getISBN();
	}
	
	
}
