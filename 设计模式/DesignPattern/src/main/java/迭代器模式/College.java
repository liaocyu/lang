package 迭代器模式;

import java.util.Iterator;

public interface College {
    String getName();
    void addDepartment(String name,String desc);
    Iterator getIterator();
}
