package 状态模式;

public class RaffleActivity {
    private State state;
    private Integer count;
    private State noRaffleState = new NoRaffleState(this);
    private State canRaffleState = new CanRaffleState(this);
    private State dispenseState = new DispenseState(this);
    private State dispenseOutState = new DispenseOutState(this);

    public RaffleActivity(Integer count) {
        this.count = count;
        this.state = noRaffleState;
    }

    public void raffle(){
        if(state.raffle()){
            state.dispensePrize();
        }
    }

    public void deduce(){
        state.deduceMoney();
    }
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public State getNoRaffleState() {
        return noRaffleState;
    }

    public void setNoRaffleState(State noRaffleState) {
        this.noRaffleState = noRaffleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(State canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(State dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getDispenseOutState() {
        return dispenseOutState;
    }

    public void setDispenseOutState(State dispenseOutState) {
        this.dispenseOutState = dispenseOutState;
    }
}
