package StrategyClassification;

import java.util.Calendar;
import java.util.HashMap;

public class CommissionClassification implements PayementClassification {
    private double salary;
    private double commission;
    private double commissionTotal;

    public void setListeSaleReceipt(HashMap<Calendar, SaleReceipt> listeSaleReceipt) {
        this.listeSaleReceipt = listeSaleReceipt;
    }

    public HashMap<Calendar, SaleReceipt> getListeSaleReceipt() {
        return listeSaleReceipt;
    }

    private HashMap<Calendar,SaleReceipt> listeSaleReceipt;


    @Override
    public double calculationSalary() {
        return salary +commission;
    }

    public CommissionClassification(double salary){
        this.salary = salary;


        this.listeSaleReceipt = new HashMap<>();
    }

    public void addSaleReceipt(SaleReceipt saleReceipt)
    {
        listeSaleReceipt.put(saleReceipt.getDate(),new SaleReceipt(saleReceipt.getDate(),saleReceipt.getSaleAmount()));
        commission += saleReceipt.getSaleAmount();
    }
}
