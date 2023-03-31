package 状态模式;

public class NoRaffleState extends State{
    private RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("您已扣除了五十的积分，现在可以抽奖了");
        activity.setState(activity.getCanRaffleState());

    }

    @Override
    public boolean raffle() {
        System.out.println("扣除了积分才能抽奖哦");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
