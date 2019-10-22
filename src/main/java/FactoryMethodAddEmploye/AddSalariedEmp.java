package FactoryMethodAddEmploye;

import StrategyClassification.PayementClassification;
import StrategyClassification.SalariedClassification;
import StrategySchedule.MonthlyPayementSchedule;
import StrategySchedule.PayementSchedule;

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
