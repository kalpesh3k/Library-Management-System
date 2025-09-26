import java.util.*;

public class LibraryManagementSystem {
    private List<Book> books;
    private Map<Integer, String> issuedBooks; // bookId -> issuedTo

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        issuedBooks = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (!book.isIssued()) {
                    books.remove(book);
                    System.out.println("Book removed.");
                } else {
                    System.out.println("Book is currently issued. Cannot remove.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void issueBook(int bookId, String issuedTo) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (!book.isIssued()) {
                    book.issueBook();
                    issuedBooks.put(bookId, issuedTo);
                    System.out.println("Book issued to " + issuedTo);
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                if (book.isIssued()) {
                    book.returnBook();
                    issuedBooks.remove(bookId);
                    System.out.println("Book returned.");
                } else {
                    System.out.println("Book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    public void showIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books are currently issued.");
        } else {
            for (Map.Entry<Integer, String> entry : issuedBooks.entrySet()) {
                System.out.println("Book ID: " + entry.getKey() + " issued to: " + entry.getValue());
            }
        }
    }
}
