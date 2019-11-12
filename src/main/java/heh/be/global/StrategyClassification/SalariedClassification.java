package heh.be.global.StrategyClassification;

import heh.be.global.PayDay.Paycheck;

public class SalariedClassification implements PayementClassification{

        private double salary;


        public SalariedClassification(double salary){
            this.salary = salary;
        }

    @Override
    public double calculationSalary() {
        return this.salary;
    }

    @Override
    public void calculationPay(Paycheck pc) {
            pc.setSalary(this.calculationSalary());

    }
}
