package 状态模式;

public class DispenseState extends State{
    private RaffleActivity activity;

    public DispenseState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("您已经获奖，请领取奖品");
    }

    @Override
    public boolean raffle() {
        System.out.println("您已经获奖，请领取奖品");
        return false;
    }

    @Override
    public void dispensePrize() {
        if(activity.getCount()>0){
            System.out.println("恭喜领奖成功");
            activity.setCount(activity.getCount()-1);
            activity.setState(activity.getNoRaffleState());
        }else {
            System.out.println("很遗憾奖品发完了");
            activity.setState(activity.getDispenseOutState());
        }
    }
}
