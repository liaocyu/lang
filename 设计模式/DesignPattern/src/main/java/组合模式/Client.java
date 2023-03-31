package 组合模式;

public class Client {
    public static void main(String[] args) {
        Department department1 = new Department("财管", "...");
        Department department2 = new Department("经贸", "...");
        Department department3 = new Department("计算机", "...");
        Department department4 = new Department("新闻", "...");
        College college1 = new College("人文", "...");
        College college2 = new College("计算机", "...");
        College college3 = new College("商院", "...");
        University university = new University("大学","...");
        university.add(college1);
        university.add(college2);
        university.add(college3);
        college1.add(department4);
        college2.add(department3);
        college3.add(department1);
        college3.add(department2);
        university.print();
    }
}
