class HotelBooking {
    String guestName;
    String roomType;
    int nights;

    public HotelBooking() {
        this.guestName = "";
        this.roomType = "";
        this.nights = 0;
    }

    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    public void display() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType + ", Nights: " + nights);
    }

    public static void main(String[] args) {
        HotelBooking b1 = new HotelBooking();
        HotelBooking b2 = new HotelBooking("John Doe", "Deluxe", 3);
        HotelBooking b3 = new HotelBooking(b2);

        System.out.println("Default Booking:");
        b1.display();

        System.out.println("Parameterized Booking:");
        b2.display();

        System.out.println("Copy Booking:");
        b3.display();
    }
}
