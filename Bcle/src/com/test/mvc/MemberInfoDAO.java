package com.test.mvc;

import java.sql.CallableStatement;
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
		/*
		 * Connection conn = dataSource.getConnection();
		 * 
		 * String sql =
		 * "SELECT ID, NAME, SSN, EMAIL, TEL, PWD, NICKNAME, URL, REGION_S_ID, MID, USERID FROM MEMBERINFO"
		 * ;
		 * 
		 * PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs =
		 * pstmt.executeQuery();
		 * 
		 * while (rs.next()) { MemberInfo member = new MemberInfo();
		 * 
		 * member.setMemberId(rs.getString("ID")); member.
		 * 
		 * result.add(member); } rs.close(); pstmt.close(); conn.close();
		 */
		return result;
	}

	/*
	 * // 프로시저 사용 시 //String sql =
	 * "{CALL JOIN_INSERT( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
	 * //CallableStatement cstmt = conn.prepareCall(sql); pstmt.setString(1,
	 * memberInfo.getCategory1()); pstmt.setString(2, memberInfo.getMemberName());
	 * pstmt.setString(3, memberInfo.getSsn()); pstmt.setString(4,
	 * memberInfo.getEmail()); pstmt.setString(5, memberInfo.getTel());
	 * pstmt.setString(6, memberInfo.getPwd()); pstmt.setString(7,
	 * memberInfo.getNickname()); pstmt.setString(8, memberInfo.getUrl());
	 * pstmt.setString(9, memberInfo.getRegionId1()); pstmt.setString(10,
	 * memberInfo.getUserId()); pstmt.setString(11, memberInfo.getCategory2());
	 * pstmt.setString(12, memberInfo.getCategory3()); pstmt.setString(13,
	 * memberInfo.getCategory4()); pstmt.setString(14, memberInfo.getCategory5());
	 * pstmt.setString(15, memberInfo.getRegionId2()); pstmt.setString(16,
	 * memberInfo.getRegionId3());
	 */

	// MEMBERINFO 테이블에 데이터 추가 메소드
	@Override
	public int memberInfoAdd(MemberInfo member) throws SQLException
	{
		int result = 0;

		Connection conn = dataSource.getConnection();

		String sql = "INSERT INTO MEMBERINFO(ID, NAME, SSN, EMAIL, TEL, PWD, NICKNAME, URL, REGION_S_ID, MID, USERID)"
				+ " VALUES('MI' || MEMBERINFOSEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?)";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, member.getName());
		pstmt.setString(2, member.getSsn());
		pstmt.setString(3, member.getEmail());
		pstmt.setString(4, member.getTel());
		pstmt.setString(5, member.getPwd());
		pstmt.setString(6, member.getNickname());
		pstmt.setString(7, member.getUrl());
		pstmt.setString(8, member.getRegionId1());
		pstmt.setString(9, member.getMid());
		pstmt.setString(10, member.getUserId());

		result = pstmt.executeUpdate();

		pstmt.close();
		conn.close();

		return result;
	}

	// MEMBER 테이블에 데이터 추가 메소드
	@Override
	public int memberAdd(MemberInfo member) throws SQLException
	{
		int result = 0;

		Connection conn = dataSource.getConnection();

		String sql = "INSERT INTO MEMBER(MID, BDATE, LOGIN_DATE, CATEGORY_S_ID) VALUES('M'|| MEMBERSEQ.NEXTVAL, SYSDATE, SYSDATE, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, member.getCategoryId1());

		result = pstmt.executeUpdate();

		pstmt.close();
		conn.close();

		return result;
	}

	// ADD_CATEGORY 테이블에 데이터 추가 메소드
	@Override
	public int addCategoryAdd(String mid, String category_s_id) throws SQLException
	{
		int result = 0;

		Connection conn = dataSource.getConnection();

		String sql = "INSERT INTO ADD_CATEGORY(ADD_CATEGORY_ID, MID, CATEGORY_S_ID) VALUES(ADD_CATEGORYSEQ.NEXTVAL,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, "M" + mid);
		pstmt.setString(2, category_s_id);

		result = pstmt.executeUpdate();

		pstmt.close();
		conn.close();

		return result;
	}

	// ADD_REGION 테이블에 데이터 추가 메소드
	@Override
	public int addregionAdd(String id, String region_s_id) throws SQLException
	{
		int result = 0;

		Connection conn = dataSource.getConnection();

		String sql = "INSERT INTO ADD_REGION(ADD_REGION_ID, ID, REGION_S_ID) VALUES(ADD_REGIONSEQ.NEXTVAL, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, id);
		pstmt.setString(2, region_s_id);

		result = pstmt.executeUpdate();

		pstmt.close();
		conn.close();

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
	 * @Override public MemberInfo searchId(String id) throws SQLException {
	 * 
	 * }
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

		if (rs.next() || userId.equals(""))
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

		if (rs.next() || nickname.equals(""))
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

	// 아이디로 전부을 검색하는 메소드
	@Override
	public MemberInfo search(String userId) throws SQLException
	{
		MemberInfo result = new MemberInfo();

		Connection conn = dataSource.getConnection();

		String sql = "SELECT ID, NAME, SSN, EMAIL, TEL, PWD, NICKNAME, URL, REGION_S_ID, MID, USERID FROM MEMBERINFO WHERE USERID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			result.setId(rs.getString("ID"));
			result.setName(rs.getString("NAME"));
			result.setSsn(rs.getString("SSN"));
			result.setEmail(rs.getString("EMAIL"));
			result.setTel(rs.getString("TEL"));
			result.setPwd(rs.getString("PWD"));
			result.setNickname(rs.getString("NICKNAME"));
			result.setUrl(rs.getString("URL"));
			result.setRegionId1(rs.getString("REGION_S_ID"));
			result.setMid(rs.getString("MID"));
			result.setUserId(rs.getString("USERID"));
		}
		rs.close();
		pstmt.close();
		conn.close();

		return result;
	}

	// 주민번호 조회
	@Override
	public int CheckSsn(String ssn) throws SQLException
	{

		int result = 0;

		Connection conn = dataSource.getConnection();

		String sql = "SELECT * FROM MEMBERINFO WHERE SSN = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ssn);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next())
			result = 0;
		else
			result = 1;

		return result;
	}

	@Override
	public String findMid() throws SQLException
	{

		String result = null;

		Connection conn = dataSource.getConnection();

		String sql = "SELECT MAXMID FROM MAXMID_VIEW";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
			result = rs.getString("MAXMID");

		rs.close();
		pstmt.close();
		conn.close();

		return result;

	}

	@Override
	public String findId(String ssn) throws SQLException
	{
		String result = null;

		Connection conn = dataSource.getConnection();

		String sql = "SELECT ID FROM MEMBERINFO WHERE SSN=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ssn);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next())
			result = rs.getString("ID");

		rs.close();
		pstmt.close();
		conn.close();

		return result;
	}

	@Override
	public int join(MemberInfo member) throws SQLException
	{
		int result = 0;

		Connection conn = dataSource.getConnection();

		String sql = "{CALL JOIN_INSERT(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";

		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setString(1, member.getCategoryId1());
		cstmt.setString(2, member.getName());
		cstmt.setString(3, member.getSsn());
		cstmt.setString(4, member.getEmail());
		cstmt.setString(5, member.getTel());
		cstmt.setString(6, member.getPwd());
		cstmt.setString(7, member.getNickname());
		cstmt.setString(8, member.getUrl());
		cstmt.setString(9, member.getRegionId1());
		cstmt.setString(10, member.getUserId());

		result = cstmt.executeUpdate();

		cstmt.close();
		conn.close();

		return result;

	}
	
	// 이름과 이메일을 이용해서 아이디 찾기
	@Override
	public ArrayList<MemberInfo> findUserId(String name, String email) throws SQLException
	{
		ArrayList<MemberInfo> result = new ArrayList<MemberInfo>();
	     
		Connection conn = dataSource.getConnection();
		
		String sql="SELECT USERID, TO_DATE(JOINDATE,'YYYY-MM-DD') AS JOINDATE FROM MEMBERINFO_VIEW2  WHERE NAME=? AND EMAIL=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, name);
	    pstmt.setString(2, email);
	    
	    ResultSet rs = pstmt.executeQuery();
	    
	    
		while (rs.next())
		{
			MemberInfo member = new MemberInfo();
			
			member.setUserId(rs.getString("USERID"));
			member.setBdate(rs.getString("JOINDATE"));
			
			result.add(member);
		}
			
		rs.close();
		pstmt.close();
		conn.close();
	    
		
		return result;
	}
	
	// 비밀번호 찾기
	@Override
	public String findPwd(String userId, String email) throws SQLException
	{
		String result = null;
	     
		Connection conn = dataSource.getConnection();
		
		String sql="SELECT PWD FROM MEMBERINFO WHERE USERID=? AND EMAIL=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, userId);
	    pstmt.setString(2, email);
	    
	    ResultSet rs = pstmt.executeQuery();
	    
		while (rs.next())
			result = rs.getString("PWD");
		
		rs.close();
		pstmt.close();
		conn.close();
	    
		
		return result;
	}	

}
