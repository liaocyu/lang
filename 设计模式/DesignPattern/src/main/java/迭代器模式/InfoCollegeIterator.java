package 迭代器模式;

import java.util.Iterator;
import java.util.List;

public class InfoCollegeIterator implements Iterator {
    private List<Department> list;
    private int position = -1;
    @Override
    public boolean hasNext() {
        if(position>=list.size()-1){
            return false;
        }else {
            position++;
            return true;
        }
    }

    @Override
    public Object next() {
        return list.get(position);
    }

    public InfoCollegeIterator(List<Department> list) {
        this.list = list;
    }
}
