package com.dletc.web;

import com.dletc.dao.UserDao;
import com.dletc.dao.impl.UserDaoImpl;
import com.dletc.domain.User;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * 首页
 */
public class Home {
    public static void main(String[] args) {
        while (true) {
            System.out.println("欢迎进入鼎香园");
            System.out.println("1 登录 2 注册 3 退出");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的选择：");
            int choice = sc.nextInt();
            //根据选项实现不同的分支
            switch (choice) {
                case 1:
                    //登录
                    login();
                    break;
                case 2:
                    //注册
                    register();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }

    //注册的方法
    private static void register() {
        System.out.println("---------注册模块---------");
        Scanner sc = new Scanner(System.in);
        System.out.println("请设置用户名");
        System.out.println("请设置密码");
        System.out.println("请确认密码");
        System.out.println("请设置是否为管理员，0：普通用户 1：管理员");
        //接收数据
        String username = sc.next();
        String password = sc.next();
        String repassword = sc.next();
        int isAdmin = sc.nextInt();
        //判断数据库中是否存在该用户
        try {
            //创建UserDao对象
            UserDao userDao = new UserDaoImpl();
            //调用查询的方法
            User user = userDao.SelectUserByUserName(username);
            if (user == null) {
                //不存在
                if (password.equals(repassword)) {
                    //密码一致
                    //创建User对象
                    User user1 = new User(0, username, password, isAdmin);
                    //调用注册的方法
                    userDao.addUser(user1);
                } else {
                    //密码不一致
                    System.out.println("两次密码不一致，请重新注册");
                }
            } else {
                //存在
                System.out.println("用户名已存在，请重新注册");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //登录的方法
    private static void login() {
        try {
            System.out.println("---------登录模块---------");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名");

            //接收数据
            String username = sc.next();

            //调用登录的方法
            //创建UserDao对象
            UserDao userDao = new UserDaoImpl();
            User user = userDao.SelectUserByUserName(username);

            //根据user的值判断用户是否存在
            if (user == null) {
                //不存在
                System.out.println("用户名不存在，请注册");
//                register();
            } else {
                System.out.println("请输入密码");
                String password = sc.next();
                //判断密码是否正确
                if (user.getPassWord().equals(password)) {
                    //正确
                    System.out.println("登录成功");
                    //判断是否为管理员
                    if (user.getIsAdmin() == 1) {
//                        //管理员
//                        System.out.println("欢迎管理员" + user.getUserName() + "登录");
                        //调用管理员的方法
                        Admin.adminUser(user);
                    } else {
//                        //普通用户
//                        System.out.println("欢迎" + user.getUserName() + "登录");
                        //调用普通用户的方法
                        Customer.normalCus(user);
                    }
                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}