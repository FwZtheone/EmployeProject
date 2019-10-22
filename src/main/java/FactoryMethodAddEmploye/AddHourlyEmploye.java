package FactoryMethodAddEmploye;

import StrategyClassification.PayementClassification;
import StrategySchedule.PayementSchedule;

public class AddHourlyEmploye  extends  AddEmp{

    private double  hrlyRate;

    public AddHourlyEmploye(int empId, String name, String address,double hrlyRate) {
        super(empId, name, address);
        this.hrlyRate = hrlyRate;

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
