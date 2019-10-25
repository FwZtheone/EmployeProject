package heh.be.global.FactoryMethodChangeEmp;



import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategyClassification.SalariedClassification;
import heh.be.global.StrategySchedule.MonthlyPayementSchedule;
import heh.be.global.StrategySchedule.PayementSchedule;

public class ChangeSalaried  extends ChgPayementClassification {

    private double salary;

    public ChangeSalaried(int id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public PayementClassification makePayementClassification() {
        return new SalariedClassification(this.salary);
    }

    @Override
    public PayementSchedule makePayementShedule() {
        return new MonthlyPayementSchedule();
    }
}
