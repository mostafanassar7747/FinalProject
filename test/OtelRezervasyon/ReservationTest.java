package OtelRezervasyon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

/**
 * JUnit test class for Reservation
 * Tests reservation management and composition
 */
class ReservationTest {
    
    private Reservation reservation;
    private Customer customer;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    
    @BeforeEach
    void setUp() {
        customer = new Customer("C001", "Ahmet Yılmaz", 
                               "ahmet@email.com", "555-1234", "Istanbul");
        room = new Room(101, "Standard", 500.0, 2);
        checkIn = LocalDate.of(2026, 2, 1);
        checkOut = LocalDate.of(2026, 2, 5);
        reservation = new Reservation("RES001", customer, room, checkIn, checkOut, 2);
    }
    
    /**
     * Test reservation creation and composition
     */
    @Test
    void testReservationCreation() {
        assertEquals("RES001", reservation.getReservationId());
        assertEquals(customer, reservation.getCustomer());
        assertEquals(room, reservation.getRoom());
        assertEquals(checkIn, reservation.getCheckInDate());
        assertEquals(checkOut, reservation.getCheckOutDate());
        assertEquals(2, reservation.getNumberOfGuests());
        assertTrue(reservation.isActive());
        assertNotNull(reservation.getPayment());
    }
    
    /**
     * Test composition - reservation HAS-A payment
     */
    @Test
    void testCompositionWithPayment() {
        Payment payment = reservation.getPayment();
        assertNotNull(payment);
        assertEquals("PAY-RES001", payment.getPaymentId());
        assertEquals(2000.0, payment.getAmount()); // 4 nights * 500
    }
    
    /**
     * Test number of nights calculation
     */
    @Test
    void testGetNumberOfNights() {
        assertEquals(4, reservation.getNumberOfNights());
    }
    
    /**
     * Test total cost calculation
     */
    @Test
    void testCalculateTotalCost() {
        assertEquals(2000.0, reservation.calculateTotalCost()); // 4 nights * 500
    }
    
    /**
     * Test reservation confirmation
     */
    @Test
    void testConfirmReservation() {
        assertTrue(room.isAvailable());
        reservation.confirmReservation();
        assertFalse(room.isAvailable());
    }
    
    /**
     * Test reservation cancellation
     */
    @Test
    void testCancelReservation() {
        reservation.confirmReservation();
        assertFalse(room.isAvailable());
        
        reservation.cancelReservation();
        assertFalse(reservation.isActive());
        assertTrue(room.isAvailable());
    }
    
    /**
     * Test cannot confirm if guests exceed capacity
     */
    @Test
    void testConfirmWithExcessGuests() {
        Reservation bigReservation = new Reservation("RES002", customer, room, 
                                                     checkIn, checkOut, 5);
        bigReservation.confirmReservation();
        // Room capacity is 2, but 5 guests - should not confirm
        assertTrue(room.isAvailable()); // Room should still be available
    }
    
    /**
     * Test reservation setters
     */
    @Test
    void testReservationSetters() {
        LocalDate newCheckIn = LocalDate.of(2026, 3, 1);
        reservation.setCheckInDate(newCheckIn);
        assertEquals(newCheckIn, reservation.getCheckInDate());
        
        reservation.setNumberOfGuests(1);
        assertEquals(1, reservation.getNumberOfGuests());
        
        reservation.setActive(false);
        assertFalse(reservation.isActive());
    }
    
    /**
     * Test toString method
     */
    @Test
    void testToString() {
        String result = reservation.toString();
        assertTrue(result.contains("Reservation"));
        assertTrue(result.contains("RES001"));
        assertTrue(result.contains("Ahmet Yılmaz"));
        assertTrue(result.contains("101"));
    }
}
