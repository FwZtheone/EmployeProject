package FactoryMethodAddEmploye;

import heh.be.global.Employe;

public interface employeGateway {
    Employe getEmploye(int empID);
    void  save (int empID,Employe employe);
    void deleteEmploye(int empID);

}
