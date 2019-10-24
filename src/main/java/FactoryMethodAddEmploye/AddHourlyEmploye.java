package FactoryMethodAddEmploye;

import StrategyClassification.HourlyClassification;
import StrategyClassification.PayementClassification;
import StrategySchedule.PayementSchedule;
import StrategySchedule.WeeklyPayementSchedule;

public class AddHourlyEmploye  extends  AddEmp{

    private double  hrlyRate;

    public AddHourlyEmploye(int empId, String name, String address,double hrlyRate) {
        super(empId, name, address);
        this.hrlyRate = hrlyRate;

    }

    @Override
    public PayementSchedule makePayementSchedule() {
        return new WeeklyPayementSchedule();
    }

    @Override
    public PayementClassification makePayementClassification() {
        return new  HourlyClassification(hrlyRate);
    }
}
