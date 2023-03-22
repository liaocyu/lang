package com.mayikt.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

   @Insert("INSERT INTO `users` VALUES (null,#{userName},#{userAge}); ")
   int insertUser(@Param("userName") String userName,@Param("userAge") Integer userAge);
}
