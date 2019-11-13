package heh.be.global.FactoryMethodAddEmploye;

import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategyClassification.SalariedClassification;
import heh.be.global.StrategySchedule.MonthlyPayementSchedule;
import heh.be.global.StrategySchedule.PayementSchedule;

public class AddSalariedEmp extends AddEmp {


    private double mtlySlry;



    public AddSalariedEmp(int empId, String name, String address, double mtlySlry){
        super(empId,name,address);
        this.mtlySlry = mtlySlry;
        employe.setSalary(mtlySlry);
    }

    @Override
    public PayementSchedule makePayementSchedule() {
        return new MonthlyPayementSchedule();
    }

    @Override
    public PayementClassification makePayementClassification(){
        return new SalariedClassification(mtlySlry);
    }
}
