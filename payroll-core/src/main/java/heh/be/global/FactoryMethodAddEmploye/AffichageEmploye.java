package heh.be.global.FactoryMethodAddEmploye;

import heh.be.global.Employe;

public class AffichageEmploye {


    Employe e ;

    public Employe getEmploye(int empid ){

        return Context.employeGateway.getEmploye(empid);
    }
}
