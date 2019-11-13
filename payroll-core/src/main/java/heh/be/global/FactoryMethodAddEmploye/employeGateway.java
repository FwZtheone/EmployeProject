package heh.be.global.FactoryMethodAddEmploye;

import heh.be.global.Employe;

import java.util.Map;

public interface employeGateway {
    Employe getEmploye(int empID);
    void  save (int empID,Employe employe);
    void deleteEmploye(int empID);
    void bonjour();
    public Map getAllEmploye();

}
