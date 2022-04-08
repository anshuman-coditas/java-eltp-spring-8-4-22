package com;

import Dao.Bookdao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Spring.xml");
        Bookdao bdao= (Bookdao) applicationContext.getBean("bdao");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("1.INSERT\n2.UPDATE\n3.FETCH\n4.DELETE\n5.EXIT");
            int ch=Integer.parseInt(br.readLine());
            switch (ch){
                case 1:
                    System.out.println("Enter Values for book");
                    Book b=new Book();
                    b.setBname(br.readLine());
                    b.setAname(br.readLine());
                    b.setPrice(Float.parseFloat(br.readLine()));
                    int i1=bdao.insert(b);
                    if(i1>0)
                        System.out.println("Success");
                    else
                        System.out.println("Try Again");
                    break;
                case 2:
                    System.out.println("Enter bname and price to update");
                    String bname=br.readLine();
                    float p=Float.parseFloat(br.readLine());
                    int i=bdao.update(bname,p);
                    if(i>0)
                        System.out.println("Success");
                    else
                        System.out.println("Try Again");
                    break;
                case 3:
                    List<Book> bookList=bdao.fetch();
                    for(Book b1:bookList){
                        System.out.println(b1);
                    }
                    break;
                case 4:
                    System.out.println("Enter BID");
                    int bid=Integer.parseInt(br.readLine());
                    bdao.delete(bid);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong Choice");

            }
        }while(true);

    }
}
