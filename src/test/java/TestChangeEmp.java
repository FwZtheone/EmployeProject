import heh.be.global.FactoryMethodChangeEmp.ChangeName;
import heh.be.global.FactoryMethodChangeEmp.ChangeSalaried;
import heh.be.global.FactoryMethodAddEmploye.*;
import heh.be.global.StrategyClassification.SalariedClassification;
import heh.be.global.StrategySchedule.MonthlyPayementSchedule;
import heh.be.global.Employe;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestChangeEmp {

    private int empID = 5;

    @Before
    public void setup() throws Exception {
        TestSetup.setupContext();
        AddHourlyEmploye employe = new AddHourlyEmploye(empID,"fabrizio","rue du paradis",100);
        employe.execute();
    }

    @Test
    public void testChangeNameEmp(){
        ChangeSalaried changeSalaried = new ChangeSalaried(empID,2000);
        changeSalaried.execute();

        Employe e = Context.employeGateway.getEmploye(empID);
        assertTrue(e.getPayClassfication() instanceof SalariedClassification);
        assertTrue(e.getPayementSchedule() instanceof MonthlyPayementSchedule);


        ChangeName changeName = new ChangeName(empID,"lol");
        changeName.execute();

        assertEquals(e.getName(),changeName.getName());





    }

}
