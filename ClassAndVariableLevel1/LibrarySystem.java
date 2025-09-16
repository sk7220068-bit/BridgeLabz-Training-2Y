class Book {
    static String libraryName = "Central Library";
    private final String isbn;
    private String title;
    private String author;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Library: " + libraryName);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("Java Programming", "James Gosling", "ISBN101");
        Book b2 = new Book("Effective Java", "Joshua Bloch", "ISBN102");

        b1.displayDetails();
        System.out.println();
        b2.displayDetails();

        Book.displayLibraryName();
    }
}
