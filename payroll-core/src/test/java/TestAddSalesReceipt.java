import heh.be.global.FactoryMethodAddEmploye.AddCommissionEmp;
import heh.be.global.FactoryMethodAddEmploye.AddSalesReceipt;
import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.StrategyClassification.CommissionClassification;
import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategyClassification.SaleReceipt;
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
