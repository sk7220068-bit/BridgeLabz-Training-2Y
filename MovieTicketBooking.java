import java.util.*;

class InvalidSeatException extends Exception {
    public InvalidSeatException(String message) {
        super(message);
    }
}

class SeatAlreadyBookedException extends Exception {
    public SeatAlreadyBookedException(String message) {
        super(message);
    }
}

class MovieBookingSystem {
    private Map<Integer, Boolean> seats = new HashMap<>();

    public MovieBookingSystem() {
        for (int i = 1; i <= 10; i++) {
            seats.put(i, false);
        }
    }

    public void bookSeat(int seatNumber) throws InvalidSeatException, SeatAlreadyBookedException {
        if (!seats.containsKey(seatNumber)) {
            throw new InvalidSeatException("Invalid seat number! Please choose between 1 and 10.");
        }
        if (seats.get(seatNumber)) {
            throw new SeatAlreadyBookedException("Seat " + seatNumber + " is already booked. Please choose another seat.");
        }
        seats.put(seatNumber, true);
        System.out.println("Seat " + seatNumber + " successfully booked!");
    }

    public void showSeats() {
        System.out.println("\nCurrent Seat Status:");
        for (Map.Entry<Integer, Boolean> entry : seats.entrySet()) {
            String status = entry.getValue() ? "Booked" : "Available";
            System.out.println("Seat " + entry.getKey() + ": " + status);
        }
    }
}

public class MovieTicketBooking {
    public static void main(String[] args) {
        MovieBookingSystem booking = new MovieBookingSystem();

        try {
            booking.bookSeat(3);
            booking.bookSeat(3);
        } catch (InvalidSeatException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SeatAlreadyBookedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            booking.bookSeat(12);
        } catch (InvalidSeatException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (SeatAlreadyBookedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        booking.showSeats();
    }
}
