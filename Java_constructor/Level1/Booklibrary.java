class Booklibrary {
    String title;
    String author;
    double price;
    boolean available;

    public Booklibrary(String title, String author, double price, boolean available) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = available;
    }

    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have successfully borrowed \"" + title + "\" by " + author);
        } else {
            System.out.println("Sorry, \"" + title + "\" is not available right now.");
        }
    }

    public void display() {
        System.out.println("Title: " + title + ", Author: " + author +
                           ", Price: " + price + ", Available: " + available);
    }

    public static void main(String[] args) {
        Booklibrary b1 = new Booklibrary("Java Programming", "James Gosling", 499.99, true);
        Booklibrary b2 = new Booklibrary("Effective Java", "Joshua Bloch", 699.50, false);

        System.out.println("Book Details:");
        b1.display();
        b2.display();

        System.out.println("\nBorrowing attempt:");
        b1.borrowBook();
        b2.borrowBook();

        System.out.println("\nUpdated Details:");
        b1.display();
        b2.display();
    }
}
