package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Worker extends Person {
    private List<Shift> shifts = new ArrayList<>();

    public Worker(String name, String contact) {
        super(name, contact);
    }

    public void addShift(Shift shift) {
        shifts.add(shift);
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public boolean isOnShift(LocalDateTime moment) {
        for (Shift shift : shifts) {
            if (shift.covers(moment)) {
                return true;
            }
        }
        return false;
    }
}