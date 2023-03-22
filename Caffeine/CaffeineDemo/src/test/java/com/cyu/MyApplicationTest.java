package com.cyu;

import com.cyu.domain.Orders;
import com.cyu.utils.ExpressionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.TreeMap;





@SpringBootTest
public class MyApplicationTest {

    @Test
    public void test() {
        String elString="#orders.money";
        String elString2="#user";
        String elString3="#p0";

        TreeMap<String,Object> map=new TreeMap<>();
        Orders orders = new Orders();
        orders.setId(111L);
        orders.setMoney(123D);
        map.put("order", orders);
        map.put("user","Hydra");

        String val = ExpressionUtils.parse(elString, map);
        String val2 = ExpressionUtils.parse(elString2, map);
        String val3 = ExpressionUtils.parse(elString3, map);

        System.out.println(val);
        System.out.println(val2);
        System.out.println(val3);
    }
}