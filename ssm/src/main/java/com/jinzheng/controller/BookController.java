package com.jinzheng.controller;

import com.jinzheng.pojo.Book;
import com.jinzheng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller  //通过注解将Controller放入Bean中管理
public class BookController {
    @Autowired  //注解注入BookService,实现调用
    private BookService bookService;

    @RequestMapping("/allBook")
    public ModelAndView book() {
        //新建一个显示该数据的视图 modelAndView
        ModelAndView modelAndView = new ModelAndView();
        //新建一个集合对象 bookList 用来存储 调用queryList方法返回的数据
        List<Book> bookList = bookService.findAll();

        //从控制器类向前端页面跳转时，指定传递的页面：allBook
        modelAndView.setViewName("allBook");

        //在创建的html页面里,可以通过${bookList}，定位到bookList。
        modelAndView.addObject("bookList", bookList);

        return modelAndView;
    }

    @RequestMapping("/toAddBook")
    public String toAddBook(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Book book){
        bookService.addBook(book);
        return "redirect:allBook";
    }

    @RequestMapping("/toUpdateBook")
    public ModelAndView toUpdateBook(Integer id){
        ModelAndView modelAndView = new ModelAndView();
        Book book = bookService.findBookById(id);

        modelAndView.setViewName("updateBook");
        // 提交参数
        modelAndView.addObject("book",book);
        return modelAndView;
    }

    @RequestMapping("/updateBook")
    public String updateBook(Book book){
        bookService.updateBook(book);
        return "redirect:allBook";
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(Integer id){
        bookService.deleteById(id);
        return "redirect:allBook";
    }

    @RequestMapping("/queryBookByName")
    public ModelAndView queryBookByName(String name){
        ModelAndView modelAndView = new ModelAndView();     // 获取窗口对象
        List<Book> bookList = bookService.queryList(new Book(null,name,null,null,null));
        modelAndView.setViewName("allBook");
        modelAndView.addObject("bookList",bookList);
        return modelAndView;
    }
}
