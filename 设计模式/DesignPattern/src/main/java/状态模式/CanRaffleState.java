package 状态模式;

import java.util.Random;

public class CanRaffleState extends State{
    private RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    @Override
    public void deduceMoney() {
        System.out.println("您已经可以抽奖了");
    }

    @Override
    public boolean raffle() {
        System.out.println("正在抽奖，请稍后");
        Random random = new Random();
        int i = random.nextInt(10);
        if(i==0){
            activity.setState(activity.getDispenseState());
            return true;
        }
        System.out.println("很遗憾您没有中奖");
        activity.setState(activity.getNoRaffleState());
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
