/**
 * @author Damodien Johnson
 * A class for the main method of the library application
 */
package assg6_johnsondam24;

import java.util.Scanner;

public class LibraryApplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BookCatalog catalog = new BookCatalog();

        catalog.loadData("assg6_catalog.txt");

        int choice = -1;

        while (choice != 9) {
            System.out.println("1. Display all books");
            System.out.println("2. Search for a book");
            System.out.println("3. Add a new book");
            System.out.println("4. Update a book");
            System.out.println("5. Remove a book");
            System.out.println("6. Display books by publisher");
            System.out.println("7. Sort books by title");
            System.out.println("8. Save data");
            System.out.println("9. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    catalog.displayCatalog();
                    break;

                case 2:
                    System.out.print("Enter title: ");
                    String searchTitle = input.nextLine();
                    catalog.searchForBook(searchTitle);
                    break;

                case 3:
                    System.out.print("ISBN: ");
                    String isbn = input.nextLine();
                    System.out.print("Title: ");
                    String title = input.nextLine();
                    System.out.print("Author: ");
                    String author = input.nextLine();
                    System.out.print("Publisher: ");
                    String publisher = input.nextLine();
                    System.out.print("Year: ");
                    int year = input.nextInt();
                    input.nextLine();

                    catalog.addBook(isbn, title, author, publisher, year);
                    break;

                case 4:
                    System.out.print("Enter title to update: ");
                    String updateTitle = input.nextLine();

                    System.out.print("New ISBN: ");
                    String newIsbn = input.nextLine();
                    System.out.print("New Author: ");
                    String newAuthor = input.nextLine();
                    System.out.print("New Publisher: ");
                    String newPublisher = input.nextLine();
                    System.out.print("New Year: ");
                    int newYear = input.nextInt();
                    input.nextLine();

                    catalog.updateBook(newIsbn, updateTitle, newAuthor, newPublisher, newYear);
                    break;

                case 5:
                    System.out.print("Enter title to remove: ");
                    String removeTitle = input.nextLine();
                    catalog.removeBook(removeTitle);
                    break;

                case 6:
                    System.out.print("Enter publisher: ");
                    String pub = input.nextLine();
                    System.out.println(catalog.getBooksByPublisher(pub));
                    break;

                case 7:
                    catalog.sortByTitle();
                    break;

                case 8:
                    catalog.save();
                    System.out.println("Data saved.");
                    break;

                case 9:
                    catalog.save();
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

            if (choice != 9) {
                System.out.println("\nPress Enter to continue...");
                input.nextLine();
            }
        }

        input.close();
    }
}
