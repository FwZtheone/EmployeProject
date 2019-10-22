package FactoryMethodAddEmploye;
import heh.be.global.Employe;

public class AddSalariedEmploye  extends MakePayementClassification{
    public int getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public double getSalary() {
        return salary;
    }

    public Employe getEmployee() {
        return employee;
    }

    private int empId;
    private String name;
    private String adress;
    private double salary;
    private Employe employee;



    public AddSalariedEmploye(int empId, String name, String adress,double salary) {
        this.empId = empId;
        this.name = name;
        this.adress = adress;
        this.salary = salary;

    }

    public  AddSalariedEmploye(){}

    @Override
    public void execute() {


    }





}
