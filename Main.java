import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

abstract class Room {
    protected int roomNumber;
    protected boolean isBooked;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void bookRoom() {
        this.isBooked = true;
    }

    public void checkoutRoom() {
        this.isBooked = false;
    }

    public abstract double calculatePrice();
    public abstract String getRoomType();
}

class StandardRoom extends Room {
    public StandardRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public double calculatePrice() {
        return 4500;
    }

    @Override
    public String getRoomType() {
        return "Standard Room";
    }
}

class DeluxeRoom extends Room {
    public DeluxeRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public double calculatePrice() {
        return 8000;
    }

    @Override
    public String getRoomType() {
        return "Deluxe Room";
    }
}

class SuiteRoom extends Room {
    public SuiteRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    public double calculatePrice() {
        return 12000;
    }

    @Override
    public String getRoomType() {
        return "Suite Room";
    }
}

class Customer {
    private String name;
    private String cnic;
    private int days;

    public Customer(String name, String cnic, int days) {
        this.name = name;
        this.cnic = cnic;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public String getCnic() {
        return cnic;
    }

    public int getDays() {
        return days;
    }
}

class BookingManager {

    public void saveBooking(Customer customer, Room room) {
        try {
            FileWriter fw = new FileWriter("bookings.txt", true);
            fw.write("Customer: " + customer.getName() +
                    ", CNIC: " + customer.getCnic() +
                    ", Room: " + room.getRoomType() +
                    ", Room No: " + room.getRoomNumber() +
                    ", Days: " + customer.getDays() +
                    ", Total Price: " + (customer.getDays() * room.calculatePrice()) +
                    "\n");
            fw.close();
            System.out.println("Booking saved to file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookingManager manager = new BookingManager();

        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new StandardRoom(101));
        rooms.add(new StandardRoom(102));
        rooms.add(new DeluxeRoom(211));
        rooms.add(new DeluxeRoom(212));
        rooms.add(new SuiteRoom(301));

        int choice;

        do {
            System.out.println("\n==== HOTEL RESERVATION SYSTEM ====");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Rooms:");
                    for (Room r : rooms) {
                        if (!r.isBooked()) {
                            System.out.println("Room No: " + r.getRoomNumber() + " - " + r.getRoomType());
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNo = sc.nextInt();

                    boolean found = false;
                    for (Room r : rooms) {
                        if (r.getRoomNumber() == roomNo && !r.isBooked()) {
                            sc.nextLine();
                            System.out.print("Enter customer name: ");
                            String name = sc.nextLine();
                            System.out.print("Enter CNIC: ");
                            String cnic = sc.nextLine();
                            System.out.print("Enter number of days: ");
                            int days = sc.nextInt();

                            Customer customer = new Customer(name, cnic, days);

                            r.bookRoom();
                            manager.saveBooking(customer, r);

                            System.out.println("Room booked successfully!");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println("Room not available or already booked!");
                    break;

                case 3:
                    System.out.print("Enter room number to checkout: ");
                    int checkoutNo = sc.nextInt();

                    boolean checkoutFound = false;

                    for (Room r : rooms) {
                        if (r.getRoomNumber() == checkoutNo && r.isBooked()) {
                            r.checkoutRoom();
                            System.out.println("Checkout successful!");
                            checkoutFound = true;
                            break;
                        }
                    }
                    if (!checkoutFound) System.out.println("Room not found or not booked!");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);
    }
}