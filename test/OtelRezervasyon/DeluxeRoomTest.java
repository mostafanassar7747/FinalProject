package OtelRezervasyon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for DeluxeRoom
 * Tests inheritance and polymorphic pricing behavior
 */
class DeluxeRoomTest {
    
    private DeluxeRoom deluxeRoom;
    
    @BeforeEach
    void setUp() {
        deluxeRoom = new DeluxeRoom(201, 1000.0, 2, true, true, true);
    }
    
    /**
     * Test DeluxeRoom creation and inheritance
     */
    @Test
    void testDeluxeRoomCreation() {
        assertEquals(201, deluxeRoom.getRoomNumber());
        assertEquals("Deluxe", deluxeRoom.getRoomType());
        assertEquals(1000.0, deluxeRoom.getPricePerNight());
        assertEquals(2, deluxeRoom.getCapacity());
        assertTrue(deluxeRoom.isHasBalcony());
        assertTrue(deluxeRoom.isHasSeaView());
        assertTrue(deluxeRoom.isHasMiniBar());
    }
    
    /**
     * Test polymorphic calculateTotalPrice with all amenities
     */
    @Test
    void testCalculateTotalPriceWithAllAmenities() {
        // 3 nights * 1000 = 3000
        // + 200 for sea view
        // + (3 nights * 100 mini bar) = 300
        // Total = 3500
        assertEquals(3500.0, deluxeRoom.calculateTotalPrice(3));
    }
    
    /**
     * Test calculateTotalPrice with only sea view
     */
    @Test
    void testCalculateTotalPriceWithSeaViewOnly() {
        DeluxeRoom room = new DeluxeRoom(202, 1000.0, 2, true, true, false);
        // 3 nights * 1000 = 3000 + 200 sea view = 3200
        assertEquals(3200.0, room.calculateTotalPrice(3));
    }
    
    /**
     * Test calculateTotalPrice with only mini bar
     */
    @Test
    void testCalculateTotalPriceWithMiniBarOnly() {
        DeluxeRoom room = new DeluxeRoom(203, 1000.0, 2, true, false, true);
        // 3 nights * 1000 = 3000 + (3 * 100 mini bar) = 3300
        assertEquals(3300.0, room.calculateTotalPrice(3));
    }
    
    /**
     * Test calculateTotalPrice with no premium amenities
     */
    @Test
    void testCalculateTotalPriceNoAmenities() {
        DeluxeRoom room = new DeluxeRoom(204, 1000.0, 2, true, false, false);
        // 3 nights * 1000 = 3000 (no additional costs)
        assertEquals(3000.0, room.calculateTotalPrice(3));
    }
    
    /**
     * Test amenity setters
     */
    @Test
    void testAmenitySetters() {
        deluxeRoom.setHasBalcony(false);
        assertFalse(deluxeRoom.isHasBalcony());
        
        deluxeRoom.setHasSeaView(false);
        assertFalse(deluxeRoom.isHasSeaView());
        
        deluxeRoom.setHasMiniBar(false);
        assertFalse(deluxeRoom.isHasMiniBar());
    }
    
    /**
     * Test that DeluxeRoom IS-A Room (inheritance)
     */
    @Test
    void testInheritance() {
        assertTrue(deluxeRoom instanceof Room);
        assertTrue(deluxeRoom instanceof DeluxeRoom);
    }
    
    /**
     * Test polymorphism - DeluxeRoom and StandardRoom have different pricing
     */
    @Test
    void testPolymorphism() {
        Room standardRoom = new StandardRoom(101, 500.0, 2, true, true);
        Room deluxeRoomAsRoom = new DeluxeRoom(201, 1000.0, 2, true, true, true);
        
        // Same number of nights, different prices due to polymorphism
        assertNotEquals(standardRoom.calculateTotalPrice(3), 
                       deluxeRoomAsRoom.calculateTotalPrice(3));
    }
    
    /**
     * Test toString method
     */
    @Test
    void testToString() {
        String result = deluxeRoom.toString();
        assertTrue(result.contains("DeluxeRoom"));
        assertTrue(result.contains("201"));
        assertTrue(result.contains("hasBalcony=true"));
        assertTrue(result.contains("hasSeaView=true"));
        assertTrue(result.contains("hasMiniBar=true"));
    }
}