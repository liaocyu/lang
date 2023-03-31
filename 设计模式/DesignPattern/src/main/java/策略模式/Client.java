package 策略模式;

import java.util.Comparator;

public class Client {
    public static void main(String[] args) {
        WildDuck wildDuck = new WildDuck();
        wildDuck.fly();
        Comparator<Object> objectComparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }
        };

    }
}
