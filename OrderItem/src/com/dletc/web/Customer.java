package com.dletc.web;

import com.dletc.dao.DishDao;
import com.dletc.dao.OrdersDao;
import com.dletc.dao.impl.DishDaoImpl;
import com.dletc.dao.impl.OrdersDaoImpl;
import com.dletc.domain.Dish;
import com.dletc.domain.Orders;
import com.dletc.domain.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Customer {
    static Orders orders = new Orders();

    public static void normalCus(User user) throws SQLException {
        boolean flag = true;

        while (flag) {
            System.out.println("---------点菜模块---------");
            System.out.println("欢迎" + user.getUserName() + "用户登录");
            System.out.println("1 点菜 2 查看订单 3 返回上一级");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的选择：");
            int choice = sc.nextInt();
            //创建一个菜品dao对象
            DishDao dishDao = new DishDaoImpl();
            //创建一个菜品集合
            ArrayList<Dish> dishList = new ArrayList<>();
            switch (choice) {
                case 1:
                    //查询所有菜品
                    List<Dish> list = dishDao.GetAll();
                    System.out.println("菜品编号\t菜品名称\t菜品价格");
                    //遍历菜品集合
                    for (Dish dish : list) {
                        System.out.println(dish.getDishID() + "\t" + dish.getDishName() + "\t" + dish.getDishMoney() + "\t");
                    }
                    System.out.println("请使用菜品编号点菜,多个用逗号隔开");
                    String dishID = sc.next();

                    //调用字符串的分隔方法
                    String[] arr = dishID.split(",");

                    //遍历数组，拿到菜品编号
                    for (String id : arr) {
                        //根据菜品编号查询菜品
                        Dish dish = dishDao.SelectDishByDishID(Integer.valueOf(id));
                        //把当前查到的一个菜品放入集合中
                        dishList.add(dish);
                    }
//                    System.out.println(dishList);
                    //下订单

                    //生成一个订单编号
                    int ordersId = (int) new Date().getTime();

                    orders.setOrderID(ordersId);
                    orders.setUserID(user.getUserID());
                    orders.setIsdown(1);//已下单
                    orders.setDish(dishList);
                    System.out.println("生成订单");
//                    System.out.println(orders);
                    //提交订单，把订单的信息
                    OrdersDao ordersDao = new OrdersDaoImpl();
                    ordersDao.AddOrders(orders);
                    break;
                case 2:
                    //调用查看订单的方法
                    OrderInfo.getOrderInfo(orders);
                    break;
                case 3:
                    flag = false;
                    break;

            }
        }
    }


}