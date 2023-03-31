package 状态模式;

public class DispenseOutState extends State{
    private RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("奖品已抽完");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品已抽完");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品已抽完");
    }
}
