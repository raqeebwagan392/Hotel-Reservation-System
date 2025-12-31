# Hotel-Reservation-System
Java-based hotel reservation system that manages room booking, availability, pricing, and checkout using OOP concepts and file handling.


Features:

Room Management: Supports three types of rooms—Standard, Deluxe, and Suite—each with different pricing.

Booking System: Allows users to book rooms by entering customer details (name, CNIC, number of days).

Checkout System: Allows users to checkout of rooms and update the room status.

Persistence: Booking details are saved to a bookings.txt file for record-keeping.

Error Handling: Includes checks for available rooms and prevents double booking.


Technologies Used:

Java: Core programming language for developing the system.

Object-Oriented Programming: Utilizes concepts like inheritance, polymorphism, and encapsulation.

File Handling: Stores booking information in a text file (bookings.txt).

Data Structures: Uses ArrayList to manage rooms and track availability.


How It Works:

Show Available Rooms: Displays the list of rooms that are not currently booked.

Book Room: Users can book an available room by providing customer details.

Checkout: Users can checkout from the system, freeing up the room for new bookings.

Exit: Exit the application.


Room Pricing:

Standard Room: ₹4500 per day

Deluxe Room: ₹8000 per day

Suite Room: ₹12000 per day


How to Run the Project:


Clone the repository:

git clone https://github.com/yourusername/Hotel-Reservation-System.git


Navigate to the project directory:

cd Hotel-Reservation-System


Compile the Java file:

javac Main.java


Run the application:

java Main


Sample Interaction:
==== HOTEL RESERVATION SYSTEM ====
1. Show Available Rooms
2. Book Room
3. Checkout
4. Exit
Enter choice: 1

Available Rooms:
Room No: 101 - Standard Room
Room No: 102 - Standard Room
Room No: 211 - Deluxe Room
Room No: 301 - Suite Room

Enter choice: 2
Enter room number to book: 101
Enter customer name: John Doe
Enter CNIC: 12345-1234567-1
Enter number of days: 3
Room booked successfully!

Enter choice: 4
Exiting...
