package StrategyPayement;

public class MailMethod implements PayementMethod {

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
    public String toString(){
        return "mail : "+this.mail;
    }
}
