package com.jinzheng.service;

import com.jinzheng.pojo.Book;

import java.util.List;

public interface BookService {
    // 指定id查找书目
    public Book findBookById(Integer id);

    // 添加图图书的信息
    void addBook(Book book);
    //更新（修改）图书信息
    void updateBook(Book book);

    // 根据主键Id删除图书信息
    void deleteById(Integer id);
//
    // 显示所有书目
    List<Book> findAll();

    //根据图书信息去模糊查询图书信息(动态SQL)
    List<Book> queryList(Book book);
}
