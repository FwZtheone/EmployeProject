package heh.be.global.StrategyPayement;

import heh.be.global.PayDay.Paycheck;

public class CashMethod implements PayementMethod {


    public CashMethod(){}
    @Override
    public PayementMethod getPayMethod() {
        return new CashMethod();
    }

    @Override
    public void pay(Paycheck pc) {
        pc.setDisposition(this.toString());
    }
    @Override
    public String toString(){
        return "cash";
    }


}
