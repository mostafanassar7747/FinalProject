package OtelRezervasyon;

/**
 * Searchable interface defines search capabilities.
 * Demonstrates interface concept in OOP.
 * Classes implementing this interface must provide search functionality.
 */
public interface Searchable {
    /**
     * Searches for available rooms based on capacity
     * @param capacity minimum capacity required
     * @return array of available rooms
     */
    Room[] searchAvailableRooms(int capacity);
    
    /**
     * Searches for rooms by type
     * @param roomType type of room to search for
     * @return array of rooms matching the type
     */
    Room[] searchByRoomType(String roomType);
    
    /**
     * Searches for a room by room number
     * @param roomNumber room number to search for
     * @return Room object if found, null otherwise
     */
    Room searchByRoomNumber(int roomNumber);
}