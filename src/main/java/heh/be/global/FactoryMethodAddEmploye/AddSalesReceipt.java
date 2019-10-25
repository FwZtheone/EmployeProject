package heh.be.global.FactoryMethodAddEmploye;

import heh.be.global.StrategyClassification.CommissionClassification;
import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategyClassification.SaleReceipt;
import heh.be.global.StrategySchedule.MonthlyPayementSchedule;
import heh.be.global.StrategySchedule.PayementSchedule;
import heh.be.global.Employe;

import java.util.Calendar;

public class AddSalesReceipt implements   Command{
    private double amount;
    private Calendar date;
    private int empId;


    public AddSalesReceipt(double amount, Calendar date, int empId) {
        this.amount = amount;
        this.date = date;
        this.empId = empId;
    }


    public PayementSchedule makePayementSchedule() {
        return new MonthlyPayementSchedule();
    }


    public PayementClassification makePayementClassification() {
        return new CommissionClassification(amount);
    }

    @Override
    public void execute() {
        Employe e = Context.employeGateway.getEmploye(this.empId);
        if(e != null){
            if(e.getPayClassfication() instanceof CommissionClassification){
                SaleReceipt sl = new SaleReceipt(this.date,this.amount);

                ((CommissionClassification) e.getPayClassfication()).addSaleReceipt(sl);

                Context.employeGateway.save(e.getEmpId(),e);

            }
            else{
                System.out.println("l'employe n'est pas une commissionClassification ! ");
            }

        }
        else{
        System.out.println(" e est null ");
        }

    }
}
