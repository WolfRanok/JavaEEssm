package com.jinzheng.dao;

import com.jinzheng.pojo.Book;

import java.util.List;

/***
 * 该类中添加相关数据库操作
 */
public interface BookMapper {
    //根据主键id查询信息
    Book findBookById(Integer id);

    //添加图图书的信息
    void addBook(Book book);
//
    //更新（修改）图书信息
    void updateBook(Book book);

    //根据主键Id删除图书信息
    void deleteById(Integer id);

    //根据图书信息去模糊查询图书信息(动态SQL)
    List<Book> queryList(Book book);

    // 显示所有书目
    List<Book> findAll();
}
