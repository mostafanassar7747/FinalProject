package OtelRezervasyon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for Payment
 * Tests payment processing and receipt generation
 */
class PaymentTest {
    
    private Payment payment;
    
    @BeforeEach
    void setUp() {
        payment = new Payment("PAY001", 2000.0, "Credit Card");
    }
    
    /**
     * Test payment creation
     */
    @Test
    void testPaymentCreation() {
        assertEquals("PAY001", payment.getPaymentId());
        assertEquals(2000.0, payment.getAmount());
        assertEquals("Credit Card", payment.getPaymentMethod());
        assertFalse(payment.isPaid());
        assertNotNull(payment.getPaymentDate());
    }
    
    /**
     * Test payment processing
     */
    @Test
    void testProcessPayment() {
        assertFalse(payment.isPaid());
        
        boolean result = payment.processPayment();
        assertTrue(result);
        assertTrue(payment.isPaid());
        
        // Try processing again - should return false
        boolean secondAttempt = payment.processPayment();
        assertFalse(secondAttempt);
    }
    
    /**
     * Test payment setters
     */
    @Test
    void testPaymentSetters() {
        payment.setAmount(3000.0);
        assertEquals(3000.0, payment.getAmount());
        
        payment.setPaymentMethod("Cash");
        assertEquals("Cash", payment.getPaymentMethod());
        
        payment.setPaid(true);
        assertTrue(payment.isPaid());
    }
    
    /**
     * Test receipt generation
     */
    @Test
    void testGenerateReceipt() {
        String receipt = payment.generateReceipt();
        assertNotNull(receipt);
        assertTrue(receipt.contains("PAYMENT RECEIPT"));
        assertTrue(receipt.contains("PAY001"));
        assertTrue(receipt.contains("2000.0"));
        assertTrue(receipt.contains("Credit Card"));
        assertTrue(receipt.contains("PENDING"));
    }
    
    /**
     * Test receipt after payment
     */
    @Test
    void testReceiptAfterPayment() {
        payment.processPayment();
        String receipt = payment.generateReceipt();
        assertTrue(receipt.contains("PAID"));
    }
    
    /**
     * Test toString method
     */
    @Test
    void testToString() {
        String result = payment.toString();
        assertTrue(result.contains("Payment"));
        assertTrue(result.contains("PAY001"));
        assertTrue(result.contains("2000.0"));
    }
}
