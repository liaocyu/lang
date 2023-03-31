package 迭代器模式;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        ComputerCollege computerCollege = new ComputerCollege();
        InfoCollege infoCollege = new InfoCollege();
        List<College> list = new ArrayList<>();
        list.add(computerCollege);
        list.add(infoCollege);
        OutputImpl output = new OutputImpl(list);
        output.printCollege();
    }
}
