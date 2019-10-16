package StrategyClassification;

import java.util.Calendar;
import java.util.HashMap;

public class HourlyClassification implements  PayementClassification{

   private double hoursSalary;
   private double salary;
   private HashMap<Calendar,TimeCard> listTimeCard;



   public HourlyClassification(double hoursSalary){
       this.hoursSalary = hoursSalary;
       this.listTimeCard = new HashMap<>();

   }

    @Override
    public double calculationSalary() {
        return this.salary;
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
