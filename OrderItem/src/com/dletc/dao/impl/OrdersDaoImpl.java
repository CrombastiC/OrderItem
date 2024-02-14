package com.dletc.dao.impl;

import com.dletc.dao.OrdersDao;
import com.dletc.domain.Dish;
import com.dletc.domain.Orders;
import com.dletc.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrdersDaoImpl implements OrdersDao {
    QueryRunner qr = new QueryRunner(DBUtils.getDataSource());

    @Override
    public void AddOrders(Orders orders) throws SQLException {
        //添加前一半数据到orders表里
        insertOrders(orders);
        //添加后一半数据到orders_dish表里
        insertOrdersDish(orders);
    }

    //增加数据到orders表里
    @Override
    public void insertOrders(Orders orders) throws SQLException {
        //执行添加
        String sql = "insert into orders values(?,?,now(),?)";
        //执行添加
        int len = qr.update(sql, orders.getOrderID(), orders.getUserID(), orders.getIsdown());
        System.out.println(len == 1 ? "下单成功" : "下单失败");
    }

    //增加数据到orders_dish表里
    @Override
    public void insertOrdersDish(Orders orders) throws SQLException {

        //获取所有菜品对象
        List<Dish> list = orders.getDish();
        //遍历集合
        for (Dish dish : list) {
            //执行添加
            String sql = "insert into orders_dish values(?,?)";
            //执行添加
            qr.update(sql, orders.getOrderID(), dish.getDishID());

        }
    }

    @Override
    public Orders selectByOrderId(int OrderId) throws SQLException {
        //查询订单表
        String sql = "select * from orders where orderid=?";
        //执行查询
        Orders orders = qr.query(sql, new BeanHandler<Orders>(Orders.class), OrderId);

        //查询菜品与订单关系表
        String sql2 = "select d.*\n" +
                "from orders_dish o\n" +
                "inner join dish d\n" +
                "on  o.dishid=d.DishID\n" +
                "where o.orderid=?";
        List<Dish> list = qr.query(sql2, new BeanListHandler<Dish>(Dish.class), OrderId);
       //把菜品集合放入订单对象中
        orders.setDish(list);
        //返回订单对象
        return orders;
    }


}
