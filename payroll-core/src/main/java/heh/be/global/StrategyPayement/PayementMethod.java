package heh.be.global.StrategyPayement;

import heh.be.global.PayDay.Paycheck;

public interface PayementMethod {



    public PayementMethod getPayMethod();

    public void pay(Paycheck pc);




}
