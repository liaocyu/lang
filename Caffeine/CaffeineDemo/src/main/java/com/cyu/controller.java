package com.cyu;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cyu.annotition.DoubleCache;
import com.cyu.domain.Orders;
import com.cyu.enums.CacheType;
import com.cyu.mapper.OrderMapper;
import com.cyu.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class controller {


    @Resource
    private OrderService orderService;

    @Resource
    private OrderMapper orderMapper;


    @DoubleCache(cacheName = "order", key = "#id",
            type = CacheType.FULL)
    @GetMapping("/getorder")
    public Orders getOrderById(@RequestParam Long id) {
        // Long ids = id;
        // System.out.println(ids);
        Orders myOrders = orderMapper.selectOne(new LambdaQueryWrapper<Orders>()
                .eq(Orders::getId, id));
        System.out.println(myOrders);
        return myOrders;
    }

    @DoubleCache(cacheName = "orders",key = "#orders.id",
            type = CacheType.PUT)
    @PostMapping("/updateOrder")
    public Orders updateOrder(@RequestBody Orders orders) {
        orderMapper.updateById(orders);
        return orders;
    }

    @DoubleCache(cacheName = "order",key = "#id",
            type = CacheType.DELETE)
    @PostMapping("/deleteOrder")
    public void deleteOrder(@RequestParam Long id) {
        orderMapper.deleteById(id);
    }

}
