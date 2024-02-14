package com.dletc.dao;

import com.dletc.domain.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrdersDao {

    //添加订单
    void AddOrders(Orders orders) throws SQLException;

    //增加数据到orders表里
    void insertOrders(Orders orders) throws SQLException;

    //增加数据到orders_dish表里
    void insertOrdersDish(Orders orders) throws SQLException;

    //查询订单详情
    Orders selectByOrderId(int OrderId) throws SQLException;

}
