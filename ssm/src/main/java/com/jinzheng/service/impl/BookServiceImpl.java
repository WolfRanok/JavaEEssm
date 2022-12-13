package com.jinzheng.service.impl;

import com.jinzheng.dao.BookMapper;
import com.jinzheng.pojo.Book;
import com.jinzheng.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    // 创建一个数据访问层的对象
    @Autowired
    private BookMapper bookMapper;
    @Override
    public Book findBookById(Integer id) {
        return bookMapper.findBookById(id);
    }

    @Override
    public void addBook(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookMapper.updateBook(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookMapper.deleteById(id);
    }
//
    @Override
    public List<Book> findAll() {
        return bookMapper.findAll();
    }

    @Override
    public List<Book> queryList(Book book) {
        return bookMapper.queryList(book);
    }
}
