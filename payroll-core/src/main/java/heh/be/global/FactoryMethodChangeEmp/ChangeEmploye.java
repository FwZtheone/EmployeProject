package heh.be.global.FactoryMethodChangeEmp;

import heh.be.global.FactoryMethodAddEmploye.Command;
import heh.be.global.FactoryMethodAddEmploye.Context;
import heh.be.global.Employe;

public  abstract  class ChangeEmploye  implements Command {

    private int id;

    public ChangeEmploye(int id)
    {
     this.id= id;
    }

    @Override
    public void execute() {
        Employe e = Context.employeGateway.getEmploye(id);
        change(e);
    }

    public abstract void change(Employe e);
}
