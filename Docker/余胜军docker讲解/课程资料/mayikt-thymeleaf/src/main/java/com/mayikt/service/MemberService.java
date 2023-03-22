package com.mayikt.service;


import com.mayikt.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName MemberService
 * @Author 蚂蚁课堂余胜军 QQ644064779 www.mayikt.com
 * @Version V1.0
 **/
@RestController
@Slf4j
public class MemberService {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String myIndex(){
        return "...我是会员服务..";
    }

    /**
     * http://192.168.163.129:38000/mayikt/insertUser?userName=mayikt&userAge=22
     * @param userName
     * @param userAge
     * @return
     */
    @RequestMapping("/insertUser")
    public String insertUser(String userName,Integer userAge){
        // 获取request对象
        HttpServletRequest request = ((ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes()).getRequest();

        return userMapper.insertUser(userName,userAge)>0?"success":"fail";
    }
}
