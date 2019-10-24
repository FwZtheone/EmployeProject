package FactoryMethodAddEmploye;

import StrategyClassification.HourlyClassification;
import StrategyClassification.TimeCard;
import heh.be.global.Employe;

import java.util.Calendar;

public class AddTimeCard  implements Command{


    private double hour;
    private Calendar date;
    private int empID;

    public AddTimeCard(double hour, Calendar date, int empID) {
        this.hour = hour;
        this.date = date;
        this.empID = empID;
    }

    @Override
    public void execute() {

        Employe e = Context.employeGateway.getEmploye(this.empID);

        if(e != null ){
            if(e.getPayClassfication() instanceof HourlyClassification){
                TimeCard tc = new TimeCard(this.date,this.hour);

                ((HourlyClassification) e.getPayClassfication()).addTimeCard(tc);
                Context.employeGateway.save(e.getEmpId(),e);
            }
            else{
                System.out.println("error");

            }
        }

        else{
            System.out.println("pas employé par heures !");

        }

    }
}
