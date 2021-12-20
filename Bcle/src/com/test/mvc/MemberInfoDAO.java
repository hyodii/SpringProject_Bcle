package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class MemberInfoDAO implements IMemberInfoDAO
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}
	
	// 멤버 리스트 조회 메소드
	@Override
	public ArrayList<MemberInfo> list() throws SQLException
	{
		ArrayList<MemberInfo> result = new ArrayList<MemberInfo>();
		
		return result;
	}
	
	// 지역 대분류 리스트
	@Override
	public ArrayList<RegionL> categortyLList() throws SQLException
	{
		ArrayList<RegionL> result = new ArrayList<RegionL>();
		
		return result;
	}
	
	// 지역 소분류 리스트
	@Override
	public ArrayList<RegionS> categortySList() throws SQLException
	{
		ArrayList<RegionS> result = new ArrayList<RegionS>();
		
		return result;
	}
	
	
	// 카테고리 리스트 
	/*
	@Override
	public ArrayList<Category> categortyList() throws SQLException
	{
		ArrayList<Category> result = new ArrayList<Category>();
		
		return result;
	}
	*/
	
	// 멤버 추가 메소드
	@Override
	public int memberInfoAdd(MemberInfo memberInfo) throws SQLException
	{
		int result = 0;
		
		return result;
	}
	
	// 멤버 삭제 메소드
	@Override
	public int remove(String employeeId) throws SQLException
	{
		int result = 0;
		
		return result;
	}
	
	// 멤버 수정(변경) 메소드
	@Override
	public int modify(MemberInfo memberInfo) throws SQLException
	{
		int result = 0;
		
		return result;
	}
	
	// 아이디로 직원을 검색하는 메소드 
	/*
	@Override
	public MemberInfo searchId(String id) throws SQLException
	{
		
	}
	*/
	
	// 유저가 입력한 아이디로 아이디 중복 여부 메소드
	@Override
	public int checkId(String userId) throws SQLException
	{
		int result = 0;
		      
		Connection conn = dataSource.getConnection();
		      
		String sql = "SELECT USERID FROM MEMBERINFO WHERE USERID = ?";      
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		  
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next() || userId.equals(""))
			result = 0;
		else
			result = 1;
		      
		rs.close();
		pstmt.close();
		conn.close();
		      
		return result;
	}
	
	
	// 유저가 입력한 닉네임으로 닉네임 중복 여부 메소드
	@Override
	public int checkNickName(String nickname) throws SQLException
	{
		int result = 0;
		      
		Connection conn = dataSource.getConnection();
		      
		String sql = "SELECT NICKNAME FROM MEMBERINFO WHERE NICKNAME = ?";      
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nickname);
		  
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next() || nickname.equals(""))
			result = 0;
		else
			result = 1;
		      
		rs.close();
		pstmt.close();
		conn.close();
		      
		return result;
	}
	
	
	// 일반 로그인 메소드
	@Override
	public String login(String userId, String pwd) throws SQLException
	{
		String result = null;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT ID FROM MEMBERINFO WHERE USERID=? AND PWD=?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, pwd);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
			result = rs.getString("ID");
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}
	
	
	// 관리자 로그인 메소드
	@Override
	public String logAdmin(String name, String pwd) throws SQLException
	{
		String result = null;
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT ADMIN_ID FROM ADMIN WHERE NAME=? AND PWD=?";		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(name));
		pstmt.setString(2, pwd);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
			result = rs.getString("adminId");
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	// 아이디로 닉네임을 검색하는 메소드
	@Override
	public MemberInfo searchId(String id) throws SQLException
	{
		MemberInfo result = new MemberInfo();
		
		Connection conn = dataSource.getConnection();
		
		String sql = "SELECT NICKNAME FROM MEMBERINFO WHERE ID = ?";		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
			result.setNickname(rs.getString("NICKNAME")); 
		rs.close();
		pstmt.close();
		conn.close();
		
		return result;
	}

	
		
		
	
	
}
