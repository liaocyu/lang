package 建造者模式.传统方式;

public abstract class AbstractBuilding {
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void buildRoof();
    public void build(){
        buildBasic();
        buildWalls();
        buildRoof();
    }
}
