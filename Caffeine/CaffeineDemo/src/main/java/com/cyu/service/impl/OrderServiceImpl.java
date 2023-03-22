package com.cyu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyu.domain.Orders;
import com.cyu.service.OrderService;
import com.cyu.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author Halo
* @description 针对表【order】的数据库操作Service实现
* @createDate 2023-02-25 16:55:02
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Orders>
    implements OrderService{

    @Override
    public Orders getOrderById(Long id) {
        return null;
    }
}




