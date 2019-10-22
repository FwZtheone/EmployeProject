package FactoryMethodAddEmploye;

import StrategyClassification.PayementClassification;
import StrategySchedule.PayementSchedule;

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
        return null;
    }

    @Override
    public PayementClassification makePayementClassification() {
        return null;
    }
}
