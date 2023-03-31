package 迭代器模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InfoCollege implements College{
    private List<Department> departmentList;

    @Override
    public String toString() {
        return "InfoCollege{" +
                "departmentList=" + departmentList +
                '}';
    }

    public InfoCollege() {
        departmentList = new ArrayList<>();
        addDepartment("信息","信息");
        addDepartment("电信","电信");
    }

    @Override
    public String getName() {
        return "信息学院";
    }

    @Override
    public void addDepartment(String name, String desc) {
        departmentList.add(new Department(name,desc));
    }

    @Override
    public Iterator getIterator() {
        return new InfoCollegeIterator(departmentList);
    }
}
