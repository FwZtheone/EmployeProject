package StrategyClassification;

import java.util.Calendar;
import java.util.HashMap;

public class CommissionClassification implements PayementClassification {
    private double salary;
    private double commission;
    private double commissionTotal;
    private HashMap<Calendar,SaleReceipt> listeSaleReceipt;


    @Override
    public double calculationSalary() {
        return salary + commissionTotal;
    }

    public void addSaleReceipt(SaleReceipt saleReceipt)
    {
        listeSaleReceipt.put(saleReceipt.date,new SaleReceipt(saleReceipt.date,commissionTotal));
    }
}
