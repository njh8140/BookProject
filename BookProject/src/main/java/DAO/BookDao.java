package DAO;

import java.sql.Connection;
import java.sql.Date; //pub_date
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.Book;

public class BookDao {
	DataSource ds;
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	public int update(Book book) throws Exception{
		Connection con = null;
		PreparedStatement pst = null;
		String query = null;
		
		try {
			con = ds.getConnection();
			query = "update book set title=?, author=?, category=?, publisher=?, price=?, pub_date=?, isbn=? where id=?";
			pst = con.prepareStatement(query);
			pst.setString(1, book.getTitle());
			pst.setString(2, book.getAuthor());
			pst.setString(3, book.getCategory());
			pst.setString(4, book.getPublisher());
			pst.setInt(5, book.getPrice());
			pst.setDate(6, (Date)book.getPub_date());
			pst.setString(7, book.getIsbn());
			pst.setInt(8, book.getId());
			
			return pst.executeUpdate();
			
		}catch(Exception e){
			throw e;
		}finally{
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){} 
		}	
	}

	public Book selectOne(int id) throws Exception{
		PreparedStatement pst = null;
		String query = null;
		ResultSet rs = null;
		Connection con = null;
		try{
			con = ds.getConnection();
			query = "select * from book where id = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			
			rs = pst.executeQuery();
			
			if(!rs.next()) {
				return null;
			} else {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setCategory(rs.getString("category"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getInt("price"));
				
				return book;
			}
		}catch(Exception e){
			throw e;
		}finally{
			try{if(rs != null) rs.close();}catch(SQLException e){}
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){}
		}	
	}
	public int delete(int id) throws Exception{
		Connection con = null;
		PreparedStatement pst = null;
		String query = null;
		
		try{
			con = ds.getConnection();
			query = "delete from book where id = ?";
			pst = con.prepareStatement(query);
			pst.setInt(1, id);
			
			return pst.executeUpdate();
			
		}catch(Exception e){
			throw e;
		}finally{
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){}
		}	
	}
	public int insert(Book book) throws Exception{
		System.out.println("BookDAO insert();");
		PreparedStatement pst = null;
		String query = null;
		Connection con = null;
		try{
			con = ds.getConnection();
			query = "insert into book(title, author, category, publisher, price, pub_date, isbn) values (?, ?, ?, ?, ?, ?, ?)";
			pst = con.prepareStatement(query);
			pst.setString(1, book.getTitle());
			pst.setString(2, book.getAuthor());
			pst.setString(3, book.getCategory());
			pst.setString(4, book.getPublisher());
			pst.setInt(5, book.getPrice());
			pst.setDate(6, (Date)book.getPub_date());
			pst.setString(7, book.getIsbn());
			
			return pst.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally{
			try{if(pst != null) pst.close();}catch(SQLException e){}
			try{if(con != null) con.close();}catch(SQLException e){}
		}	
	}
	public ArrayList<Book> selectAll() throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		
		try{
			con = ds.getConnection();
			query = "select * from book";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			ArrayList<Book> books = new ArrayList<Book>();
			
			while(rs.next()) {
				Book tmp = new Book();
				tmp.setId(rs.getInt("id"));
				tmp.setTitle(rs.getString("title"));
				tmp.setAuthor(rs.getString("author"));
				tmp.setCategory(rs.getString("category"));
				tmp.setPublisher(rs.getString("publisher"));
				tmp.setPrice(rs.getInt("price"));
				
				books.add(tmp);
			}
			return books;
	}catch(Exception e) {
		throw e;
	}finally {
		try{if(rs != null) rs.close();}catch(SQLException e){}
		try{if(st != null) st.close();}catch(SQLException e){}
		try{if(con != null) con.close();}catch(SQLException e){}
	}
	}
	public ArrayList<Book> searchTitle(String keyword) throws Exception {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String query = null;
		
		try{
			con = ds.getConnection();
			query = "select * from book where title like '%" + keyword + "%'";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			ArrayList<Book> books = new ArrayList<Book>();
			
			while(rs.next()) {
				Book tmp = new Book();
				tmp.setId(rs.getInt("id"));
				tmp.setTitle(rs.getString("title"));
				tmp.setAuthor(rs.getString("author"));
				tmp.setCategory(rs.getString("category"));
				tmp.setPublisher(rs.getString("publisher"));
				tmp.setPrice(rs.getInt("price"));
				
				books.add(tmp);
			}
			return books;
	}catch(Exception e) {
		throw e;
	}finally {
		try{if(rs != null) rs.close();}catch(SQLException e){}
		try{if(st != null) st.close();}catch(SQLException e){}
		try{if(con != null) con.close();}catch(SQLException e){}
	}
}
	
}