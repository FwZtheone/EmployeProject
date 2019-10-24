package FactoryMethodAddEmploye;

import StrategyClassification.CommissionClassification;
import StrategyClassification.PayementClassification;
import StrategySchedule.PayementSchedule;
import StrategySchedule.TwoWeekPay;

public class AddCommissionEmp extends AddEmp {
    private double mtlySly;
    private double comRate;


    public AddCommissionEmp(int empId, String name, String address,double mtlySly, double comRate) {
        super(empId, name, address);
        this.mtlySly = mtlySly;
        this.comRate = comRate;
    }

    @Override
    public PayementSchedule makePayementSchedule() {
        return new TwoWeekPay();
    }

    @Override
    public PayementClassification makePayementClassification() {
        return new CommissionClassification(mtlySly);
    }
}
