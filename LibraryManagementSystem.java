import java.util.*;

class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class InvalidReturnException extends Exception {
    public InvalidReturnException(String message) {
        super(message);
    }
}

class UserLimitExceededException extends Exception {
    public UserLimitExceededException(String message) {
        super(message);
    }
}

class Library {
    private Map<String, Boolean> books = new HashMap<>();
    private Map<String, List<String>> userRecords = new HashMap<>();

    public Library() {
        books.put("Java Programming", true);
        books.put("Python Basics", true);
        books.put("Data Structures", true);
        books.put("Operating Systems", true);
        books.put("Computer Networks", true);
    }

    public void borrowBook(String user, String book)
            throws BookNotAvailableException, UserLimitExceededException {
        if (!books.containsKey(book) || !books.get(book)) {
            throw new BookNotAvailableException("Sorry, the book \"" + book + "\" is not available right now.");
        }

        List<String> borrowedBooks = userRecords.getOrDefault(user, new ArrayList<>());

        if (borrowedBooks.size() >= 5) {
            throw new UserLimitExceededException("User limit exceeded! " + user + " cannot borrow more than 5 books.");
        }

        borrowedBooks.add(book);
        userRecords.put(user, borrowedBooks);
        books.put(book, false);
        System.out.println(user + " successfully borrowed \"" + book + "\".");
    }

    public void returnBook(String user, String book) throws InvalidReturnException {
        List<String> borrowedBooks = userRecords.get(user);

        if (borrowedBooks == null || !borrowedBooks.contains(book)) {
            throw new InvalidReturnException("Invalid return! \"" + book + "\" was not borrowed by " + user + ".");
        }

        borrowedBooks.remove(book);
        books.put(book, true);
        System.out.println(user + " successfully returned \"" + book + "\".");
    }

    public void showUserRecords() {
        System.out.println("\n--- User Borrow Records ---");
        for (Map.Entry<String, List<String>> entry : userRecords.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        try {
            library.borrowBook("Amit", "Java Programming");
            library.borrowBook("Amit", "Python Basics");
            library.borrowBook("Amit", "Data Structures");
            library.borrowBook("Amit", "Operating Systems");
            library.borrowBook("Amit", "Computer Networks");
            library.borrowBook("Amit", "Some Extra Book"); 
        } catch (BookNotAvailableException | UserLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            library.returnBook("Amit", "Java Programming");
            library.returnBook("Amit", "C++ Guide"); 
        } catch (InvalidReturnException e) {
            System.out.println("Error: " + e.getMessage());
        }

        library.showUserRecords();
    }
}
