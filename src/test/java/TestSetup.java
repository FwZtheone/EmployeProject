import FactoryMethodAddEmploye.Context;
import FactoryMethodAddEmploye.InMemoryEmployeGateway;
import heh.be.global.Employe;

public   class TestSetup {

    //méthode static ainsi je ne suis pas obligé de instancier la classe


    static void setupContext() throws Exception{
        Context.employeGateway = new InMemoryEmployeGateway();
    }



}
