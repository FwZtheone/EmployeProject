package heh.be.global;

import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.FactoryMethodAddEmploye.employeGateway;

import java.util.ArrayList;
import java.util.Map;

public class ReadEmploye {




    public ArrayList<Employe> getAllEmploye(){

        Context.employeGateway = new SqlEmployeGateway();

        return Context.employeGateway.receiveAllEmploye();
    }
}
