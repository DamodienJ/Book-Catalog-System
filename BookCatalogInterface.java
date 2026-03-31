/**
 * @author Damodien Johnson
 * A class for the book catalog interface
 */
package assg6_johnsondam24;

import java.util.ArrayList;

public interface BookCatalogInterface {
	
	public void loadData(String filename);
	
	public void displayCatalog();
	
	public Book searchForBook(String givenTitle);
	
	public boolean addBook(String isbn, String title, String author, String publisher, int year);

	public boolean updateBook(String isbn, String title, String author, String publisher, int year);
	
	public boolean removeBook(String givenTitle);
	
	public ArrayList<Book> getBooksByPublisher(String givenPublisher);
	
	public void sortByTitle();
	
	public void save();
}
