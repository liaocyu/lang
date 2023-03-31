package 迭代器模式;

import java.util.Iterator;

public class ComputerCollegeIterator implements Iterator {
    //这里我们需要知道Department是以什么方式存储的，假设这里是以数组来存储的
    private Department[] departments;
    private int position = 0;

    public ComputerCollegeIterator(Department[] departments) {
        this.departments = departments;
    }

    @Override
    public boolean hasNext() {
        if(position>=departments.length||departments[position]==null){
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        return departments[position++];
    }
}
