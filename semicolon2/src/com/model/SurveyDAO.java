package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class SurveyDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = null;

	private static SurveyDAO instance;

	public SurveyDAO() {}
	
	public static SurveyDAO getInstance() {
		if (instance == null) {
			instance = new SurveyDAO();
		}
		return instance;
	}
	
	public void openConn() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeConn(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if (pstmt !=null) { pstmt.close(); }
			if (con != null) { con.close(); }
			if (rs !=null) { rs.close(); }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<SurveyDTO> getSContent() {
		openConn();
		List<SurveyDTO> list = new ArrayList<SurveyDTO>();
		try {
			sql = "select * from survey";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				SurveyDTO dto = new SurveyDTO();
				
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setNa(rs.getString("na"));
				dto.setMoney(rs.getString("money"));
				dto.setPeople(rs.getString("people"));
				dto.setBenefits(rs.getString("benefits"));
				dto.setType(rs.getString("type"));
				dto.setTime(rs.getString("time"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return list;
	}
	
	public int getSurveyCount() {
		int count = 0;

		try {
			openConn();
			sql = "select count(*) from survey";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return count;
	}
	
	public List<SurveyDTO> getSList(int page, int rowsize) {
		List<SurveyDTO> list = new ArrayList<SurveyDTO>();
		int startNo = (page*rowsize) - (rowsize - 1);
		int endNo = (page * rowsize);
		
		try {
			openConn();
			sql = "select * from(select row_number() over(order by no desc) rnum, b.* from survey b) where rnum >= ? and rnum <= ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startNo);
			pstmt.setInt(2, endNo);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SurveyDTO dto = new SurveyDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setNa(rs.getString("na"));
				dto.setMoney(rs.getString("money"));
				dto.setPeople(rs.getString("people"));
				dto.setBenefits(rs.getString("benefits"));
				dto.setType(rs.getString("type"));
				dto.setTime(rs.getString("time"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return list;
	}
	
	public SurveyDTO SContent(String no) {
		openConn();
		SurveyDTO dto = new SurveyDTO();
		
		try {
			sql = "select * from survey where no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setNa(rs.getString("na"));
				dto.setMoney(rs.getString("money"));
				dto.setPeople(rs.getString("people"));
				dto.setBenefits(rs.getString("benefits"));
				dto.setType(rs.getString("type"));
				dto.setTime(rs.getString("time"));
				dto.setLatitude(rs.getString("latitude"));
				dto.setLongitude(rs.getString("longitude"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConn(rs, pstmt, con);
		}
		return dto;
	}
	
	public List<SurveyDTO> search(String keyword) {
		List<SurveyDTO> list = new ArrayList<SurveyDTO>();
		openConn();
		try {
			sql = "select * from survey where name like ? or na like ? or money like ? or people like ? or benefits like ? or type like ? or time like ? order by no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setString(3, "%" + keyword + "%");
			pstmt.setString(4, "%" + keyword + "%");
			pstmt.setString(5, "%" + keyword + "%");
			pstmt.setString(6, "%" + keyword + "%");
			pstmt.setString(7, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SurveyDTO dto = new SurveyDTO();
				dto.setNo(rs.getInt("no"));
				dto.setName(rs.getString("name"));
				dto.setNa(rs.getString("na"));
				dto.setMoney(rs.getString("money"));
				dto.setPeople(rs.getString("people"));
				dto.setBenefits(rs.getString("benefits"));
				dto.setType(rs.getString("type"));
				dto.setTime(rs.getString("time"));
				list.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			closeConn(rs, pstmt, con);
		}
		return list;
	}
}