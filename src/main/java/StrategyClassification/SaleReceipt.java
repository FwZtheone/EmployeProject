package StrategyClassification;

import java.util.Calendar;

public class SaleReceipt {

    public Calendar date;
    public double saleAmount;



    public SaleReceipt(Calendar date , double saleAmount)
    {
        this.date = date;
        this.saleAmount = saleAmount;
    }
}
