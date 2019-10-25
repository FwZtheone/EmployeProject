import heh.be.global.FactoryMethodChangeEmp.*;
import heh.be.global.FactoryMethodAddEmploye.*;
import heh.be.global.StrategyClassification.CommissionClassification;
import heh.be.global.StrategyClassification.HourlyClassification;
import heh.be.global.StrategyClassification.SalariedClassification;
import heh.be.global.StrategyPayement.DirectDepositMethod;
import heh.be.global.StrategyPayement.MailMethod;
import heh.be.global.StrategyPayement.PayementMethod;
import heh.be.global.StrategySchedule.MonthlyPayementSchedule;
import heh.be.global.Employe;
import heh.be.global.StrategySchedule.TwoWeekPay;
import heh.be.global.StrategySchedule.WeeklyPayementSchedule;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class TestChangeEmp {

    private int empID = 5;
    private int empID2= 6;


    @Before
    public void setup() throws Exception {
        TestSetup.setupContext();
        AddHourlyEmploye employe = new AddHourlyEmploye(empID,"fabrizio","rue du paradis",100);
        AddSalariedEmp  employe2 = new AddSalariedEmp(empID2,"anthony","rue du paradis",2000);

        employe.execute();
        employe2.execute();

    }

    @Test
    public void testChangeNameEmp(){
        ChangeName changeName = new ChangeName(empID,"lol");
        Employe e = Context.employeGateway.getEmploye(empID);
        changeName.execute();

        assertEquals(e.getName(),changeName.getName());

    }

    @Test
    public void testChangeSalaried(){
        ChangeSalaried changeSalaried = new ChangeSalaried(empID,2000);
        changeSalaried.execute();

        Employe e = Context.employeGateway.getEmploye(empID);

        assertTrue(e.getPayClassfication() instanceof SalariedClassification);
        assertTrue(e.getPayementSchedule() instanceof MonthlyPayementSchedule);
    }

    @Test
    public void testChangeAddress(){
        ChangeAddress changeAddress = new ChangeAddress(empID,"chez pioupiou");
        changeAddress.execute();

        Employe e = Context.employeGateway.getEmploye(empID);

        assertEquals(e.getAddress(),changeAddress.getAddress());

    }
    @Test
    public void testChangeHourly(){
        ChangeHourly changeHourly = new ChangeHourly(empID2,20);
        changeHourly.execute();

        Employe e = Context.employeGateway.getEmploye(empID2);

        assertTrue(e.getPayClassfication() instanceof HourlyClassification);
        assertTrue(e.getPayementSchedule() instanceof WeeklyPayementSchedule);
    }

    @Test
    public void testChangeCommission(){
        ChangeCommission changeCommission = new ChangeCommission(empID2,5000,100);
        changeCommission.execute();

        Employe e = Context.employeGateway.getEmploye(empID2);
        assertTrue(e.getPayClassfication() instanceof CommissionClassification);
        assertTrue(e.getPayementSchedule() instanceof TwoWeekPay);
    }

    @Test
    public void testChangeMail(){
        ChangeMail changeMail = new ChangeMail(empID,"Toto@hotmail.com");
        changeMail.execute();
        Employe e = Context.employeGateway.getEmploye(empID);

        assertTrue(e.getPayMethod() instanceof MailMethod);
        PayementMethod pm = e.getPayMethod();
        assertEquals("mail : Toto@hotmail.com",pm.toString());

    }

    @Test
    public void testChangeDirect(){
        ChangeDirect changeDirect = new ChangeDirect(empID,"AXA","BE-10-11-12-13");
        changeDirect.execute();
        Employe e = Context.employeGateway.getEmploye(empID);

        assertTrue(e.getPayMethod() instanceof DirectDepositMethod);
        PayementMethod pm = e.getPayMethod();
        assertEquals("direct deposit into AXA:BE-10-11-12-13",pm.toString());
    }



}
