package heh.be.global.StrategyClassification;

import java.util.Calendar;

public class TimeCard  {

    private Calendar date;
    private double hours;


    public TimeCard(Calendar date, double hours){
        this.date = date;
        this.hours = hours;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
}
