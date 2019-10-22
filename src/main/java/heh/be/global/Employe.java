package heh.be.global;

import FactoryMethodAddEmploye.AddSalariedEmploye;
import StrategyClassification.PayementClassification;
import StrategyPayement.PayementMethod;
import StrategySchedule.PayementSchedule;

import java.util.HashMap;
import java.util.Map;

public class Employe {

    public void setEmpId(int empId) {
        EmpId = empId;
    }

    private int EmpId;
    private String name;
    private String address;
    private double salary;
    private PayementMethod transaction;
    private PayementSchedule payDay;
    private PayementClassification classification;



    public HashMap<Integer, Employe> getListeEmploye() {
        return listeEmploye;
    }

    private HashMap<Integer, Employe> listeEmploye;

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

    public void setListEmploye(AddSalariedEmploye obj){

        this.listeEmploye.put(obj.getEmpId(),obj);
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

}
