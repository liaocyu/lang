package 建造者模式.传统方式;

public class CommonBuilding extends AbstractBuilding{

    @Override
    public void buildBasic() {
        System.out.println(" 普通房子打地基 ");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 普通房子砌墙 ");
    }

    @Override
    public void buildRoof() {
        System.out.println(" 普通房子堆顶 ");
    }
}
