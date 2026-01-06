package OtelRezervasyon;

/**
 * Customer class represents a hotel customer.
 * Demonstrates encapsulation with private fields and public methods.
 */
public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    /**
     * Constructor to create a Customer
     * @param customerId Unique customer ID
     * @param name Customer name
     * @param email Customer email
     * @param phoneNumber Customer phone number
     * @param address Customer address
     */
    public Customer(String customerId, String name, String email, 
                   String phoneNumber, String address) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    /**
     * Gets customer ID
     * @return customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets customer ID
     * @param customerId customer ID to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets customer name
     * @return customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets customer name
     * @param name customer name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets customer email
     * @return customer email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets customer email
     * @param email customer email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets customer phone number
     * @return customer phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets customer phone number
     * @param phoneNumber customer phone number to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets customer address
     * @return customer address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets customer address
     * @param address customer address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Provides customer information as string
     * @return customer details
     */
    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
