package heh.be.global.StrategyClassification;

import heh.be.global.PayDay.Paycheck;

public interface PayementClassification {

    public double calculationSalary();
    public void calculationPay(Paycheck pc);
}
