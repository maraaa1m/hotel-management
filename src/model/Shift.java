package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Shift {
    private Worker worker;
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endTime;

    public Shift(Worker worker, LocalDate day, LocalTime startTime, LocalTime endTime) {
        this.worker = worker;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Worker getWorker() { return worker; }
    public LocalDate getDay() { return day; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }

    public boolean covers(LocalDateTime moment) {
        if (!moment.toLocalDate().equals(day)) {
            return false;
        }
        LocalTime time = moment.toLocalTime();
        return !time.isBefore(startTime) && time.isBefore(endTime);
    }
}