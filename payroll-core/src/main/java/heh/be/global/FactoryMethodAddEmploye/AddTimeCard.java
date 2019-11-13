package heh.be.global.FactoryMethodAddEmploye;

import heh.be.global.StrategyClassification.HourlyClassification;
import heh.be.global.StrategyClassification.TimeCard;
import heh.be.global.Employe;

import java.time.LocalDate;

public class AddTimeCard  implements Command{


    private double hour;
    private LocalDate date;
    private int empID;

    public AddTimeCard(double hour, LocalDate date, int empID) {
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
            System.out.println("pas employe par heures !");

        }

    }
}
