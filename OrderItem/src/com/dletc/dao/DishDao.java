package com.dletc.dao;

import com.dletc.domain.Dish;

import java.sql.SQLException;
import java.util.List;

public interface DishDao {

    void AddDish(Dish dish) throws SQLException;//添加菜品

    void deleteDishById(int DishID) throws SQLException;//根据菜品ID删除菜品

    List<Dish> GetAll() throws SQLException;//查询所有菜品

    Dish GetOneByID(int dishID) throws SQLException; //根据ID查询菜品

    void UpdateDishMoney(int DishID, int money) throws SQLException;//修改菜品价格


    //根据菜品ID查询菜品名称
    Dish SelectDishByDishID(int DishID) throws SQLException;
}
