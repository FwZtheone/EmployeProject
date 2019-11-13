import heh.be.global.FactoryMethodAddEmploye.AddCommissionEmp;
import heh.be.global.FactoryMethodAddEmploye.AddHourlyEmploye;
import heh.be.global.FactoryMethodAddEmploye.AddSalariedEmp;
import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.StrategyPayement.PayementMethod;
import heh.be.global.StrategySchedule.MonthlyPayementSchedule;
import heh.be.global.StrategySchedule.PayementSchedule;
import heh.be.global.StrategySchedule.TwoWeekPay;
import heh.be.global.StrategySchedule.WeeklyPayementSchedule;
import heh.be.global.Employe;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class TestAddEmploye {

    @Before
    public void setup() throws Exception {
        TestSetup.setupContext();

    }

    @Test
    public void testAddSalariedEmploye()
    {
        int empId = 1;
        AddSalariedEmp t = new AddSalariedEmp(empId,"Gina","Rue du bout de la haut",1000);
        t.execute();

        Employe e = Context.employeGateway.getEmploye(empId);
        assertEquals("Gina",e.getName());
        PayementSchedule ps = e.getPayementSchedule();
        assertTrue(ps instanceof MonthlyPayementSchedule);

        PayementMethod pm = e.getPayMethod();
        assertEquals("direct deposit into Fortis:be332211",pm.toString());

    }

    @Test
    public void testAddHourlyEmploye(){
        int empId = 2;
        AddHourlyEmploye t = new AddHourlyEmploye(empId,"BobHourly","Home_Hourly",20.0);
        t.execute();

        Employe e = Context.employeGateway.getEmploye(empId);
        assertEquals("BobHourly",e.getName());

        PayementSchedule ps = e.getPayementSchedule();
        assertTrue(ps instanceof WeeklyPayementSchedule);

        PayementMethod pm = e.getPayMethod();
        assertEquals("direct deposit into Fortis:be332211",pm.toString());

    }

    @Test
    public void testAddCommissionEmploye(){
        int empId = 3;
        AddCommissionEmp t = new AddCommissionEmp(empId,"KevinCom","Home_Com",1000,500);
        t.execute();

        Employe e = Context.employeGateway.getEmploye(empId);
        assertEquals("KevinCom",e.getName());

        PayementSchedule ps = e.getPayementSchedule();
        assertTrue(ps instanceof TwoWeekPay);

        PayementMethod pm = e.getPayMethod();
        assertEquals("direct deposit into Fortis:be332211",pm.toString());
    }



}
