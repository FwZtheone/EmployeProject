import heh.be.global.Employe;

public   class TestSetup {

    //méthode static ainsi je ne suis pas obligé de instancier la classe

    static Employe employee ;
    static void setupContext() throws Exception{
        employee = new Employe(200,"chiara","rue guerin");
        System.out.println("creation de l'employe");
    }



}
