package heh.be.global.StrategySchedule;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeeklyPayementSchedule implements PayementSchedule {
    @Override
    public PayementSchedule choiceDate() {
        return new WeeklyPayementSchedule();
    }

    @Override
    public boolean isPayDate(LocalDate date) {
        DayOfWeek jour = date.getDayOfWeek();
        int jourInt = jour.getValue();
        if(jourInt ==5){
            return true;
        }
        else{
             return false;
        }
    }
}
