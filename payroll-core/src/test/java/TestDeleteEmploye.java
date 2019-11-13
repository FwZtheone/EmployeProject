import heh.be.global.FactoryMethodAddEmploye.AddSalariedEmp;
import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.Employe;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertNull;

public class TestDeleteEmploye {


    @Before
    public void setup() throws Exception {
        TestSetup.setupContext();

    }

    @Test
    public void testDeleteEmploye(){
        int empId = 5;

        AddSalariedEmp t = new AddSalariedEmp(empId,"Kevin","Rue du paradis",3000);
        t.execute();
        //récupération de l'id de l'employe
        Employe e = Context.employeGateway.getEmploye(empId);
        assertNotNull(e);

         Context.employeGateway.deleteEmploye(empId);
        e = Context.employeGateway.getEmploye(empId);
        assertNull(e);


    }


}
