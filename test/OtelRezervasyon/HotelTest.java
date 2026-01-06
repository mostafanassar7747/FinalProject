package OtelRezervasyon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * JUnit test class for Hotel
 * Tests interface implementation, array usage, and main features
 */
class HotelTest {
    
    private Hotel hotel;
    private Room room101;
    private Room room102;
    private StandardRoom room103;
    private DeluxeRoom room201;
    private Customer customer;
    
    @BeforeEach
    void setUp() {
        hotel = new Hotel("Grand Istanbul Hotel", "Taksim, Istanbul", 10);
        
        room101 = new Room(101, "Standard", 500.0, 2);
        room102 = new Room(102, "Standard", 500.0, 2);
        room103 = new StandardRoom(103, 600.0, 3, true, true);
        room201 = new DeluxeRoom(201, 1000.0, 2, true, true, true);
        
        hotel.addRoom(room101);
        hotel.addRoom(room102);
        hotel.addRoom(room103);
        hotel.addRoom(room201);
        
        customer = new Customer("C001", "Ahmet Yılmaz", 
                               "ahmet@email.com", "555-1234", "Istanbul");
    }
    
    /**
     * Test hotel creation
     */
    @Test
    void testHotelCreation() {
        assertEquals("Grand Istanbul Hotel", hotel.getHotelName());
        assertEquals("Taksim, Istanbul", hotel.getAddress());
        assertEquals(4, hotel.getRoomCount());
    }
    
    /**
     * Test adding rooms (array usage)
     */
    @Test
    void testAddRoom() {
        Room newRoom = new Room(105, "Standard", 500.0, 2);
        assertTrue(hotel.addRoom(newRoom));
        assertEquals(5, hotel.getRoomCount());
    }
    
    /**
     * Test adding room when hotel is full
     */
    @Test
    void testAddRoomWhenFull() {
        Hotel smallHotel = new Hotel("Small Hotel", "Test", 2);
        Room r1 = new Room(101, "Standard", 500.0, 2);
        Room r2 = new Room(102, "Standard", 500.0, 2);
        Room r3 = new Room(103, "Standard", 500.0, 2);
        
        assertTrue(smallHotel.addRoom(r1));
        assertTrue(smallHotel.addRoom(r2));
        assertFalse(smallHotel.addRoom(r3)); // Hotel is full
    }
    
    /**
     * Test searchAvailableRooms (interface implementation)
     */
    @Test
    void testSearchAvailableRooms() {
        Room[] available = hotel.searchAvailableRooms(2);
        assertEquals(4, available.length); // All rooms available
        
        // Book one room
        room101.setAvailable(false);
        available = hotel.searchAvailableRooms(2);
        assertEquals(3, available.length);
    }
    
    /**
     * Test searchAvailableRooms by capacity
     */
    @Test
    void testSearchAvailableRoomsByCapacity() {
        Room[] available = hotel.searchAvailableRooms(3);
        assertEquals(1, available.length); // Only room103 has capacity 3
        assertEquals(103, available[0].getRoomNumber());
    }
    
    /**
     * Test searchByRoomType (interface implementation)
     */
    @Test
    void testSearchByRoomType() {
        Room[] standardRooms = hotel.searchByRoomType("Standard");
        assertEquals(3, standardRooms.length);
        
        Room[] deluxeRooms = hotel.searchByRoomType("Deluxe");
        assertEquals(1, deluxeRooms.length);
        assertEquals(201, deluxeRooms[0].getRoomNumber());
    }
    
    /**
     * Test searchByRoomNumber (interface implementation)
     */
    @Test
    void testSearchByRoomNumber() {
        Room found = hotel.searchByRoomNumber(101);
        assertNotNull(found);
        assertEquals(101, found.getRoomNumber());
        
        Room notFound = hotel.searchByRoomNumber(999);
        assertNull(notFound);
    }
    
    /**
     * Test createReservation (minimum feature)
     */
    @Test
    void testCreateReservation() {
        LocalDate checkIn = LocalDate.of(2026, 2, 1);
        LocalDate checkOut = LocalDate.of(2026, 2, 5);
        Reservation reservation = new Reservation("RES001", customer, room101, 
                                                  checkIn, checkOut, 2);
        
        assertTrue(hotel.createReservation(reservation));
        assertEquals(1, hotel.getReservations().size());
        assertFalse(room101.isAvailable());
    }
    
    /**
     * Test createReservation with unavailable room
     */
    @Test
    void testCreateReservationWithUnavailableRoom() {
        room101.setAvailable(false);
        
        LocalDate checkIn = LocalDate.of(2026, 2, 1);
        LocalDate checkOut = LocalDate.of(2026, 2, 5);
        Reservation reservation = new Reservation("RES001", customer, room101, 
                                                  checkIn, checkOut, 2);
        
        assertFalse(hotel.createReservation(reservation));
        assertEquals(0, hotel.getReservations().size());
    }
    
    /**
     * Test createReservation exceeding capacity
     */
    @Test
    void testCreateReservationExceedingCapacity() {
        LocalDate checkIn = LocalDate.of(2026, 2, 1);
        LocalDate checkOut = LocalDate.of(2026, 2, 5);
        Reservation reservation = new Reservation("RES001", customer, room101, 
                                                  checkIn, checkOut, 5); // Capacity is 2
        
        assertFalse(hotel.createReservation(reservation));
    }
    
    /**
     * Test cancelReservation (minimum feature)
     */
    @Test
    void testCancelReservation() {
        LocalDate checkIn = LocalDate.of(2026, 2, 1);
        LocalDate checkOut = LocalDate.of(2026, 2, 5);
        Reservation reservation = new Reservation("RES001", customer, room101, 
                                                  checkIn, checkOut, 2);
        
        hotel.createReservation(reservation);
        assertFalse(room101.isAvailable());
        
        assertTrue(hotel.cancelReservation("RES001"));
        assertTrue(room101.isAvailable());
    }
    
    /**
     * Test cancelReservation with invalid ID
     */
    @Test
    void testCancelReservationInvalid() {
        assertFalse(hotel.cancelReservation("INVALID"));
    }
    
    /**
     * Test that Hotel implements Searchable interface
     */
    @Test
    void testImplementsSearchable() {
        assertTrue(hotel instanceof Searchable);
    }
    
    /**
     * Test multiple reservations
     */
    @Test
    void testMultipleReservations() {
        LocalDate checkIn1 = LocalDate.of(2026, 2, 1);
        LocalDate checkOut1 = LocalDate.of(2026, 2, 5);
        Reservation res1 = new Reservation("RES001", customer, room101, 
                                           checkIn1, checkOut1, 2);
        
        Customer customer2 = new Customer("C002", "Ayşe Demir", 
                                         "ayse@email.com", "555-5678", "Ankara");
        LocalDate checkIn2 = LocalDate.of(2026, 3, 1);
        LocalDate checkOut2 = LocalDate.of(2026, 3, 5);
        Reservation res2 = new Reservation("RES002", customer2, room102, 
                                           checkIn2, checkOut2, 2);
        
        assertTrue(hotel.createReservation(res1));
        assertTrue(hotel.createReservation(res2));
        assertEquals(2, hotel.getReservations().size());
    }
    
    /**
     * Test hotel toString
     */
    @Test
    void testToString() {
        String result = hotel.toString();
        assertTrue(result.contains("Hotel"));
        assertTrue(result.contains("Grand Istanbul Hotel"));
        assertTrue(result.contains("totalRooms=4"));
    }
}
