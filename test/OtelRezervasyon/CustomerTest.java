package OtelRezervasyon;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit test class for Customer
 * Tests customer data management
 */
class CustomerTest {
    
    private Customer customer;
    
    @BeforeEach
    void setUp() {
        customer = new Customer("C001", "Ahmet Yılmaz", 
                               "ahmet@email.com", "555-1234", "Istanbul");
    }
    
    /**
     * Test customer creation
     */
    @Test
    void testCustomerCreation() {
        assertEquals("C001", customer.getCustomerId());
        assertEquals("Ahmet Yılmaz", customer.getName());
        assertEquals("ahmet@email.com", customer.getEmail());
        assertEquals("555-1234", customer.getPhoneNumber());
        assertEquals("Istanbul", customer.getAddress());
    }
    
    /**
     * Test customer setters
     */
    @Test
    void testCustomerSetters() {
        customer.setName("Mehmet Demir");
        assertEquals("Mehmet Demir", customer.getName());
        
        customer.setEmail("mehmet@email.com");
        assertEquals("mehmet@email.com", customer.getEmail());
        
        customer.setPhoneNumber("555-9999");
        assertEquals("555-9999", customer.getPhoneNumber());
        
        customer.setAddress("Ankara");
        assertEquals("Ankara", customer.getAddress());
    }
    
    /**
     * Test toString method
     */
    @Test
    void testToString() {
        String result = customer.toString();
        assertTrue(result.contains("Customer"));
        assertTrue(result.contains("C001"));
        assertTrue(result.contains("Ahmet Yılmaz"));
        assertTrue(result.contains("ahmet@email.com"));
    }
}