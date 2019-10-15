import StrategyClassification.PayementClassification;
import StrategyPayement.PayementMethod;
import StrategySchedule.PayementSchedule;

public class Employe {

    private int EmpId;
    private String name;
    private String address;
    private double salary;
    private PayementMethod transaction;
    private PayementSchedule payDay;
    private PayementClassification classification;


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
    }

    public PayementMethod getPayMethod(){
        return this.transaction;
    }

    public PayementSchedule getPayementSchedule(){
        return payDay;
    }

}
