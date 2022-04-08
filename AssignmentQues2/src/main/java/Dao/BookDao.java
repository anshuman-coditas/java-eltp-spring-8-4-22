package Dao;

import com.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDao {
    private JdbcTemplate jt;

    public JdbcTemplate getJt() {
        return jt;
    }

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public int insert(Book b) {
        String sql="insert into JTBookDetails1(bid,bookName,authorName,price) values(:bid,:bookName,:authorName,:price)";
        Map<String,Object> namedParameters=new HashMap<>();
        namedParameters.put("bid",b.getBid());
        namedParameters.put("bookName",b.getBookName());
        namedParameters.put("authorName",b.getAuthorName());
        namedParameters.put("price",b.getPrice());
        NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(jt.getDataSource());
        int status=namedParameterJdbcTemplate.update(sql,namedParameters);
        return status;
    }

    public int update(String bname, float p) {
        String sql="update jtbookdetails1 set price=:price where bookName=:bname";
        Map<String,Object> namedParameters=new HashMap<>();
        namedParameters.put("price",p);
        namedParameters.put("bname",bname);
        NamedParameterJdbcTemplate namedParameterJdbcTemplate=new NamedParameterJdbcTemplate(jt.getDataSource());
        int status=namedParameterJdbcTemplate.update(sql,namedParameters);
        return status;
    }
}