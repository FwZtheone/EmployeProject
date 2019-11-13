package heh.be.global.FactoryMethodChangeEmp;

import heh.be.global.Employe;
import heh.be.global.StrategyPayement.MailMethod;

public class ChangeMail extends ChangeEmploye {

    private String email;

    public ChangeMail(int id, String email) {
        super(id);
        this.email = email;

    }




    @Override
    public void change(Employe e) {

        e.setPayMethod(new MailMethod(this.email));

    }
}
