package heh.be.global.StrategyClassification;

import heh.be.global.PayDay.Paycheck;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HourlyClassification implements  PayementClassification{

   private double hoursSalary;

    public double getHoursSalary() {
        return hoursSalary;
    }

    private double salary;

    public HashMap<LocalDate, TimeCard> getListTimeCard() {
        return listTimeCard;
    }

    private HashMap<LocalDate,TimeCard> listTimeCard;



   public HourlyClassification(double hoursSalary){
       this.hoursSalary = hoursSalary;
       this.listTimeCard = new HashMap<LocalDate, TimeCard>();

   }

    @Override
    public double calculationSalary() {
        for(Map.Entry te: listTimeCard.entrySet()){
            TimeCard time = (TimeCard)te.getValue();
            if(time.getHours() > 8){
                salary=hoursSalary*8+hoursSalary*(time.getHours()-8)*1.5;

            }
            else
            {
                salary  = hoursSalary * time.getHours();
            }
        }

        return salary;
    }

    @Override
    public void calculationPay(Paycheck pc) {
       pc.setSalary(this.calculationSalary());

    }

    public void addTimeCard(TimeCard timeCard){
       this.listTimeCard.put(timeCard.getDate(),timeCard);

        preCalcul(timeCard);

    }

    public double preCalcul(TimeCard timeCard){
       this.salary  +=  timeCard.getHours() * hoursSalary;
       System.out.println("salaire : " + salary + " heures :" + timeCard.getHours() +  " euros par h :" + hoursSalary);
       return salary;
    }



}
