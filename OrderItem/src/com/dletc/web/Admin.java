package com.dletc.web;

import com.dletc.dao.DishDao;
import com.dletc.dao.impl.DishDaoImpl;
import com.dletc.domain.Dish;
import com.dletc.domain.User;

import java.util.Scanner;

public class Admin {
    public static void adminUser(User user) {
        while (true) {
            System.out.println("欢迎管理员" + user.getUserName() + "登录");
            //管理员的操作
            //实现对菜品的增删改查
            System.out.println("1 增加菜品 2 删除菜品 3 修改菜品 4 查询菜品 5 退出 6 返回上一级");
            //接收用户的选择
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            //根据用户的选择实现不同的分支
            switch (choice) {
                case 1:
                    //增加菜品
                    //接收菜品的信息
                    System.out.println("请输入菜品名称");
                    String dishName = sc.next();
                    System.out.println("请输入菜品价格");
                    int dishMoney = sc.nextInt();
                    //创建DishDao对象
                    DishDao dishDao = new DishDaoImpl();
                    //创建dish对象
                    Dish dish = new Dish();
                    dish.setDishName(dishName);
                    dish.setDishMoney(dishMoney);
                    //调用添加菜品的方法
                    try {
                        dishDao.AddDish(dish);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    //删除菜品
                    //接收菜品的信息
                    System.out.println("请输入菜品ID");
                    int dishID = sc.nextInt();
                    //创建DishDao对象
                    DishDao dishDao1 = new DishDaoImpl();
                    //调用删除菜品的方法
                    try {
                        dishDao1.deleteDishById(dishID);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                    break;
                case 3:
                    //修改菜品
                    //接收菜品的信息
                    System.out.println("请输入菜品ID");
                    int dishID1 = sc.nextInt();
                    System.out.println("请输入菜品价格");
                    int dishMoney1 = sc.nextInt();
                    //创建DishDao对象
                    DishDao dishDao2 = new DishDaoImpl();
                    //调用修改菜品的方法
                    try {
                        dishDao2.UpdateDishMoney(dishID1, dishMoney1);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 4:
                    //查询菜品
                    //接收菜品的信息
                    System.out.println("请输入菜品ID");
                    int dishID2 = sc.nextInt();
                    //创建DishDao对象
                    DishDao dishDao3 = new DishDaoImpl();
                    //调用查询菜品的方法
                    try {
                        Dish dish1 = dishDao3.GetOneByID(dishID2);
                        System.out.println(dish1.getDishID() + " " + dish1.getDishName() + " " + dish1.getDishMoney());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 5:
                    //退出
                    System.exit(0);
                    break;
                case 6:
                    //返回上一级
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }
}
