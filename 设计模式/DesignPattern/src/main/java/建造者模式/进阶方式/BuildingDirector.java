package 建造者模式.进阶方式;

//对应Director指挥者
public class BuildingDirector {
    private AbstractBuilding abstractBuilding;

    //构造器传入AbstractBuilding
    public BuildingDirector(AbstractBuilding abstractBuilding){
        this.abstractBuilding = abstractBuilding;
    }

    //setter传入AbstractBuilding
    public void setAbstractBuilding(AbstractBuilding abstractBuilding){
        this.abstractBuilding = abstractBuilding;
    }

    //如何处理建造房子的流程，交给指挥者
    public Building constructBuilding(){
        abstractBuilding.buildBasic();
        abstractBuilding.buildWalls();
        abstractBuilding.buildRoof();
        return abstractBuilding.buildBuilding();
    }

    public BuildingDirector(){}
}
