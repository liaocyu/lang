package 迭代器模式;

import java.util.Iterator;
import java.util.List;

public class OutputImpl {
    List<College> collegeList;

    public OutputImpl(List<College> collegeList) {
        this.collegeList = collegeList;
    }

    public void printCollege(){
        for (College college:collegeList){
            Iterator iterator = college.getIterator();
            System.out.println("===========");
            System.out.println(college.getName());
            printDepartment(iterator);
        }
    }
    public void printDepartment(Iterator iterator){
        while (iterator.hasNext()){
            Department department = (Department) iterator.next();
            System.out.println(department.getName());
        }
    }
}
