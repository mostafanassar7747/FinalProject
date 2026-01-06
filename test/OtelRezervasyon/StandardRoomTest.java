package OtelRezervasyon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for StandardRoom
 * Tests inheritance and polymorphic behavior
 */
class StandardRoomTest {
    
    private StandardRoom standardRoom;
    
    @BeforeEach
    void setUp() {
        standardRoom = new StandardRoom(101, 500.0, 2, true, true);
    }
    
    /**
     * Test StandardRoom creation and inheritance
     */
    @Test
    void testStandardRoomCreation() {
        assertEquals(101, standardRoom.getRoomNumber());
        assertEquals("Standard", standardRoom.getRoomType());
        assertEquals(500.0, standardRoom.getPricePerNight());
        assertEquals(2, standardRoom.getCapacity());
        assertTrue(standardRoom.isHasWifi());
        assertTrue(standardRoom.isHasBreakfast());
    }
    
    /**
     * Test polymorphic calculateTotalPrice with breakfast
     */
    @Test
    void testCalculateTotalPriceWithBreakfast() {
        // 3 nights * 500 = 1500 + (3 nights * 50 breakfast) = 1650
        assertEquals(1650.0, standardRoom.calculateTotalPrice(3));
    }
    
    /**
     * Test calculateTotalPrice without breakfast
     */
    @Test
    void testCalculateTotalPriceWithoutBreakfast() {
        StandardRoom roomNoBreakfast = new StandardRoom(102, 500.0, 2, true, false);
        // 3 nights * 500 = 1500 (no breakfast cost)
        assertEquals(1500.0, roomNoBreakfast.calculateTotalPrice(3));
    }
    
    /**
     * Test WiFi and breakfast setters
     */
    @Test
    void testAmenities() {
        standardRoom.setHasWifi(false);
        assertFalse(standardRoom.isHasWifi());
        
        standardRoom.setHasBreakfast(false);
        assertFalse(standardRoom.isHasBreakfast());
    }
    
    /**
     * Test that StandardRoom IS-A Room (inheritance)
     */
    @Test
    void testInheritance() {
        assertTrue(standardRoom instanceof Room);
        assertTrue(standardRoom instanceof StandardRoom);
    }
    
    /**
     * Test toString method
     */
    @Test
    void testToString() {
        String result = standardRoom.toString();
        assertTrue(result.contains("StandardRoom"));
        assertTrue(result.contains("101"));
        assertTrue(result.contains("hasWifi=true"));
        assertTrue(result.contains("hasBreakfast=true"));
    }
}
