package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Booking {
    private Guest guest;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Booking(Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
        if (!checkOut.isAfter(checkIn)) {
            throw new IllegalArgumentException("Check-out must be after check-in");
        }
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }

    public long getNumberOfNights() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public double getTotalPrice() {
        return getNumberOfNights() * room.getPricePerNight();
    }
}