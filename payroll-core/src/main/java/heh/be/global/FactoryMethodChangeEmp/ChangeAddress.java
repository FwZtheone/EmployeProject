package heh.be.global.FactoryMethodChangeEmp;

import heh.be.global.Employe;

public class ChangeAddress extends  ChangeEmploye {

    String address;

    public String getAddress() {
        return address;
    }

    public ChangeAddress(int id, String address) {
        super(id);
        this.address = address;
    }

    @Override
    public void change(Employe e) {
        e.setAddress(this.address);

    }
}
