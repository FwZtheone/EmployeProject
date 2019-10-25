package heh.be.global.FactoryMethodChangeEmp;

import heh.be.global.Employe;
import heh.be.global.StrategyClassification.CommissionClassification;
import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategySchedule.PayementSchedule;
import heh.be.global.StrategySchedule.TwoWeekPay;
import heh.be.global.StrategySchedule.WeeklyPayementSchedule;

public class ChangeCommission extends  ChgPayementClassification {
    private double commission;
    private double salary;

    public ChangeCommission(int id,double commission, double salary) {
        super(id);
        this.commission = commission;
        this.salary= salary;
    }

    @Override
    public PayementClassification makePayementClassification() {
        return new CommissionClassification(commission,salary);
    }

    @Override
    public PayementSchedule makePayementShedule() {
        return new TwoWeekPay();
    }


}
