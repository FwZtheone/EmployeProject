package heh.be.global.StrategySchedule;

import java.time.LocalDate;
import java.time.YearMonth;

public class TwoWeekPay  implements  PayementSchedule{
    @Override
    public PayementSchedule choiceDate() {
        return new TwoWeekPay();
    }

    @Override
    public boolean isPayDate(LocalDate date) {
        return false;
    }
}
