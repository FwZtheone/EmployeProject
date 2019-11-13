package heh.be.global;

import heh.be.global.PayDay.Paycheck;
import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategyPayement.PayementMethod;
import heh.be.global.StrategySchedule.PayementSchedule;

import java.time.LocalDate;
import java.util.HashMap;

public class Employe {



    private int EmpId;
    private String name;
    private String address;
    private double salary;
    private PayementMethod transaction;
    private PayementSchedule payDay;
    private PayementClassification classification;
    private HashMap<Integer,Employe> listeEmploye;


    public void setEmpId(int empId) {
        EmpId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public HashMap<Integer, Employe> getListeEmploye() {
        return listeEmploye;
    }




    public Employe(){};
    public int getEmpId() {
        return EmpId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public double getSalary() {
        return salary;
    }




    public void setPayMethod(PayementMethod transaction){

        this.transaction = transaction;

    }


    public void setPayClassification(PayementClassification classification){

        this.classification = classification;
    }

    public PayementClassification getPayClassfication(){
        return classification;
    }

    public double calculPay(){
        return this.classification.calculationSalary();
    }

    public void setPaySchedule(PayementSchedule payDay){
        this.payDay  = payDay;
    }


    public Employe(int EmpId , String name, String address){
        this.EmpId = EmpId;
        this.name = name;
        this.address  = address;
        listeEmploye = new HashMap<>();
    }

    public PayementMethod getPayMethod(){
        return this.transaction;
    }

    public PayementSchedule getPayementSchedule(){
        return payDay;
    }


    public  boolean isPayDate(LocalDate date){
        return   this.payDay.isPayDate(date);
    }

    public void payDay(Paycheck pc){
        this.classification.calculationPay(pc);
        this.transaction.pay(pc);
    }



}
