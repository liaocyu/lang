package 建造者模式.进阶方式;

//对应ConcreteBuilder具体建造者
public class HighBuilding extends AbstractBuilding{
    @Override
    public void buildBasic() {
        System.out.println("高建筑打地基");
        building.setBasic("高地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("高建筑造墙");
        building.setWall("高墙");
    }

    @Override
    public void buildRoof() {
        System.out.println("高建筑造屋顶");
        building.setRoof("高屋顶");
    }
}
