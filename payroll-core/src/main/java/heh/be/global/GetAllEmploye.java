package heh.be.global;

import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.FactoryMethodAddEmploye.employeGateway;

import java.util.Map;

public class GetAllEmploye implements employeGateway {


    @Override
    public Employe getEmploye(int empID) {
        return null;
    }

    @Override
    public void save(int empID, Employe employe) {

    }

    @Override
    public void deleteEmploye(int empID) {

    }

    @Override
    public void bonjour() {

    }

    @Override
    public Map getAllEmploye() {
        Context.employeGateway = new SqlEmployeGateway();
        return Context.employeGateway.getAllEmploye();
    }
}
