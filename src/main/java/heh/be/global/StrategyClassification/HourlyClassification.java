package heh.be.global.StrategyClassification;

import heh.be.global.PayDay.Paycheck;

import java.util.Calendar;
import java.util.HashMap;

public class HourlyClassification implements  PayementClassification{

   private double hoursSalary;

    public double getHoursSalary() {
        return hoursSalary;
    }

    private double salary;

    public HashMap<Calendar, TimeCard> getListTimeCard() {
        return listTimeCard;
    }

    private HashMap<Calendar,TimeCard> listTimeCard;



   public HourlyClassification(double hoursSalary){
       this.hoursSalary = hoursSalary;
       this.listTimeCard = new HashMap<Calendar, TimeCard>();

   }

    @Override
    public double calculationSalary() {
        return this.salary;
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
