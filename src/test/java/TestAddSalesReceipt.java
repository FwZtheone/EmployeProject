import FactoryMethodAddEmploye.AddCommissionEmp;
import FactoryMethodAddEmploye.AddSalesReceipt;
import FactoryMethodAddEmploye.AddTimeCard;
import FactoryMethodAddEmploye.Context;
import StrategyClassification.CommissionClassification;
import StrategyClassification.PayementClassification;
import StrategyClassification.SaleReceipt;
import heh.be.global.Employe;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class TestAddSalesReceipt {


    @Before
    public void setup() throws Exception {
        TestSetup.setupContext();
        int empID=5;
        AddCommissionEmp employe = new AddCommissionEmp(empID,"fabrizio","rue du paradis",2000,500);
        employe.execute();

    }


    @Test
    public void testAddSalesReceipt(){
        Calendar date = new GregorianCalendar(2019,10,1);

        AddSalesReceipt  addSalesReceipt = new AddSalesReceipt(500,date,5);

        addSalesReceipt.execute();
        Employe e = Context.employeGateway.getEmploye(5);
        assertNotNull(e);
        PayementClassification classification = e.getPayClassfication();

        SaleReceipt sl = ((CommissionClassification)classification).getListeSaleReceipt().get(date);

        assertEquals(500,sl.getSaleAmount(),0.01);









    }




}
