/**
 * @author Damodien Johnson
 * A class for the book catalog
 */
package assg6_johnsondam24;

import java.util.*;
import java.io.*;

public class BookCatalog implements BookCatalogInterface {
	ArrayList<Book> books = new ArrayList<>();
	
	/**
	 * Loads a requested file from the parameter.
	 * Uses try-catch to request file. Will send an exception message if error
	 */
	public void loadData(String filename) {
		try {
            Scanner file = new Scanner(new File(filename));

            while (file.hasNextLine()) {
                String isbn = file.nextLine();
                String title = file.nextLine();
                String author = file.nextLine();
                String publisher = file.nextLine();
                int year = Integer.parseInt(file.nextLine());

                Book b = new Book(isbn, title, author, publisher, year);
                books.add(b);

                if (file.hasNextLine()) {
                    file.nextLine();
                }
            }

            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
	}
	
	/**
	 * This methods utilizes the list of books and adds it 
	 */
    public void displayCatalog() {
        for (Book b : books) {
            System.out.println(b);
            System.out.println();
        }
    }
	
	/**
	 * This method uses the array list to search for a book that the user 
	 * @Param givenTitle - The given title
	 * @return the book if found, null if not
	 */
	public Book searchForBook(String givenTitle) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(givenTitle)) {
                return b;
            }
        }
        return null;
    }
	
	/**
	 * This method that creates a new book object with given parameters
	 * @Param isbn - The given isbn
	 * @Param title - The given title
	 * @Param author - The given author
	 * @Param publisher - The given publisher
	 * @Param year - The given year
	 * @return true when the book is created/will return false otherwise
	 */
	public boolean addBook(String isbn, String title, String author, String publisher, int year) {
	    for (Book b : books) {
	        if (b.getTitle().equalsIgnoreCase(title)) {
	            System.out.println("The book already exists.");
	            return false;
	        }
	    }

	    Book b = new Book(isbn, title, author, publisher, year);
	    books.add(b);
	    return true;
	}

	/**
	 * This method takes the given info about a book and uses set methods to change the information
	 * @return true if method works; false otherwise
	 */
	public boolean updateBook(String isbn, String title, String author, String publisher, int year) {
		 for (Book b : books) {
		        if (b.getTitle().equalsIgnoreCase(title)) {
		            b.setIsbn(isbn);
		            b.setAuthor(author);
		            b.setPublisher(publisher);
		            b.setYear(year);
		            return true;
		        }
		    }
		    System.out.println("Book does not exist.");
		    return false;
	}
	
	/**
	 * This method utilizes the tools of array lists to remove a book object from the list
	 * @Param - The given title to remove
	 * @return true if the method works; false otherwise
	 */
	public boolean removeBook(String givenTitle) {
		for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(givenTitle)) {
                books.remove(b);
                return true;
            }
        }
        return false;
	}
	
	/**
	 * This method uses the requested publisher name and outputs all the books with the same name publisher
	 * @Param - The given publisher
	 * @return - the arrayList
	 */
	public ArrayList<Book> getBooksByPublisher(String givenPublisher) {
		ArrayList<Book> publisherBooks = new ArrayList<>();

        for (Book b : books) {
            if (b.getPublisher().equalsIgnoreCase(givenPublisher)) {
                publisherBooks.add(b);
            }
        }

        return publisherBooks;
	}
	
	/**
	 * This method utilizes compareTo() to sort the book titles
	 */
	public void sortByTitle() {
		 Collections.sort(books);

	        String result = "";
	        for (Book b : books) {
	            result += b + "\n\n";
	        }
	}
	
	/**
	 * This method will use PrintWriter to write to the same file
	 * The method will use a for loop and the array list of the book objects 
	 * to complete the job.
	 */
	public void save() {
		try {
            PrintWriter writer = new PrintWriter("assg6_catalog.txt");

            for (Book b : books) {
                writer.println(b.getIsbn());
                writer.println(b.getTitle());
                writer.println(b.getAuthor());
                writer.println(b.getPublisher());
                writer.println(b.getYear());
                writer.println();
            }

            writer.close();
        } catch (Exception e) {
            System.out.println("Error saving file.");
        }
    }

}
