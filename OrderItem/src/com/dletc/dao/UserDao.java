package com.dletc.dao;

import com.dletc.domain.User;

import java.sql.SQLException;

/**
 * 用户接口：
 * 业务 = 增加用户  +  根据姓名查询一个用户 +  根据ID查询一个用户
 */
public interface UserDao {
    void addUser(User user) throws SQLException;//增加用户（注册）


    User SelectUserByUserName(String UserName) throws SQLException;//根据姓名查询用户


    User SelectUserByID(int UserID) throws SQLException; //根据ID查询用户

    User SelectUserByUserNameAndPassword(String UserName, String PassWord) throws SQLException;//根据姓名和密码查询用户（登录业务）
}
