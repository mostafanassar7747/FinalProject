package OtelRezervasyon;

	/**
	 * DeluxeRoom class extends Room class.
	 * Demonstrates inheritance - DeluxeRoom inherits from Room.
	 * Represents a deluxe hotel room with premium amenities.
	 */
	public class DeluxeRoom extends Room {
	    private boolean hasBalcony;
	    private boolean hasSeaView;
	    private boolean hasMiniBar;

	    /**
	     * Constructor for DeluxeRoom
	     * @param roomNumber Unique room number
	     * @param pricePerNight Price per night
	     * @param capacity Maximum number of guests
	     * @param hasBalcony Whether room has balcony
	     * @param hasSeaView Whether room has sea view
	     * @param hasMiniBar Whether room has mini bar
	     */
	    public DeluxeRoom(int roomNumber, double pricePerNight, int capacity,
	                     boolean hasBalcony, boolean hasSeaView, boolean hasMiniBar) {
	        super(roomNumber, "Deluxe", pricePerNight, capacity);
	        this.hasBalcony = hasBalcony;
	        this.hasSeaView = hasSeaView;
	        this.hasMiniBar = hasMiniBar;
	    }

	    /**
	     * Gets balcony availability
	     * @return true if room has balcony
	     */
	    public boolean isHasBalcony() {
	        return hasBalcony;
	    }

	    /**
	     * Sets balcony availability
	     * @param hasBalcony balcony availability
	     */
	    public void setHasBalcony(boolean hasBalcony) {
	        this.hasBalcony = hasBalcony;
	    }

	    /**
	     * Gets sea view availability
	     * @return true if room has sea view
	     */
	    public boolean isHasSeaView() {
	        return hasSeaView;
	    }

	    /**
	     * Sets sea view availability
	     * @param hasSeaView sea view availability
	     */
	    public void setHasSeaView(boolean hasSeaView) {
	        this.hasSeaView = hasSeaView;
	    }

	    /**
	     * Gets mini bar availability
	     * @return true if room has mini bar
	     */
	    public boolean isHasMiniBar() {
	        return hasMiniBar;
	    }

	    /**
	     * Sets mini bar availability
	     * @param hasMiniBar mini bar availability
	     */
	    public void setHasMiniBar(boolean hasMiniBar) {
	        this.hasMiniBar = hasMiniBar;
	    }

	    /**
	     * Overrides calculateTotalPrice to add premium amenity costs
	     * Demonstrates polymorphism - different calculation for deluxe rooms
	     * @param nights number of nights
	     * @return total price including premium amenities
	     */
	    @Override
	    public double calculateTotalPrice(int nights) {
	        double basePrice = super.calculateTotalPrice(nights);
	        double additionalCost = 0;
	        
	        if (hasSeaView) {
	            additionalCost += 200; // 200 TL per stay for sea view
	        }
	        if (hasMiniBar) {
	            additionalCost += nights * 100; // 100 TL per night for mini bar
	        }
	        
	        return basePrice + additionalCost;
	    }

	    /**
	     * Provides deluxe room information
	     * @return room details
	     */
	    @Override
	    public String toString() {
	        return "DeluxeRoom{" +
	                "roomNumber=" + getRoomNumber() +
	                ", pricePerNight=" + getPricePerNight() +
	                ", isAvailable=" + isAvailable() +
	                ", capacity=" + getCapacity() +
	                ", hasBalcony=" + hasBalcony +
	                ", hasSeaView=" + hasSeaView +
	                ", hasMiniBar=" + hasMiniBar +
	                '}';
	    }
	}