package com.cyu.service;

import com.cyu.domain.Orders;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Halo
* @description 针对表【order】的数据库操作Service
* @createDate 2023-02-25 16:55:02
*/
public interface OrderService extends IService<Orders> {

    Orders getOrderById(Long id);
}
