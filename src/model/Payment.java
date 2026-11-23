package model;

public class Payment {
    private Booking booking;
    private double amount;
    private String method;
    private PaymentStatus status;

    public Payment(Booking booking, String method) {
        this.booking = booking;
        this.amount = booking.getTotalPrice();
        this.method = method;
        this.status = PaymentStatus.PENDING;
    }

    public Booking getBooking() { return booking; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public PaymentStatus getStatus() { return status; }

    public void markAsPaid() {
        this.status = PaymentStatus.PAID;
    }
}