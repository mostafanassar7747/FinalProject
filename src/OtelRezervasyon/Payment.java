package OtelRezervasyon;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Payment class represents a payment transaction.
 * Demonstrates composition - Payment is part of Reservation.
 */
public class Payment {
    private String paymentId;
    private double amount;
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private boolean isPaid;

    /**
     * Constructor to create a Payment
     * @param paymentId Unique payment ID
     * @param amount Payment amount
     * @param paymentMethod Method of payment (Credit Card, Cash, etc.)
     */
    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentDate = LocalDateTime.now();
        this.isPaid = false;
    }

    /**
     * Gets payment ID
     * @return payment ID
     */
    public String getPaymentId() {
        return paymentId;
    }

    /**
     * Sets payment ID
     * @param paymentId payment ID to set
     */
    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * Gets payment amount
     * @return payment amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets payment amount
     * @param amount payment amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Gets payment method
     * @return payment method
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets payment method
     * @param paymentMethod payment method to set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets payment date
     * @return payment date
     */
    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    /**
     * Sets payment date
     * @param paymentDate payment date to set
     */
    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    /**
     * Checks if payment is completed
     * @return true if paid, false otherwise
     */
    public boolean isPaid() {
        return isPaid;
    }

    /**
     * Sets payment status
     * @param paid payment status
     */
    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    /**
     * Processes the payment
     * @return true if payment successful
     */
    public boolean processPayment() {
        if (!isPaid) {
            isPaid = true;
            paymentDate = LocalDateTime.now();
            System.out.println("Payment processed successfully!");
            return true;
        }
        System.out.println("Payment already processed!");
        return false;
    }

    /**
     * Generates payment receipt
     * @return receipt as string
     */
    public String generateReceipt() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return "=== PAYMENT RECEIPT ===" +
               "\nPayment ID: " + paymentId +
               "\nAmount: " + amount + " TL" +
               "\nPayment Method: " + paymentMethod +
               "\nPayment Date: " + paymentDate.format(formatter) +
               "\nStatus: " + (isPaid ? "PAID" : "PENDING") +
               "\n=======================";
    }

    /**
     * Provides payment information as string
     * @return payment details
     */
    @Override
    public String toString() {
        return "Payment{" +
                "paymentId='" + paymentId + '\'' +
                ", amount=" + amount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentDate=" + paymentDate +
                ", isPaid=" + isPaid +
                '}';
    }
}
