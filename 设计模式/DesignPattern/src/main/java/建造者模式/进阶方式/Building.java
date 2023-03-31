package 建造者模式.进阶方式;

//对应product产品角色

/**
 * 建造过程 将产品与建造过程分开
 */
public class Building {
    private String basic;
    private String wall;
    private String roof;

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getRoof() {
        return roof;
    }

    public void setRoof(String roof) {
        this.roof = roof;
    }

    @Override
    public String toString() {
        return "Building{" +
                "basic='" + basic + '\'' +
                ", wall='" + wall + '\'' +
                ", roof='" + roof + '\'' +
                '}';
    }
}
