package heh.be.global.StrategySchedule;

import java.time.LocalDate;
import java.time.YearMonth;

public class MonthlyPayementSchedule implements PayementSchedule {
    @Override
    public PayementSchedule choiceDate() {
        return new MonthlyPayementSchedule();
    }

    @Override
    public boolean isPayDate(LocalDate date) {
        YearMonth month = YearMonth.from(date);
        LocalDate end = month.atEndOfMonth();
        if(date.isEqual(end)){
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public String toString(){
        return "mois";
    }




}
