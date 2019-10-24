import FactoryMethodAddEmploye.AddCommissionEmp;
import FactoryMethodAddEmploye.AddSalariedEmp;
import FactoryMethodAddEmploye.Context;
import StrategyClassification.HourlyClassification;
import heh.be.global.Employe;
import org.junit.Before;
import org.junit.Test;

public class TestChangeEmp {


    @Before
    public void setup() throws Exception {
        TestSetup.setupContext();


    }

    @Test
    public void testChangeNameEmp(){
        int empID=5;
        AddSalariedEmp employe = new AddSalariedEmp(empID,"fabrizio","rue du paradis",2000);
        employe.execute();

        ModifyName






    }

}
