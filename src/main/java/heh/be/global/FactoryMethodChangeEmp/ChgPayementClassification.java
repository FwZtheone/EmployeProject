package heh.be.global.FactoryMethodChangeEmp;

import heh.be.global.StrategyClassification.PayementClassification;
import heh.be.global.StrategySchedule.PayementSchedule;
import heh.be.global.Employe;

public abstract class ChgPayementClassification extends ChangeEmploye {

    public ChgPayementClassification(int id) {
        super(id);
    }

    public abstract PayementClassification makePayementClassification();
    public abstract PayementSchedule makePayementShedule();

    @Override
    public void change(Employe e) {
        e.setPayClassification(makePayementClassification());
        e.setPaySchedule(makePayementShedule());
    }
}
