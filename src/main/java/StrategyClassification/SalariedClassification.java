package StrategyClassification;

public class SalariedClassification implements PayementClassification{

        private double salary;


        public SalariedClassification(double salary){
            this.salary = salary;
        }

    @Override
    public double calculationSalary() {
        return this.salary;
    }
}
