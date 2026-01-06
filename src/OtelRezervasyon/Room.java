package OtelRezervasyon;

/**
 * Room class represents a hotel room with basic properties.
 * This is the base class for all room types.
 * Demonstrates encapsulation with private fields and public getters/setters.
 */
public class Room {
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean isAvailable;
    private int capacity;

    /**
     * Constructor to initialize a Room object
     * @param roomNumber Unique room number
     * @param roomType Type of the room (Standard, Deluxe, etc.)
     * @param pricePerNight Price per night for the room
     * @param capacity Maximum number of guests
     */
    public Room(int roomNumber, String roomType, double pricePerNight, int capacity) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.isAvailable = true; // By default, room is available
    }

    // Getters and Setters (Encapsulation)

    /**
     * Gets the room number
     * @return room number
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Sets the room number
     * @param roomNumber room number to set
     */
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Gets the room type
     * @return room type
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets the room type
     * @param roomType room type to set
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * Gets the price per night
     * @return price per night
     */
    public double getPricePerNight() {
        return pricePerNight;
    }

    /**
     * Sets the price per night
     * @param pricePerNight price to set
     */
    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    /**
     * Checks if room is available
     * @return true if available, false otherwise
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Sets the availability status
     * @param available availability status
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    /**
     * Gets the room capacity
     * @return maximum number of guests
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets the room capacity
     * @param capacity maximum number of guests
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Calculates total price for given number of nights
     * @param nights number of nights
     * @return total price
     */
    public double calculateTotalPrice(int nights) {
        return pricePerNight * nights;
    }

    /**
     * Provides room information as a string
     * @return room details
     */
    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", roomType='" + roomType + '\'' +
                ", pricePerNight=" + pricePerNight +
                ", isAvailable=" + isAvailable +
                ", capacity=" + capacity +
                '}';
    }
}
