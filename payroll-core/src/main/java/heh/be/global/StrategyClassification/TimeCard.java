package heh.be.global.StrategyClassification;

import java.time.LocalDate;
import java.util.Calendar;

public class TimeCard  {

    private LocalDate date;
    private double hours;


    public TimeCard(LocalDate date, double hours){
        this.date = date;
        this.hours = hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
}
