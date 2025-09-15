class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean booked;

    MovieTicket(String movieName) {
        this.movieName = movieName;
        this.booked = false;
    }

    void bookTicket(String seatNumber, double price) {
        if (!booked) {
            this.seatNumber = seatNumber;
            this.price = price;
            this.booked = true;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Ticket already booked for seat " + this.seatNumber);
        }
    }

    void displayTicket() {
        if (booked) {
            System.out.println("Movie Name : " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price      : " + price);
            System.out.println("-----------------------------");
        } else {
            System.out.println("No ticket booked yet for movie: " + movieName);
        }
    }
}

public class MovieTickets {
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Avengers: Endgame");
        MovieTicket ticket2 = new MovieTicket("Inception");

        ticket1.displayTicket();
        ticket1.bookTicket("A10", 300);
        ticket1.displayTicket();

        ticket2.bookTicket("B5", 250);
        ticket2.displayTicket();

        // Trying to book again for same ticket
        ticket1.bookTicket("A15", 350);
    }
}
