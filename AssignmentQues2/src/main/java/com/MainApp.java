package com;

import Dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring.xml");
        BookDao bdao = (BookDao) applicationContext.getBean("bdao");
//        Book b=new Book();
//        b.setBid(101);
//        b.setBookName("Python");
//        b.setAuthorName("Oreilly");
//        b.setPrice(290);
//        bdao.insert(b);
        bdao.update("Python",1000);


    }
}