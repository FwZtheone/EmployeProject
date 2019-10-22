package FactoryMethodAddEmploye;

import heh.be.global.Employe;

public abstract class MakePayementClassification implements Command {

    private int empId;
    private String address;
    private String name;
    private Employe employe;

    @Override
    public void execute() {
        employe.setListEmploye(new AddSalariedEmploye(empId,address,name,0));

    }



}
