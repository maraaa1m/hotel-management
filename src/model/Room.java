package model;

public class Room {
    private int number;
    private int floor;
    private double pricePerNight;
    private boolean available;
    private RoomType type;

    public Room(int number, int floor, double pricePerNight, RoomType type) {
        this.number = number;
        this.floor = floor;
        this.pricePerNight = pricePerNight;
        this.type = type;
        this.available = true;
    }

    public int getNumber() { return number; }
    public int getFloor() { return floor; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return available; }
    public RoomType getType() { return type; }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}