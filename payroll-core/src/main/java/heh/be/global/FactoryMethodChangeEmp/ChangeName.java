package heh.be.global.FactoryMethodChangeEmp;


import heh.be.global.Employe;

public  class ChangeName extends ChangeEmploye {

    private String name;
    private double salary;
    public String getName() {
        return name;
    }



    public ChangeName(int id, String name) {
        super(id);
        this.name = name;
    }



    @Override
    public void change(Employe e) {
        e.setName(name);


    }
}
