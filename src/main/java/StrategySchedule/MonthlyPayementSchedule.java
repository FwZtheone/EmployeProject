package StrategySchedule;

public class MonthlyPayementSchedule implements PayementSchedule {
    @Override
    public PayementSchedule choiceDate() {
        return new MonthlyPayementSchedule();
    }
}
