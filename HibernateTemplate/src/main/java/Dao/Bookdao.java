package Dao;

import com.Book;
import org.hibernate.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;

public class Bookdao {
    HibernateTemplate ht;


    public HibernateTemplate getHt() {
        return ht;
    }

    public void setHt(HibernateTemplate ht) {
        this.ht = ht;
    }
    @Transactional
    public int insert(Book b){
        ht.setCheckWriteOperations(false);
        Integer i= (Integer) this.ht.save(b);
        return i;
    }
    @Transactional
    public int update(String bname,float p){
      List<Book> book= (List<Book>) ht.find("from Book where bname=?0",bname);
      Integer i=0;
     for(Book b:book){
         b.setPrice(p);
          i= (Integer) this.ht.save(b);
     }
      return i;
    }
    public List<Book> fetch(){
        List<Book> books=ht.loadAll(Book.class);
        return books;
    }
    @Transactional
    public void delete(int bid){
        Book b=ht.load(Book.class,bid);
        ht.delete(b);
    }
}
