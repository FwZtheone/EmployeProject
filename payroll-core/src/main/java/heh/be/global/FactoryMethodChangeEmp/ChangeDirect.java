package heh.be.global.FactoryMethodChangeEmp;

import heh.be.global.Employe;
import heh.be.global.StrategyPayement.DirectDepositMethod;

public class ChangeDirect extends ChangeEmploye {

    private String bank;
    private String account;

    public ChangeDirect(int id, String bank, String account) {
        super(id);
        this.bank = bank;
        this.account = account;
    }

    @Override
    public void change(Employe e) {
        e.setPayMethod(new DirectDepositMethod(this.bank,this.account));

    }
}
