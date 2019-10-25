package heh.be.global.FactoryMethodAddEmploye;

import heh.be.global.StrategyClassification.HourlyClassification;
import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategySchedule.PayementSchedule;
import heh.be.global.StrategySchedule.WeeklyPayementSchedule;

public class AddHourlyEmploye  extends  AddEmp{

    public double getHrlyRate() {
        return hrlyRate;
    }

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
