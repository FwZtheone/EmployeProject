package heh.be.global.StrategyPayement;

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
        return "direct deposit into "+this.bank+":"+this.accountNumber;
    }

    @Override
    public PayementMethod getPayMethod() {
        return new DirectDepositMethod();
    }
}
