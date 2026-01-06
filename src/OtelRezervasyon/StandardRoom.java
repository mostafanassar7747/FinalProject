package OtelRezervasyon;

/**
 * StandardRoom class extends Room class.
 * Demonstrates inheritance - StandardRoom inherits from Room.
 * Represents a standard hotel room with basic amenities.
 */
public class StandardRoom extends Room {
    private boolean hasWifi;
    private boolean hasBreakfast;

    /**
     * Constructor for StandardRoom
     * @param roomNumber Unique room number
     * @param pricePerNight Price per night
     * @param capacity Maximum number of guests
     * @param hasWifi Whether room has WiFi
     * @param hasBreakfast Whether breakfast is included
     */
    public StandardRoom(int roomNumber, double pricePerNight, int capacity, 
                       boolean hasWifi, boolean hasBreakfast) {
        super(roomNumber, "Standard", pricePerNight, capacity);
        this.hasWifi = hasWifi;
        this.hasBreakfast = hasBreakfast;
    }

    /**
     * Gets WiFi availability
     * @return true if WiFi is available
     */
    public boolean isHasWifi() {
        return hasWifi;
    }

    /**
     * Sets WiFi availability
     * @param hasWifi WiFi availability
     */
    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    /**
     * Gets breakfast inclusion
     * @return true if breakfast is included
     */
    public boolean isHasBreakfast() {
        return hasBreakfast;
    }

    /**
     * Sets breakfast inclusion
     * @param hasBreakfast breakfast inclusion
     */
    public void setHasBreakfast(boolean hasBreakfast) {
        this.hasBreakfast = hasBreakfast;
    }

    /**
     * Overrides calculateTotalPrice to add breakfast cost if included
     * Demonstrates polymorphism - method overriding
     * @param nights number of nights
     * @return total price including breakfast if applicable
     */
    @Override
    public double calculateTotalPrice(int nights) {
        double basePrice = super.calculateTotalPrice(nights);
        if (hasBreakfast) {
            return basePrice + (nights * 50); // 50 TL per night for breakfast
        }
        return basePrice;
    }

    /**
     * Provides standard room information
     * @return room details
     */
    @Override
    public String toString() {
        return "StandardRoom{" +
                "roomNumber=" + getRoomNumber() +
                ", pricePerNight=" + getPricePerNight() +
                ", isAvailable=" + isAvailable() +
                ", capacity=" + getCapacity() +
                ", hasWifi=" + hasWifi +
                ", hasBreakfast=" + hasBreakfast +
                '}';
    }
}