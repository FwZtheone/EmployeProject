package StrategyPayement;

public class MailMethod implements PayementMethod {

    private String mail;
    private String phrase;

    public MailMethod(String mail){
        this.mail = mail;
    }


    public MailMethod(){

    }

    @Override
    public PayementMethod getPayMethod() {
        return new MailMethod();
    }
}
