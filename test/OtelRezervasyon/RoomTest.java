package OtelRezervasyon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for Room
 * Tests the basic functionality of the Room class
 */
class RoomTest {
    
    private Room room;
    
    /**
     * Set up test data before each test
     */
    @BeforeEach
    void setUp() {
        room = new Room(101, "Standard", 500.0, 2);
    }
    
    /**
     * Test room constructor and getters
     */
    @Test
    void testRoomCreation() {
        assertEquals(101, room.getRoomNumber());
        assertEquals("Standard", room.getRoomType());
        assertEquals(500.0, room.getPricePerNight());
        assertEquals(2, room.getCapacity());
        assertTrue(room.isAvailable());
    }
    
    /**
     * Test calculateTotalPrice method
     */
    @Test
    void testCalculateTotalPrice() {
        assertEquals(1500.0, room.calculateTotalPrice(3));
        assertEquals(2500.0, room.calculateTotalPrice(5));
        assertEquals(500.0, room.calculateTotalPrice(1));
    }
    
    /**
     * Test setters
     */
    @Test
    void testSetters() {
        room.setRoomNumber(102);
        assertEquals(102, room.getRoomNumber());
        
        room.setPricePerNight(600.0);
        assertEquals(600.0, room.getPricePerNight());
        
        room.setAvailable(false);
        assertFalse(room.isAvailable());
        
        room.setCapacity(4);
        assertEquals(4, room.getCapacity());
    }
    
    /**
     * Test availability toggle
     */
    @Test
    void testAvailability() {
        assertTrue(room.isAvailable());
        
        room.setAvailable(false);
        assertFalse(room.isAvailable());
        
        room.setAvailable(true);
        assertTrue(room.isAvailable());
    }
    
    /**
     * Test toString method
     */
    @Test
    void testToString() {
        String expected = "Room{roomNumber=101, roomType='Standard', pricePerNight=500.0, isAvailable=true, capacity=2}";
        assertEquals(expected, room.toString());
    }
}