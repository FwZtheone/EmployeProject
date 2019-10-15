package StrategySchedule;

public class WeeklyPayementSchedule implements PayementSchedule {
    @Override
    public PayementSchedule choiceDate() {
        return new WeeklyPayementSchedule();
    }
}
