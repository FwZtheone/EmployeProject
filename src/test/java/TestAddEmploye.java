import FactoryMethodAddEmploye.Context;
import FactoryMethodAddEmploye.AddSalariedEmp;
import FactoryMethodAddEmploye.InMemoryEmployeGateway;
import heh.be.global.Employe;
import org.junit.Before;
import org.junit.Test;



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







    }



}
