import com.dletc.dao.UserDao;
import com.dletc.dao.impl.UserDaoImpl;
import com.dletc.domain.User;
import org.junit.Test;

import java.sql.SQLException;

public class UserTest {

    //创建一个接口对象
    UserDao userDao = new UserDaoImpl() {
    };

    //添加测试
    @Test
    public void addUser() {
        try {
            User user = new User(0, "tom", "admin888", 0);
            userDao.addUser(user);
        } catch (SQLException throwables) {
            System.out.println("插入失败，用户名不能重复");
        }
    }

    //查询测试
    @Test
    public void Select() {
        try {
            //根据姓名查询用户
            User user = userDao.SelectUserByUserName("tom");
            System.out.println(user);
            //根据ID查询用户
            User user1 = userDao.SelectUserByID(1);
            System.out.println(user1);
            //根据姓名和密码查询用户
            User user2 = userDao.SelectUserByUserNameAndPassword("tom", "admin888");
            System.out.println(user2);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
