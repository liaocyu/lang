package 建造者模式.进阶方式;

//对应ConcreteBuilder具体建造者
public class CommonBuilding extends AbstractBuilding{
    @Override
    public void buildBasic() {
        System.out.println("普通建筑打地基");
        building.setBasic("普通地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通建筑造墙");
        building.setWall("普通墙");
    }

    @Override
    public void buildRoof() {
        System.out.println("普通建筑造屋顶");
        building.setRoof("普通屋顶");
    }
}
