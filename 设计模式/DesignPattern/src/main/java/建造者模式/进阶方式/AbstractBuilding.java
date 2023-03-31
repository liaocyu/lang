package 建造者模式.进阶方式;

//对应Builder抽象建造者
public abstract class AbstractBuilding {
    protected Building building = new Building();

    //将建造的流程写好，抽象方法
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void buildRoof();

    //建造好房子之后将房子返回
    public Building buildBuilding(){
        return building;
    }
}
