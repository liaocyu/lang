package 建造者模式.进阶方式;

public class Client {
    public static void main(String[] args) {
        BuildingDirector director = new BuildingDirector();
        //盖普通建筑
        director.setAbstractBuilding(new CommonBuilding());
        Building building1 = director.constructBuilding();
        System.out.println(building1);

        //盖高建筑
        director.setAbstractBuilding(new HighBuilding());
        Building building2 = director.constructBuilding();
        System.out.println(building2);
    }
}
