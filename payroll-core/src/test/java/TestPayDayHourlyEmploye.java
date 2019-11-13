import heh.be.global.FactoryMethodAddEmploye.AddHourlyEmploye;
import heh.be.global.FactoryMethodAddEmploye.AddTimeCard;
import heh.be.global.PayDay.PayDay;
import heh.be.global.PayDay.Paycheck;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestPayDayHourlyEmploye {
    private final LocalDate firstFriday=LocalDate.of(2019, Month.NOVEMBER, 1);
    private final LocalDate secondFriday=LocalDate.of(2019, Month.NOVEMBER, 8);
    private final LocalDate wrongDate=LocalDate.of(2019, Month.NOVEMBER, 2);
    @Before
    public void setup() throws Exception {
        TestSetup.setupContext();
    }

    @Test
    public void PaySingleHourlyEmployeeWithoutHour(){
        int empID = 1;
        AddHourlyEmploye hourlyEmployee = new AddHourlyEmploye(empID,"toto","Rue de Nimy",20);
        hourlyEmployee.execute();
        PayDay payday = new PayDay(firstFriday);
        payday.execute();
        Paycheck pc = payday.getPaycheck(empID);
        assertNotNull(pc);
        assertEquals(firstFriday,pc.getDate());
        assertEquals(0,pc.getSalary(),0.1);
        assertEquals("bank",pc.getTypeSalary("Disposition"));
    }

    @Test
    public void PaySingleHourlyEmployeeOnWrongDate(){
        int empID = 5;
        AddHourlyEmploye hourlyEmployee = new AddHourlyEmploye(empID,"toto","Rue de Nimy",1400.0);
        hourlyEmployee.execute();
        PayDay payday = new PayDay(wrongDate);
        payday.execute();
        Paycheck pc = payday.getPaycheck(empID);
        assertNull(pc);
    }

    @Test
    public void PaySingleHourlyEmployeeWithHour(){
        int empID = 1;
        AddHourlyEmploye hourlyEmployee = new AddHourlyEmploye(empID,"toto","Rue de Nimy",20);
        hourlyEmployee.execute();
        AddTimeCard tc=new AddTimeCard(3,secondFriday,empID);
        tc.execute();
        PayDay payday = new PayDay(secondFriday);
        payday.execute();
        Paycheck pc = payday.getPaycheck(empID);
        assertNotNull(pc);
        assertEquals(secondFriday,pc.getDate());
        assertEquals(60,pc.getSalary(),0.1);
        assertEquals("bank",pc.getTypeSalary("s"));
    }

    @Test
    public void PaySingleHourlyEmployeeWithMoreHour(){
        int empID = 1;
        AddHourlyEmploye hourlyEmployee = new AddHourlyEmploye(empID,"toto","Rue de Nimy",20);
        hourlyEmployee.execute();
        AddTimeCard tc=new AddTimeCard(10,secondFriday,empID);
        tc.execute();
        PayDay payday = new PayDay(secondFriday);
        payday.execute();
        Paycheck pc = payday.getPaycheck(empID);
        assertNotNull(pc);
        assertEquals(secondFriday,pc.getDate());
        assertEquals(220,pc.getSalary(),0.1);
        assertEquals("bank",pc.getTypeSalary("Disposition"));
    }






}
