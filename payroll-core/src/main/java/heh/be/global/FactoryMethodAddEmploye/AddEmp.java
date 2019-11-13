package heh.be.global.FactoryMethodAddEmploye;

import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategyPayement.DirectDepositMethod;
import heh.be.global.StrategySchedule.PayementSchedule;
import heh.be.global.Employe;

public abstract class AddEmp implements Command {

    protected Employe employe;

    @Override
    public void execute() {

        employe.setPayClassification(makePayementClassification());
        employe.setPaySchedule(makePayementSchedule());
        employe.setPayMethod(new DirectDepositMethod("Fortis","be332211"));


        Context.employeGateway.save(employe.getEmpId(),employe);


//        System.out.println(employe.getEmpId()+ " " + employe.getSalary() + " "+employe.getAddress() );


    }

    public  AddEmp(int empId, String name, String address) {


        this.employe = new Employe(empId,name,address);

    }

    public abstract PayementSchedule makePayementSchedule();


    public abstract PayementClassification makePayementClassification();


}
