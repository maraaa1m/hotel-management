package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Worker> workers = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }

    public List<Worker> getWorkers() {
        return Collections.unmodifiableList(workers);
    }

    public List<Booking> getBookings() {
        return Collections.unmodifiableList(bookings);
    }

    public boolean isRoomFree(Room room, LocalDate checkIn, LocalDate checkOut) {
        for (Booking booking : bookings) {
            if (booking.getRoom() == room
                    && checkIn.isBefore(booking.getCheckOut())
                    && checkOut.isAfter(booking.getCheckIn())) {
                return false;
            }
        }
        return true;
    }

    public List<Room> getAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        List<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            if (isRoomFree(room, checkIn, checkOut)) {
                result.add(room);
            }
        }
        return result;
    }

    public Booking bookRoom(Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
        if (!isRoomFree(room, checkIn, checkOut)) {
            throw new IllegalStateException("Room " + room.getNumber() + " is not free on these dates");
        }
        Booking booking = new Booking(guest, room, checkIn, checkOut);
        bookings.add(booking);
        return booking;
    }
}