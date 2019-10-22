import FactoryMethodAddEmploye.Context;
import FactoryMethodAddEmploye.AddSalariedEmp;
import FactoryMethodAddEmploye.InMemoryEmployeGateway;
import StrategyPayement.PayementMethod;
import StrategySchedule.MonthlyPayementSchedule;
import StrategySchedule.PayementSchedule;
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



}
