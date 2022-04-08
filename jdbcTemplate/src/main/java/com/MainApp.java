package com;

import Dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring.xml");
BookDao bdao= (BookDao) applicationContext.getBean("bdao");

do {
    System.out.println("1.INSERT\n2.UPDATE\n3.DELETE\n4.SHOW-ALL\n5.SHOW-BY\n6.LIKE\n7.BETWEEN\n8.EXIT");
    int ch= Integer.parseInt(br.readLine());
    switch(ch){
        case 1:
            Book b=new Book();
            b.setBookName(br.readLine());
            b.setAuthorName(br.readLine());
            b.setPrice(Float.parseFloat(br.readLine()));
            int i=bdao.insert(b);
            if(i>0)
                System.out.println("Success");
            else
                System.out.println("Try Again");
            break;
        case 2:
            System.out.println("Enter Book Name and Price to Update");
            String bname=br.readLine();
            float price=Float.parseFloat(br.readLine());
            int i1=bdao.update(bname,price);
            if (i1>0)
                System.out.println("Success");
            else
                System.out.println("Try Again");
            break;

        case 3:
            System.out.println("Enter Book name");
            String bname1=br.readLine();
            int i2= bdao.delete(bname1);
            if(i2>0)
                System.out.println("Success");
            else
                System.out.println("Try Again");
            break;

        case 4:
            List<Book> list=bdao.fetchAll();
            for(Book b1:list){
                System.out.println(b1);
            }
            break;
        case 5:
            System.out.println("Enter Bid");
            int bid=Integer.parseInt(br.readLine());
            List<Book> list1=bdao.fetchby(bid);
            for(Book b2:list1){
                System.out.println(b2);
            }
            break;
        case 6:
            System.out.println("Enter pattern");
            String like=br.readLine();
            List<Book> list2=bdao.fetchbylike(like);
            for(Book b3:list2){
                System.out.println(b3);
            }
            break;
        case 7:
            System.out.println("Enter two price ranges");
            float p=Float.parseFloat(br.readLine());
            float p1=Float.parseFloat(br.readLine());
            List<Book> list3=bdao.fetchbetween(p,p1);
            for(Book b4:list3){
                System.out.println(b4);
            }
            break;
        case 8:
            System.exit(0);
            break;
        default:
            System.out.println("Wrong Choice");
    }

}while(true);



    }
}
