/**
 * @author Damodien Johnson
 * A class for the book object class
 */
package assg6_johnsondam24;

public class Book implements Comparable<Book>{

    String isbn;
    String title;
    String author;
    String publisher;
    int year;

    public Book(String isbn, String title, String author, String publisher, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }
    /**
     * Retrieves the isbn
     * @return - The isbn
     */
    public String getIsbn() {
        return isbn;
    }
    
    /**
     * Retrieves the title
     * @return - The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Retrieves the author
     * @return - The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Retrieves the publisher
     * @return - The publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Retrieves the year
     * @return - The year
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Modify the isbn
     * @param isbn - The given isbn
     */
    public void setIsbn(String isbn) {
    	this.isbn = isbn;
    }
    
    /**
     * Modify the author
     * @param author - The given author
     */
    public void setAuthor(String author) {
    	this.author = author;
    }
    
    /**
     * Modify the publisher
     * @param publisher - The given publisher
     */
    public void setPublisher(String publisher) {
    	this.publisher = publisher;
    }
    
    /**
     * Modify the year
     * @param year - The given year
     */
    public void setYear(int year) {
    	this.year = year;
    }
    
    /**
     * Compares a requested book to a given book to see if it has the same title
     * @param givenBook - The given book to compare
     * @return True if equal, false if not
     */
    public boolean equals(Book givenBook) {
    	return this.title.equals(givenBook.getTitle());
    }
    

    @Override
    public String toString() {
        return "ISBN: " + isbn +
               "\nTitle: " + title +
               "\nAuthor: " + author +
               "\nPublisher: " + publisher +
               "\nYear: " + year;
    }
    
    @Override
    public int compareTo(Book givenBook) {
    	return this.title.compareTo(givenBook.title);
    }
}