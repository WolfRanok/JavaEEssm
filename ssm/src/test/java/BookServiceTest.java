import com.jinzheng.controller.UserController;
import com.jinzheng.pojo.Book;
import com.jinzheng.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 启动spring容器
@ContextConfiguration(locations = {"classpath:application-service.xml", "classpath:applicationContext_mapper.xml", "classpath:spring-mvc.xml"})
public class BookServiceTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserController userController;

    @Test
    public void textFindBookById() {
        Book book = bookService.findBookById(1);
        // 已重载toString方法
        System.out.println(book);
    }

    @Test
    public void testAddBook() {
        Book book = new Book(3, "Go 入门程序开发", "武昌理工出版社", "Ranok",30.0);
        bookService.addBook(book);
//        System.out.println("入门程序开发");
    }

    @Test
    public void testDeleteById() {
        bookService.deleteById(3);
    }

    @Test
    public void testFindAll() {
        System.out.println(bookService.findAll());
    }

    @Test
    public void testUpdateBook(){
        Book book = new Book(3,"Matlab 数学建模","清华大学出版社","张三",45.0);
        bookService.updateBook(book);
    }

    @Test
    public void testQueryList() {
        Book book = new Book(null, "py", null, null,null);
        System.out.println(bookService.queryList(book));
    }

}
