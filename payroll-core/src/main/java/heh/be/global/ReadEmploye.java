package heh.be.global;


import heh.be.global.FactoryMethodAddEmploye.Context;

import java.util.ArrayList;

public class ReadEmploye {

    public ReadEmploye(){};


    public ArrayList<Employe> getAllEmploye() {

        Context.employeGateway = new SqlEmployeGateway();
        return Context.employeGateway.receiveAllEmploye();

    }

}
