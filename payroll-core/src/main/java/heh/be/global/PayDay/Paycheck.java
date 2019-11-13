package heh.be.global.PayDay;

import java.time.LocalDate;

public class Paycheck {

    private double salary;
    private String typeSalary;
    private LocalDate date;


    public Paycheck(LocalDate date){
        this.date = date;

    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDisposition(String typeSalary) {
        this.typeSalary = typeSalary;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getSalary() {
        return salary;
    }

    public String getTypeSalary(String s ) {
        return typeSalary;
    }

    public LocalDate getDate() {
        return date;
    }
}
