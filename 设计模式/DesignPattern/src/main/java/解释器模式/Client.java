package 解释器模式;

import java.util.HashMap;
import java.util.Map;

public class Client {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 20);
        map.put("c", 30);
        map.put("d", 40);
        Calculator calculator = new Calculator("a+b+c+d");
        int run = calculator.run(map);
        System.out.println(run);
    }
}
