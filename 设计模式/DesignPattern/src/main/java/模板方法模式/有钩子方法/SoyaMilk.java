package 模板方法模式.有钩子方法;

public abstract class SoyaMilk {
    public final void make(){
        select();
        if(wantCondiment()){
            add();
        }
        soak();
        beat();
    }

    public void select(){
        System.out.println("选择好豆子");
    }

    public void beat(){
        System.out.println("锤豆子");
    }

    public void soak(){
        System.out.println("泡豆子和材料");
    }

    public abstract void add();

    public boolean wantCondiment(){
        return true;
    }
}
