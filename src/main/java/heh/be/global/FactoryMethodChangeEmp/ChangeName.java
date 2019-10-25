package heh.be.global.FactoryMethodChangeEmp;


import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategyClassification.SalariedClassification;
import heh.be.global.StrategySchedule.MonthlyPayementSchedule;
import heh.be.global.StrategySchedule.PayementSchedule;
import heh.be.global.Employe;

public  class ChangeName extends ChangeEmploye {

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
    public void change(Employe e) {
        e.setName(name);


    }
}
