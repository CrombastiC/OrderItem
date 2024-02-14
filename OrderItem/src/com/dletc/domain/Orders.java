package com.dletc.domain;

import java.util.Date;
import java.util.List;

//在这个类中要体现出订单与菜品之间的一对多关系
public class Orders {
    private int orderID;//订单ID
    private int userID;//用户ID

    private Date orderTime;//订单时间

    private int isdown;//是否完成
    //实现订单与菜品之间的一对多关系，一个订单可以包含多个菜品
    private List<Dish> dish;

    public Orders() {
    }

    public Orders(int orderID, int userID, Date orderTime, int isdown, List<Dish> dish) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderTime = orderTime;
        this.isdown = isdown;
        this.dish = dish;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public int getIsdown() {
        return isdown;
    }

    public void setIsdown(int isdown) {
        this.isdown = isdown;
    }

    public List<Dish> getDish() {
        return dish;
    }

    public void setDish(List<Dish> dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", userID=" + userID +
                ", orderTime=" + orderTime +
                ", isdown=" + isdown +
                ", dish=" + dish +
                '}';
    }


}
