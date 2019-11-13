package heh.be.global.StrategyPayement;

import heh.be.global.PayDay.Paycheck;

public class MailMethod implements PayementMethod {

    public void setMail(String mail) {
        this.mail = mail;
    }

    private String mail;

    public MailMethod(String mail){
        this.mail = mail;
    }


    public MailMethod(){

    }

    @Override
    public PayementMethod getPayMethod() {
        return new MailMethod();
    }

    @Override
    public void pay(Paycheck pc) {
        pc.setDisposition(this.toString());
    }

    @Override
    public String toString(){
        return "mail : "+this.mail;
    }
}
