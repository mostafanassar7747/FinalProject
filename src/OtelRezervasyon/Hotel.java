package OtelRezervasyon;

import java.util.ArrayList;
import java.util.List;

/**
 * Hotel class manages rooms and reservations.
 * Demonstrates interface implementation and uses arrays to store rooms.
 * This is the main management class for the hotel system.
 */
public class Hotel implements Searchable {
    private String hotelName;
    private String address;
    private Room[] rooms;
    private List<Reservation> reservations;
    private int roomCount;

    /**
     * Constructor to create a Hotel
     * @param hotelName Name of the hotel
     * @param address Hotel address
     * @param maxRooms Maximum number of rooms
     */
    public Hotel(String hotelName, String address, int maxRooms) {
        this.hotelName = hotelName;
        this.address = address;
        this.rooms = new Room[maxRooms];
        this.reservations = new ArrayList<>();
        this.roomCount = 0;
    }

    /**
     * Adds a room to the hotel
     * @param room Room to add
     * @return true if added successfully
     */
    public boolean addRoom(Room room) {
        if (roomCount < rooms.length) {
            rooms[roomCount] = room;
            roomCount++;
            System.out.println("Room " + room.getRoomNumber() + " added successfully!");
            return true;
        }
        System.out.println("Hotel is full. Cannot add more rooms.");
        return false;
    }

    /**
     * Creates a new reservation
     * @param reservation Reservation to create
     * @return true if reservation created successfully
     */
    public boolean createReservation(Reservation reservation) {
        Room room = reservation.getRoom();
        
        if (!room.isAvailable()) {
            System.out.println("Room " + room.getRoomNumber() + " is not available!");
            return false;
        }
        
        if (reservation.getNumberOfGuests() > room.getCapacity()) {
            System.out.println("Number of guests exceeds room capacity!");
            return false;
        }
        
        reservations.add(reservation);
        reservation.confirmReservation();
        System.out.println("Reservation created successfully!");
        System.out.println(reservation);
        return true;
    }

    /**
     * Cancels a reservation by ID
     * @param reservationId Reservation ID to cancel
     * @return true if cancelled successfully
     */
    public boolean cancelReservation(String reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId().equals(reservationId)) {
                reservation.cancelReservation();
                return true;
            }
        }
        System.out.println("Reservation not found!");
        return false;
    }

    /**
     * Shows payment information for a reservation
     * @param reservationId Reservation ID
     */
    public void showPayment(String reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId().equals(reservationId)) {
                System.out.println("\n" + reservation.getPayment().generateReceipt());
                return;
            }
        }
        System.out.println("Reservation not found!");
    }

    /**
     * Implementation of Searchable interface
     * Searches for available rooms with minimum capacity
     * @param capacity Minimum capacity required
     * @return Array of available rooms
     */
    @Override
    public Room[] searchAvailableRooms(int capacity) {
        List<Room> availableRooms = new ArrayList<>();
        
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].isAvailable() && rooms[i].getCapacity() >= capacity) {
                availableRooms.add(rooms[i]);
            }
        }
        
        return availableRooms.toArray(new Room[0]);
    }

    /**
     * Implementation of Searchable interface
     * Searches for rooms by type
     * @param roomType Type of room
     * @return Array of rooms matching the type
     */
    @Override
    public Room[] searchByRoomType(String roomType) {
        List<Room> matchingRooms = new ArrayList<>();
        
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getRoomType().equalsIgnoreCase(roomType)) {
                matchingRooms.add(rooms[i]);
            }
        }
        
        return matchingRooms.toArray(new Room[0]);
    }

    /**
     * Implementation of Searchable interface
     * Searches for a room by room number
     * @param roomNumber Room number to search
     * @return Room if found, null otherwise
     */
    @Override
    public Room searchByRoomNumber(int roomNumber) {
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].getRoomNumber() == roomNumber) {
                return rooms[i];
            }
        }
        return null;
    }

    /**
     * Shows all available rooms
     */
    public void showAvailableRooms() {
        System.out.println("\n=== AVAILABLE ROOMS ===");
        boolean hasAvailableRooms = false;
        
        for (int i = 0; i < roomCount; i++) {
            if (rooms[i].isAvailable()) {
                System.out.println(rooms[i]);
                hasAvailableRooms = true;
            }
        }
        
        if (!hasAvailableRooms) {
            System.out.println("No rooms available.");
        }
    }

    /**
     * Shows all rooms in the hotel
     */
    public void showAllRooms() {
        System.out.println("\n=== ALL ROOMS ===");
        for (int i = 0; i < roomCount; i++) {
            System.out.println(rooms[i]);
        }
    }

    /**
     * Shows all reservations
     */
    public void showAllReservations() {
        System.out.println("\n=== ALL RESERVATIONS ===");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

    /**
     * Gets hotel name
     * @return hotel name
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Sets hotel name
     * @param hotelName hotel name to set
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Gets hotel address
     * @return hotel address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets hotel address
     * @param address hotel address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets all rooms
     * @return array of rooms
     */
    public Room[] getRooms() {
        return rooms;
    }

    /**
     * Gets all reservations
     * @return list of reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Gets room count
     * @return number of rooms
     */
    public int getRoomCount() {
        return roomCount;
    }

    /**
     * Provides hotel information as string
     * @return hotel details
     */
    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", address='" + address + '\'' +
                ", totalRooms=" + roomCount +
                ", totalReservations=" + reservations.size() +
                '}';
    }
}