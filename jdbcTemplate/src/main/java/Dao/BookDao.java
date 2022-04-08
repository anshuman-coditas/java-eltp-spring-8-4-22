package Dao;

import com.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private JdbcTemplate jt;

    public JdbcTemplate getJt() {
        return jt;
    }

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public int insert(Book b){
        return jt.update("insert into JTBookDetails values(?,?,?,?)",null,b.getBookName(),b.getAuthorName(),b.getPrice());
    }
    public int update(String bname,float p){
      return jt.update("update JTBookdetails set price =? where bookName=?",p,bname);
    }
    public  int delete(String bname){
        return jt.update("delete from JTBookDetails where bookName=?",bname);
    }
    public List<Book> fetchAll() {
        String sql = "select * from JTBookDetails";
        List<Book> list = jt.query(sql, new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet resultSet, int i) throws SQLException {
                Book book = new Book();
                book.setBid(resultSet.getInt(1));
                book.setBookName(resultSet.getString(2));
                book.setAuthorName(resultSet.getString(3));
                book.setPrice(resultSet.getFloat(4));
                return book;
            }
        });
        return list;
    }
    public List<Book> fetchby(int bid){
        String sql="select * from JTBookDetails where bid=?";
        Object[] values={bid};
        List<Book> list=jt.query(sql, values, new ResultSetExtractor<List<Book>>() {
            @Override
            public List<Book> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Book> list1=new ArrayList<>();
                while(resultSet.next()){
                    Book b=new Book();
                    b.setBid(resultSet.getInt(1));
                    b.setBookName(resultSet.getString(2));
                    b.setAuthorName(resultSet.getString(3));
                    b.setPrice(resultSet.getFloat(4));
                    list1.add(b);
                }
                return list1;
            }
        });
        return list;
    }
    public List<Book> fetchbylike(String like){
        String sql="select * from JTBookDetails where authorName like ?";
        Object[] values={like};
        List<Book> list=jt.query(sql,values,new ResultSetExtractor<List<Book>>() {
            @Override
            public List<Book> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Book> list1=new ArrayList<>();
                while(resultSet.next()){
                    Book b=new Book();
                    b.setBid(resultSet.getInt(1));
                    b.setBookName(resultSet.getString(2));
                    b.setAuthorName(resultSet.getString(3));
                    b.setPrice(resultSet.getFloat(4));
                    list1.add(b);
                }
                return list1;
            }
        });
        return list;
    }
    public List<Book> fetchbetween(float p,float p1){
        String sql="select * from JTBookDetails where price between ? and ?";
        Object[] values={p,p1};
        List<Book> list=jt.query(sql,values,new ResultSetExtractor<List<Book>>() {
            @Override
            public List<Book> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<Book> list1=new ArrayList<>();
                while(resultSet.next()){
                    Book b=new Book();
                    b.setBid(resultSet.getInt(1));
                    b.setBookName(resultSet.getString(2));
                    b.setAuthorName(resultSet.getString(3));
                    b.setPrice(resultSet.getFloat(4));
                    list1.add(b);
                }
                return list1;
            }
        });
        return list;
    }
}


