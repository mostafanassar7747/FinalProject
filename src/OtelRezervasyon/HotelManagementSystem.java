package OtelRezervasyon;

public class HotelManagementSystem {

	public static void main(String[] args) {
		import java.time.LocalDate;

		/**
		 * Main class to demonstrate the Hotel Reservation System.
		 * This class shows all the OOP concepts and features.
		 */
		public class HotelManagementSystem {
		    
		    public static void main(String[] args) {
		        System.out.println("╔════════════════════════════════════════════╗");
		        System.out.println("║   HOTEL RESERVATION SYSTEM - DEMO         ║");
		        System.out.println("╚════════════════════════════════════════════╝\n");
		        
		        // Create Hotel
		        Hotel hotel = new Hotel("Grand Istanbul Hotel", "Taksim, Istanbul", 10);
		        System.out.println("Hotel created: " + hotel.getHotelName());
		        System.out.println("Location: " + hotel.getAddress());
		        System.out.println("═══════════════════════════════════════════════\n");
		        
		        // Add Standard Rooms
		        System.out.println("Adding Standard Rooms...");
		        StandardRoom room101 = new StandardRoom(101, 500.0, 2, true, true);
		        StandardRoom room102 = new StandardRoom(102, 500.0, 2, true, false);
		        StandardRoom room103 = new StandardRoom(103, 600.0, 3, true, true);
		        
		        hotel.addRoom(room101);
		        hotel.addRoom(room102);
		        hotel.addRoom(room103);
		        
		        // Add Deluxe Rooms
		        System.out.println("\nAdding Deluxe Rooms...");
		        DeluxeRoom room201 = new DeluxeRoom(201, 1000.0, 2, true, true, true);
		        DeluxeRoom room202 = new DeluxeRoom(202, 900.0, 2, true, false, true);
		        DeluxeRoom room203 = new DeluxeRoom(203, 1200.0, 4, true, true, true);
		        
		        hotel.addRoom(room201);
		        hotel.addRoom(room202);
		        hotel.addRoom(room203);
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // Show all rooms
		        hotel.showAllRooms();
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // Create Customers
		        System.out.println("\nCreating Customers...");
		        Customer customer1 = new Customer("C001", "Ahmet Yılmaz", 
		                                         "ahmet@email.com", "555-1234", "Istanbul");
		        Customer customer2 = new Customer("C002", "Ayşe Demir", 
		                                         "ayse@email.com", "555-5678", "Ankara");
		        Customer customer3 = new Customer("C003", "Mehmet Kaya", 
		                                         "mehmet@email.com", "555-9012", "Izmir");
		        
		        System.out.println("✓ Customer 1: " + customer1.getName());
		        System.out.println("✓ Customer 2: " + customer2.getName());
		        System.out.println("✓ Customer 3: " + customer3.getName());
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // FEATURE 1: Room Search (Oda Arama)
		        System.out.println("\n【 FEATURE 1: ROOM SEARCH 】");
		        System.out.println("Searching for available rooms with capacity for 2 guests...");
		        Room[] availableRooms = hotel.searchAvailableRooms(2);
		        System.out.println("Found " + availableRooms.length + " available rooms:");
		        for (Room room : availableRooms) {
		            System.out.println("  → " + room);
		        }
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // FEATURE 2: Create Reservations (Rezervasyon Oluşturma)
		        System.out.println("\n【 FEATURE 2: CREATE RESERVATIONS 】");
		        
		        LocalDate checkIn1 = LocalDate.of(2026, 2, 1);
		        LocalDate checkOut1 = LocalDate.of(2026, 2, 5);
		        Reservation reservation1 = new Reservation("RES001", customer1, room101, 
		                                                   checkIn1, checkOut1, 2);
		        hotel.createReservation(reservation1);
		        
		        LocalDate checkIn2 = LocalDate.of(2026, 2, 10);
		        LocalDate checkOut2 = LocalDate.of(2026, 2, 15);
		        Reservation reservation2 = new Reservation("RES002", customer2, room201, 
		                                                   checkIn2, checkOut2, 2);
		        hotel.createReservation(reservation2);
		        
		        LocalDate checkIn3 = LocalDate.of(2026, 3, 1);
		        LocalDate checkOut3 = LocalDate.of(2026, 3, 7);
		        Reservation reservation3 = new Reservation("RES003", customer3, room203, 
		                                                   checkIn3, checkOut3, 4);
		        hotel.createReservation(reservation3);
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // Show all reservations
		        hotel.showAllReservations();
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // FEATURE 3: Show Payment (Ödeme Gösterme)
		        System.out.println("\n【 FEATURE 3: SHOW PAYMENT 】");
		        hotel.showPayment("RES001");
		        hotel.showPayment("RES002");
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // Process a payment
		        System.out.println("\n【 PROCESSING PAYMENT 】");
		        System.out.println("Processing payment for Reservation RES001...");
		        reservation1.getPayment().setPaymentMethod("Credit Card");
		        reservation1.getPayment().processPayment();
		        hotel.showPayment("RES001");
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // FEATURE 4: Cancel Reservation (Rezervasyon İptali)
		        System.out.println("\n【 FEATURE 4: CANCEL RESERVATION 】");
		        System.out.println("Cancelling Reservation RES003...");
		        hotel.cancelReservation("RES003");
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // Show available rooms after cancellation
		        System.out.println("\n【 AVAILABLE ROOMS AFTER CANCELLATION 】");
		        hotel.showAvailableRooms();
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // Search by room type
		        System.out.println("\n【 SEARCH BY ROOM TYPE 】");
		        System.out.println("Searching for Deluxe rooms...");
		        Room[] deluxeRooms = hotel.searchByRoomType("Deluxe");
		        System.out.println("Found " + deluxeRooms.length + " Deluxe rooms:");
		        for (Room room : deluxeRooms) {
		            System.out.println("  → Room " + room.getRoomNumber() + 
		                             " (Available: " + room.isAvailable() + ")");
		        }
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // Search by room number
		        System.out.println("\n【 SEARCH BY ROOM NUMBER 】");
		        Room foundRoom = hotel.searchByRoomNumber(201);
		        if (foundRoom != null) {
		            System.out.println("Room found: " + foundRoom);
		        }
		        
		        System.out.println("\n═══════════════════════════════════════════════");
		        
		        // Demonstrate polymorphism
		        System.out.println("\n【 POLYMORPHISM DEMONSTRATION 】");
		        System.out.println("Calculating prices for 3 nights:");
		        
		        Room[] testRooms = {room101, room201};
		        for (Room room : testRooms) {
		            System.out.println("Room " + room.getRoomNumber() + 
		                             " (" + room.getRoomType() + "): " + 
		                             room.calculateTotalPrice(3) + " TL");
		        }
		        
		        System.out.println("\n╔════════════════════════════════════════════╗");
		        System.out.println("║          DEMO COMPLETED SUCCESSFULLY       ║");
		        System.out.println("╚════════════════════════════════════════════╝");
		    }
		}

	}

}
