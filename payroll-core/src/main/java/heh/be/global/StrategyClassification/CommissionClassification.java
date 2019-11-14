package heh.be.global.StrategyClassification;

import heh.be.global.PayDay.Paycheck;

import java.util.Calendar;
import java.util.HashMap;

public class CommissionClassification implements PayementClassification {
    private double salary;
    private double commission;

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

    @Override
    public void calculationPay(Paycheck pc) {

    }

    public CommissionClassification(double commission){
        this.commission = commission;
        this.listeSaleReceipt = new HashMap<>();

    }
    //j'ai modifier salary pr commission
    public CommissionClassification(double commission , double salary){
        this.commission = commission;
        this.salary = salary;


        this.listeSaleReceipt = new HashMap<>();
    }

    public void addSaleReceipt(SaleReceipt saleReceipt)
    {
        listeSaleReceipt.put(saleReceipt.getDate(),new SaleReceipt(saleReceipt.getDate(),saleReceipt.getSaleAmount()));
        commission += saleReceipt.getSaleAmount();
    }

    @Override
    public String toString(){
        return "commission";
    }
}
