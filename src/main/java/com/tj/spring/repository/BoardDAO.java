package com.tj.spring.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Statement;
import com.tj.spring.vo.BoardVO;
import java.util.Date;


@Repository
public class BoardDAO {
	private Connection getConnection() throws SQLException {
	    Connection conn = null;

	    try {
	        Class.forName("com.mysql.jdbc.Driver");

	        String url = "jdbc:mysql://localhost:3306/test";
	        conn = DriverManager.getConnection(url, "root", "2115");
	    }
	    catch (ClassNotFoundException e) {
	    }

	    return conn;
	}
	
	public List<BoardVO> getList(){
	    List<BoardVO> list = new ArrayList<BoardVO>();
	    Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;

	    try {
	        conn = getConnection();

	        String sql = "SELECT no, name, pw, content, writedate" +
	                " FROM boardexam" +
	                " ORDER BY no desc";

	        pstmt = conn.prepareStatement(sql);
	        rs = pstmt.executeQuery();

	        while(rs.next()) {
	        	BoardVO vo = new BoardVO();
	            vo.setNo(rs.getInt(1));
	            vo.setName(rs.getString(2));
	            vo.setPw(rs.getString(3));
	            vo.setContent(rs.getString(4));
	            vo.setDate(rs.getString(5));

	            list.add(vo);
	        }
	    }
	    catch (SQLException e) {
	        System.out.println("에러: " + e);
	    }

	    return list;
	}

	
	public void insert(BoardVO boardVO) {
		
		Connection conn = null;
	    PreparedStatement pstmt = null;

	    try {
	        conn = getConnection();

	        String sql="insert into boardexam values(null,?,?,?,SYSDATE());";

	        pstmt = conn.prepareStatement(sql);

	        pstmt.setString(1,boardVO.getName());
	        pstmt.setString(2,boardVO.getPw());
	        pstmt.setString(3,boardVO.getContent());
	        int count=pstmt.executeUpdate();
	    }
	    catch (SQLException e) {
	        System.out.println("에러: " + e);
	    }
		
	}
	
	public void del(String no,String pw) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    PreparedStatement pstmt1 = null;
	    ResultSet rs = null;
	    String pwdb = null;
	    try {
	        conn = getConnection();
	        String sql1="select pw from boardexam where no="+no;
	        pstmt1=conn.prepareStatement(sql1);
	        rs = pstmt1.executeQuery();
	        if(rs.next()) {
	        	pwdb=rs.getString("pw");
	        }
	    }
	    catch (SQLException e) {
	        System.out.println("에러: " + e);
	    }
	    if(pw.equals(pwdb)) {
	    	try {
		        conn = getConnection();
		        String sql="delete from boardexam where no=?";
		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1,no);
		        int count=pstmt.executeUpdate();
	        }catch (SQLException e) {
		        System.out.println("에러: " + e);
		    }
	    }
        else 
        	System.out.println("비번이틀림");
	}

}
