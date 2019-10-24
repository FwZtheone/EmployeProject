package StrategyClassification;

import java.util.Calendar;

public class SaleReceipt {

    private Calendar date;
    private double saleAmount;

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public void setSaleAmount(double saleAmount) {
        this.saleAmount = saleAmount;
    }

    public double getSaleAmount() {
        return saleAmount;
    }

    public SaleReceipt(Calendar date , double saleAmount)
    {
        this.date = date;
        this.saleAmount = saleAmount;
    }
}
