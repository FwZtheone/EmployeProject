package FactoryMethodAddEmploye;

import heh.be.global.Employe;

import java.util.HashMap;
import java.util.Map;

public class InMemoryEmployeGateway implements employeGateway {

   Employe employe;
   Employe employe2;

   HashMap<Integer,Employe> dbEmploye;

   public InMemoryEmployeGateway(){
    HashMap<Integer,Employe> dbEmploye = new HashMap<>();

   }

   public HashMap getDbEmploye(){
    return this.dbEmploye;
   }

    @Override
    public Employe getEmploye(int empID) {




    }

    @Override
    public void save(int empID, Employe employe) {

    }

    @Override
    public void deleteEmploye(int empID) {

    }
}
