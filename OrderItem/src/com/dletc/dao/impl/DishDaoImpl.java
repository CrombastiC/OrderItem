package com.dletc.dao.impl;

import com.dletc.dao.DishDao;
import com.dletc.domain.Dish;
import com.dletc.utils.DBUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class DishDaoImpl implements DishDao {
    //创建数据库连接，并可以对数据库执行增删改查
    QueryRunner runner = new QueryRunner(DBUtils.getDataSource());

    // 增加菜品
    @Override
    public void AddDish(Dish dish) throws SQLException {

        //1 定义sql语句
        String sql = "insert into Dish values(null,?,?)";
        //2 执行添加，返回结果
        int len = runner.update(sql, dish.getDishName(), dish.getDishMoney());
        //3处理结果
        System.out.println(len == 1 ? "添加菜品成功" : "添加菜品失败");
    }

    //根据ID删除菜品
    @Override
    public void deleteDishById(int DishID) throws SQLException {
        //1 定义sql语句
        String sql = "delete from Dish where DishID=?";
        //2 执行添加，返回结果
        int len = runner.update(sql, DishID);
        //3处理结果
        System.out.println(len == 1 ? "删除菜品成功" : "删除菜品失败");
    }

    //查询所有菜品
    @Override
    public List<Dish> GetAll() throws SQLException {
        //1 定义sql语句
        String sql = "select * from Dish";
        //2 执行查询所有，返回结果集
        List<Dish> list = runner.query(sql, new BeanListHandler<Dish>(Dish.class));
        //3 处理结果，查到了返回list对象，没查到返回空
        return list != null ? list : null;
    }


    //根据ID查询菜品
    @Override
    public Dish GetOneByID(int dishID) throws SQLException {
        //1 定义sql语句
        String sql = "select * from Dish where dishID = ?";
        //2 执行查询，返回一条记录
        Dish dish = runner.query(sql, new BeanHandler<Dish>(Dish.class), dishID);
        //3 处理结果，查到了返回dish对象，没查到返回空
        return dish != null ? dish : null;
    }

    //根据ID修改商品价格
    @Override
    public void UpdateDishMoney(int DishID, int money) throws SQLException {

        //1 定义sql语句
        String sql = "update Dish set DishMoney =? where DishID=?";
        //2 执行sql语句，返回结果
        int len = runner.update(sql, money, DishID);
        //3处理结果
        System.out.println(len == 1 ? "修改价格成功" : "修改价格失败");
    }


    @Override
    public Dish SelectDishByDishID(int DishID) throws SQLException {
        //1 定义sql语句
        String sql = "select * from Dish where DishID=?";
        //2 执行查询，返回一条记录
        Dish dish = runner.query(sql, new BeanHandler<Dish>(Dish.class), DishID);
        //3 处理结果，查到了返回dish对象，没查到返回空
        return dish != null ? dish : null;
    }
}
