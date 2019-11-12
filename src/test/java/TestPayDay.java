import heh.be.global.FactoryMethodAddEmploye.AddCommissionEmp;
import heh.be.global.FactoryMethodAddEmploye.AddSalariedEmp;
import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.FactoryMethodAddEmploye.InMemoryEmployeGateway;
import heh.be.global.PayDay.PayDay;
import heh.be.global.PayDay.Paycheck;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class TestPayDay {
    @Before
    public void setup() throws Exception {
        TestSetup.setupContext();
    }

    @Test
    public void PaySingleSalariedEmployee(){
        int empID = 2;
        AddSalariedEmp salariedEmployee = new AddSalariedEmp(empID,"toto","Rue de Nimy",1400.0);
        salariedEmployee.execute();

        LocalDate date = LocalDate.of(2019,10,31);
        PayDay payday = new PayDay(date);
        payday.execute();

        Paycheck pc = payday.getPaycheck(empID);
        assertNotNull(pc);

        assertEquals(date,pc.getDate());
        assertEquals(1400.0,pc.getSalary(),0.1);
        assertEquals("bank",pc.getTypeSalary("Disposition"));
    }

    @Test
    public void PaySingleSalariedEmployeeOnWrongDate(){
        int empID = 3;
        AddSalariedEmp salariedEmployee = new AddSalariedEmp(empID,"toto","Rue de Nimy",1400.0);
        salariedEmployee.execute();

       LocalDate date = LocalDate.of(2019,10,29);
        PayDay payday = new PayDay(date);
        payday.execute();

        Paycheck pc = payday.getPaycheck(empID);
        assertNull(pc);
    }



}
