package heh.be.global.StrategySchedule;

public class TwoWeekPay  implements  PayementSchedule{
    @Override
    public PayementSchedule choiceDate() {
        return new TwoWeekPay();
    }
}
