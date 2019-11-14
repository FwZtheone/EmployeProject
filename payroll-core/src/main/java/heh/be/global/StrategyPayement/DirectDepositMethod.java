package heh.be.global.StrategyPayement;

import heh.be.global.PayDay.Paycheck;

public class DirectDepositMethod implements PayementMethod {

    private String bank;
    private String accountNumber;



    public DirectDepositMethod(String bank,String accountNumber){
        this.bank = bank;
        this.accountNumber = accountNumber;
    }

    public DirectDepositMethod(){

    }


    @Override
    public String toString(){
//        return "direct deposit into "+this.bank+":"+this.accountNumber;

        return "direct";
    }


    @Override
    public PayementMethod getPayMethod() {
        return new DirectDepositMethod();
    }

    @Override
    public void pay(Paycheck pc) {
        pc.setDisposition("bank");
    }
}
