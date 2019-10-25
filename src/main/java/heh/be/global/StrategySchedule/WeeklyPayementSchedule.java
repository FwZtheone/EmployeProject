package heh.be.global.StrategySchedule;

public class WeeklyPayementSchedule implements PayementSchedule {
    @Override
    public PayementSchedule choiceDate() {
        return new WeeklyPayementSchedule();
    }
}
