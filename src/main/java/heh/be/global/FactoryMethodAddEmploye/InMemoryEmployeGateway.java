package heh.be.global.FactoryMethodAddEmploye;

import heh.be.global.Employe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryEmployeGateway implements employeGateway {


    HashMap<Integer,Employe> dbEmploye = new HashMap<>();



    public InMemoryEmployeGateway(){

   }
   @Override
   public void bonjour(){
        System.out.println("bonjour");
   }

    @Override
    public Map getAllEmploye() {
        return dbEmploye;
    }

    public HashMap getDbEmploye(){
    return this.dbEmploye;
   }

    @Override
    public Employe getEmploye(int empID) {
        return dbEmploye.get(empID);
    }

    @Override
    public void save(int empID, Employe employe) {

        dbEmploye.put(employe.getEmpId(),employe);
    }

    @Override
    public void deleteEmploye(int empID) {

        dbEmploye.remove(empID);

    }
}
