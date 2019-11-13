package heh.be.global.StrategySchedule;

import java.time.LocalDate;

public interface PayementSchedule {
    public PayementSchedule choiceDate();
    public boolean isPayDate(LocalDate date);
}
