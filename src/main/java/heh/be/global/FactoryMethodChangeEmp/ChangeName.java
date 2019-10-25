package heh.be.global.FactoryMethodChangeEmp;


import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategyClassification.SalariedClassification;
import heh.be.global.StrategySchedule.MonthlyPayementSchedule;
import heh.be.global.StrategySchedule.PayementSchedule;
import heh.be.global.Employe;

public  class ChangeName extends ChgPayementClassification {

    private String name;
    private double salary;
    public String getName() {
        return name;
    }



    public ChangeName(int id, String name) {
        super(id);
        this.name = name;
    }


    @Override
    public PayementClassification makePayementClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    public PayementSchedule makePayementShedule() {
        return new MonthlyPayementSchedule();
    }

    @Override
    public void change(Employe e) {
        e.setName(name);
        e.setPayClassification(makePayementClassification());
        e.setPaySchedule(makePayementShedule());

    }
}
