package com.dletc.domain;

public class Dish {
    private int DishID;
    private String DishName;
    private int DishMoney;

    public Dish() {
    }

    public Dish(int dishID, String dishName, int dishMoney) {
        DishID = dishID;
        DishName = dishName;
        DishMoney = dishMoney;
    }

    public int getDishID() {
        return DishID;
    }

    public void setDishID(int dishID) {
        DishID = dishID;
    }

    public String getDishName() {
        return DishName;
    }

    public void setDishName(String dishName) {
        DishName = dishName;
    }

    public int getDishMoney() {
        return DishMoney;
    }

    public void setDishMoney(int dishMoney) {
        DishMoney = dishMoney;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "DishID=" + DishID +
                ", DishName='" + DishName + '\'' +
                ", DishMoney=" + DishMoney +
                '}';
    }
}
