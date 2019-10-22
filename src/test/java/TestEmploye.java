import StrategyClassification.*;
import StrategyPayement.CashMethod;
import StrategyPayement.DirectDepositMethod;
import StrategyPayement.MailMethod;
import StrategyPayement.PayementMethod;
import StrategySchedule.MonthlyPayementSchedule;
import StrategySchedule.PayementSchedule;
import StrategySchedule.TwoWeekPay;
import StrategySchedule.WeeklyPayementSchedule;
import heh.be.global.Employe;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestEmploye {


    private Employe employe;

    @Before
    public void setUp() throws Exception {
        employe = new Employe(100,"toto","av maistriau");
    }

    @Test
    public void createSalarieEmploye(){

        employe.setPayClassification(new SalariedClassification(1000));
        employe.setPayMethod(new DirectDepositMethod("CPH","BE-78-45-25-26"));
        employe.setPaySchedule(new MonthlyPayementSchedule());
        assertEquals(1000.0,employe.calculPay(),0.01);
        PayementSchedule ps = employe.getPayementSchedule();
        assertTrue(ps instanceof MonthlyPayementSchedule);
        PayementMethod pm = employe.getPayMethod();
        assertEquals("direct deposit into CPH:BE-78-45-25-26",pm.toString());
    }

    @Test
    public void createHourlyEmploye(){
        employe.setPayClassification(new HourlyClassification(20.0));
        employe.setPayMethod(new MailMethod("toto@gmail.com"));
        employe.setPaySchedule(new WeeklyPayementSchedule());

        Calendar date = new GregorianCalendar(2019,10,1);
        Calendar nextDate = new GregorianCalendar(2019,10,2);
        PayementClassification classification= employe.getPayClassfication();
        ((HourlyClassification)classification).addTimeCard(new TimeCard(date,8.0));
        ((HourlyClassification)classification).addTimeCard(new TimeCard(nextDate, 10.0));

        assertEquals(360.0,employe.calculPay(),0.01);

        PayementSchedule ps = employe.getPayementSchedule();
        assertTrue(ps instanceof WeeklyPayementSchedule);

        PayementMethod pm = employe.getPayMethod();
        assertEquals("mail : toto@gmail.com",pm.toString());
    }

    @Test
    public void createCommissionEmploye(){
        employe.setPayClassification(new CommissionClassification(1000));
        employe.setPayMethod(new CashMethod());
        employe.setPaySchedule(new TwoWeekPay());
        Calendar date = new GregorianCalendar(2019,10,1);
        Calendar nextDate = new GregorianCalendar(2019,10,2);

        PayementClassification classification= employe.getPayClassfication();
        ((CommissionClassification)classification).addSaleReceipt(new SaleReceipt(date,200));
        ((CommissionClassification)classification).addSaleReceipt(new SaleReceipt(nextDate,150));

        assertEquals(1350,employe.calculPay(),0.01);

        PayementSchedule ps = employe.getPayementSchedule();
        assertTrue(ps instanceof TwoWeekPay);

        PayementMethod pm = employe.getPayMethod();
        assertEquals("cash",pm.toString());



    }

}
