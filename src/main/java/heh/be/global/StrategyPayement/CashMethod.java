package heh.be.global.StrategyPayement;

public class CashMethod implements PayementMethod {


    public CashMethod(){}
    @Override
    public PayementMethod getPayMethod() {
        return new CashMethod();
    }
    public String toString(){
        return "cash";
    }
}
