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
        preCalcul(timeCard.getHours());

    }

    public double preCalcul(double hours){
       return this.salary*this.hoursSalary;
    }

}
