import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("ID: " + bookId + ", Title: " + title + ", Author: " + author);
    }
}

public class Main {
    static Book[] books = {
        new Book(1, "Java Basics", "John"),
        new Book(2, "Python 101", "Alice"),
        new Book(3, "Data Structures", "Bob"),
        new Book(4, "os", "nick")
        
        
    };

    public static void linearSearch(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                book.display();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void binarySearch(String title) {
        Arrays.sort(books, Comparator.comparing(b -> b.title));
        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) {
                books[mid].display();
                return;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        System.out.println("Linear Search:");
        linearSearch("Python 101");

        System.out.println("\nBinary Search:");
        binarySearch("Data Structures");
    }
}
