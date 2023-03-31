package 迭代器模式;

import java.util.Arrays;
import java.util.Iterator;

public class ComputerCollege implements College{
    Department[] departments;
    int numOfDepartment = 0;

    public ComputerCollege() {
        departments = new Department[5];
        addDepartment("java","java");
        addDepartment("php","php");
        addDepartment("c++","c++");
        addDepartment("js","js");

    }

    @Override
    public String toString() {
        return "ComputerCollege{" +
                "departments=" + Arrays.toString(departments) +
                ", numOfDepartment=" + numOfDepartment +
                '}';
    }

    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        Department department = new Department(name, desc);
        departments[numOfDepartment++] = department;
    }

    @Override
    public Iterator getIterator() {
        return new ComputerCollegeIterator(departments);
    }
}
