package heh.be.global.FactoryMethodChangeEmp;

import heh.be.global.StrategyClassification.HourlyClassification;
import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategySchedule.PayementSchedule;
import heh.be.global.StrategySchedule.WeeklyPayementSchedule;

public class ChangeHourly extends  ChgPayementClassification {
    private double hourly;

    public ChangeHourly(int id, double hourly) {
        super(id);
        this.hourly = hourly;
    }

    @Override
    public PayementClassification makePayementClassification() {
        return new HourlyClassification(this.hourly);
    }

    @Override
    public PayementSchedule makePayementShedule() {
        return new WeeklyPayementSchedule();
    }
}
