package assg6_johnsondam24;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class bookTest {

    private BookCatalog catalog;

    @BeforeEach
    public void setUp() {
        catalog = new BookCatalog();

        catalog.addBook("0132122306", "Data Abstraction & Problem Solving with Java",
                "J. Prichard and F. Carrano", "Addison Wesley", 2011);

        catalog.addBook("1400030032", "My Life",
                "Bill Clinton", "Vintage", 2005);

        catalog.addBook("0822212099", "A View From the Bridge",
                "Arthur Miller", "Dramatists Play", 1998);
    }

    @Test
    public void testAddBook() {
        boolean added = catalog.addBook("1260084507", "Database System Concepts",
                "Abraham Silberschatz", "McGraw Hill", 2019);

        assertTrue(added);

        Book found = catalog.searchForBook("Database System Concepts");
        assertNotNull(found);
        assertEquals("1260084507", found.getIsbn());
    }

    @Test
    public void testAddDuplicateBook() {
        boolean added = catalog.addBook("9999999999", "My Life",
                "Someone Else", "Fake Publisher", 2024);

        assertFalse(added);
    }

    @Test
    public void testSearchForBookFound() {
        Book found = catalog.searchForBook("My Life");

        assertNotNull(found);
        assertEquals("Bill Clinton", found.getAuthor());
    }

    @Test
    public void testSearchForBookNotFound() {
        Book found = catalog.searchForBook("Nonexistent Book");

        assertNull(found);
    }

    @Test
    public void testRemoveBook() {
        boolean removed = catalog.removeBook("My Life");

        assertTrue(removed);
        assertNull(catalog.searchForBook("My Life"));
    }

    @Test
    public void testRemoveBookNotFound() {
        boolean removed = catalog.removeBook("Fake Book");

        assertFalse(removed);
    }

    @Test
    public void testGetBooksByPublisher() {
        ArrayList<Book> books = catalog.getBooksByPublisher("Vintage");

        assertEquals(1, books.size());
        assertEquals("My Life", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByPublisherNoMatch() {
        ArrayList<Book> books = catalog.getBooksByPublisher("No Publisher");

        assertEquals(0, books.size());
    }

    @Test
    public void testSortByTitle() {
        catalog.sortByTitle();

        Book first = catalog.searchForBook("A View From the Bridge");
        Book second = catalog.searchForBook("Data Abstraction & Problem Solving with Java");
        Book third = catalog.searchForBook("My Life");

        assertNotNull(first);
        assertNotNull(second);
        assertNotNull(third);
    }

    @Test
    public void testUpdateBook() {
        boolean updated = catalog.updateBook("1400030032", "My Life",
                "Updated Author", "Updated Publisher", 2020);

        assertTrue(updated);

        Book found = catalog.searchForBook("My Life");
        assertNotNull(found);
        assertEquals("Updated Author", found.getAuthor());
        assertEquals("Updated Publisher", found.getPublisher());
        assertEquals(2020, found.getYear());
    }
}