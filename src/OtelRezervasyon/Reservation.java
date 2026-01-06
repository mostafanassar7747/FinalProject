package OtelRezervasyon;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Reservation class represents a hotel room reservation.
 * Demonstrates composition - Reservation contains Customer, Room, and Payment objects.
 * This shows the HAS-A relationship in OOP.
 */
public class Reservation {
    private String reservationId;
    private Customer customer;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int numberOfGuests;
    private Payment payment;
    private boolean isActive;

    /**
     * Constructor to create a Reservation
     * @param reservationId Unique reservation ID
     * @param customer Customer making the reservation
     * @param room Room being reserved
     * @param checkInDate Check-in date
     * @param checkOutDate Check-out date
     * @param numberOfGuests Number of guests
     */
    public Reservation(String reservationId, Customer customer, Room room,
                      LocalDate checkInDate, LocalDate checkOutDate, int numberOfGuests) {
        this.reservationId = reservationId;
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.numberOfGuests = numberOfGuests;
        this.isActive = true;
        
        // Create payment object based on room price and number of nights
        int nights = (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
        double totalAmount = room.calculateTotalPrice(nights);
        this.payment = new Payment("PAY-" + reservationId, totalAmount, "Pending");
    }

    /**
     * Gets reservation ID
     * @return reservation ID
     */
    public String getReservationId() {
        return reservationId;
    }

    /**
     * Sets reservation ID
     * @param reservationId reservation ID to set
     */
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    /**
     * Gets customer
     * @return customer object
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Sets customer
     * @param customer customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Gets room
     * @return room object
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets room
     * @param room room to set
     */
    public void setRoom(Room room) {
        this.room = room;
    }

    /**
     * Gets check-in date
     * @return check-in date
     */
    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    /**
     * Sets check-in date
     * @param checkInDate check-in date to set
     */
    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * Gets check-out date
     * @return check-out date
     */
    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Sets check-out date
     * @param checkOutDate check-out date to set
     */
    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    /**
     * Gets number of guests
     * @return number of guests
     */
    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    /**
     * Sets number of guests
     * @param numberOfGuests number of guests to set
     */
    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    /**
     * Gets payment
     * @return payment object
     */
    public Payment getPayment() {
        return payment;
    }

    /**
     * Sets payment
     * @param payment payment to set
     */
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    /**
     * Checks if reservation is active
     * @return true if active, false otherwise
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Sets reservation active status
     * @param active active status
     */
    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Calculates number of nights
     * @return number of nights
     */
    public int getNumberOfNights() {
        return (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    /**
     * Calculates total cost of reservation
     * @return total cost
     */
    public double calculateTotalCost() {
        return room.calculateTotalPrice(getNumberOfNights());
    }

    /**
     * Cancels the reservation
     */
    public void cancelReservation() {
        if (isActive) {
            isActive = false;
            room.setAvailable(true);
            System.out.println("Reservation " + reservationId + " has been cancelled.");
        } else {
            System.out.println("Reservation is already cancelled.");
        }
    }

    /**
     * Confirms the reservation and marks room as unavailable
     */
    public void confirmReservation() {
        if (isActive && numberOfGuests <= room.getCapacity()) {
            room.setAvailable(false);
            System.out.println("Reservation " + reservationId + " confirmed!");
        } else {
            System.out.println("Cannot confirm reservation. Check capacity or status.");
        }
    }

    /**
     * Provides reservation information as string
     * @return reservation details
     */
    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", customer=" + customer.getName() +
                ", room=" + room.getRoomNumber() +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numberOfGuests=" + numberOfGuests +
                ", totalCost=" + calculateTotalCost() +
                ", isActive=" + isActive +
                '}';
    }
}