import static org.junit.Assert.*;

import FactoryMethodAddEmploye.AddSalariedEmploye;
import FactoryMethodAddEmploye.Context;
import heh.be.global.Employe;
import org.junit.Before;
import org.junit.Ignore;
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
        AddSalariedEmploye t = new AddSalariedEmploye(empId,"Gina","Rue du bout de la haut",1000);
        t.execute();

        Employe e = Context.employeGateway.getEmploye(empId);




    }



}
