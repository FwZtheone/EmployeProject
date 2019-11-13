import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.FactoryMethodAddEmploye.InMemoryEmployeGateway;

public   class TestSetup {

    //méthode static ainsi je ne suis pas obligé de instancier la classe


    static void setupContext() throws Exception{
        Context.employeGateway = new InMemoryEmployeGateway();
    }



}
