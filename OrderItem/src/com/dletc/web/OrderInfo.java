package com.dletc.web;


import com.dletc.dao.OrdersDao;
import com.dletc.dao.UserDao;
import com.dletc.dao.impl.OrdersDaoImpl;
import com.dletc.dao.impl.UserDaoImpl;
import com.dletc.domain.Dish;
import com.dletc.domain.Orders;
import com.dletc.domain.User;

import java.sql.SQLException;

public class OrderInfo {
    public static void getOrderInfo(Orders orders) {
        try {
            System.out.println("-----------------订单详情-----------------");
            System.out.println("订单编号" + orders.getOrderID());
            //根据用户id查询订单信息
            OrdersDao ordersDao = new OrdersDaoImpl();
            Orders o = ordersDao.selectByOrderId(orders.getOrderID());
            //获取用户名
            UserDao userDao = new UserDaoImpl();
            User user = userDao.SelectUserByID(orders.getUserID());
            System.out.println("用户编号" + user.getUserName());
            System.out.println("下单时间" + o.getOrderTime());
            System.out.println("菜品名称");
            System.out.println("编号\t名称\t价格");
            int sum = 0;
            for (Dish dish : o.getDish()) {
                System.out.println(dish.getDishID() + "\t" + dish.getDishName() + "\t" + dish.getDishMoney());
                sum += dish.getDishMoney();
            }
            System.out.println("总价" + sum);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
