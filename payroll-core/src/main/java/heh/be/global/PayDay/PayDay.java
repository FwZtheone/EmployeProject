package heh.be.global.PayDay;



import heh.be.global.FactoryMethodAddEmploye.Command;
import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.Employe;

import java.util.HashMap;
import java.time.*;
import java.util.Map;


public class PayDay implements Command {


    private LocalDate date ;
    HashMap<Integer,Paycheck> listPay  = new HashMap<Integer, Paycheck>();

    public PayDay(LocalDate date ){
    this.date = date;
    }

    @Override
    public void execute() {
        Map listeEmp = Context.employeGateway.getAllEmploye();
        listeEmp.forEach((k,v) -> {
            int id = (int)k;
            Employe e = (Employe)v;
            if(e.isPayDate(date)){
            Paycheck pc = new Paycheck(date);
            e.payDay(pc);
            listPay.put(id,pc);
            }
        });



    }

    public Paycheck getPaycheck(int empID){
        Paycheck pc = listPay.get(empID);
        return pc;
    }

}
