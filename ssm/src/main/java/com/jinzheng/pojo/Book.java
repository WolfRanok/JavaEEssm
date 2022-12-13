package com.jinzheng.pojo;

public class Book {
    private Integer id;		//图书id
    private String name;		//图书名称
    private String press;		//出版社
    private String author;		//作者

    private Double bookPrice;   // 书本价格
    public Book(){}
    public Book(Integer id,String name,String press,String author,Double bookPrice){
        this.id = id;
        this.name = name;
        this.press = press;
        this.author = author;
        this.bookPrice = bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                ", bookPrice='" + bookPrice + '\'' +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPress() {
        return press;
    }

    public String getAuthor() {
        return author;
    }
}
