package com.dletc.dao.impl;

import com.dletc.dao.UserDao;
import com.dletc.domain.User;
import com.dletc.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * 用户接口实现类：
 * 连接数据库，完成三个抽象方法的增加和查询代码
 */
public class UserDaoImpl implements UserDao {
    //创建数据库连接池对象
    QueryRunner qr = new QueryRunner(DBUtils.getDataSource());

    //增加用户
    @Override
    public void addUser(User user) throws SQLException {
        //定义sql语句
        String sql = "insert into user values(null,?,?,?)";
        //执行sql语句
        int len = qr.update(sql, user.getUserName(), user.getPassWord(), user.getIsAdmin());
        //处理结果
        System.out.println(len == 1 ? "注册成功" : "注册失败");//三元运算符

    }

    //根据姓名查询用户
    @Override
    public User SelectUserByUserName(String UserName) throws SQLException {
        //定义sql语句
        String sql = "select * from user where username=?";
        //执行sql语句
        User user = null;
        user = qr.query(sql, new BeanHandler<User>(User.class), UserName);

        //处理结果
        return user != null ? user : null;

    }

    //根据ID查询用户
    @Override
    public User SelectUserByID(int UserID) throws SQLException {
        //定义sql语句
        String sql = "select * from user where UserID=?";
        //执行sql语句
        User user = null;
        user = qr.query(sql, new BeanHandler<User>(User.class), UserID);
        //处理结果
        return user != null ? user : null;
    }

    //根据姓名和密码查询用户
    @Override
    public User SelectUserByUserNameAndPassword(String UserName, String PassWord) throws SQLException {
        //定义sql语句
        String sql = "select * from user where username=? and password=?";
        //执行sql语句
        User user = null;

        user = qr.query(sql, new BeanHandler<User>(User.class), UserName, PassWord);

        //处理结果
        return user != null ? user : null;
    }


}
