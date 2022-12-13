import com.jinzheng.pojo.Book;

import com.jinzheng.pojo.User;
import com.jinzheng.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // Æô¶¯springÈÝÆ÷
@ContextConfiguration(locations = {"classpath:application-service.xml", "classpath:applicationContext_mapper.xml"})
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSelectByUser(){
        User user = new User(null,null,"ranok666");
        User res = userService.selectByUser(user);
        System.out.println(res);
    }

    @Test
    public void testAddUser(){
        User user = new User(1,"demo","123456");
        userService.addUser(user);
    }

    @Test
    public void testDeleteUser(){
        User user = new User(null,"arnok",null);
        userService.deleteUser(user.getUsername());
    }

    @Test
    public void testUpdateUser(){
        User user = new User(2,"admin","ranok666");
        userService.updateUser(user);
    }
}
