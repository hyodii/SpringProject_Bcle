/*=====================================================
 * #11. BeeDAO.java
 * - 데이터베이스 액션 처리 클래스
 * - 모임 정보 입력 / 출력 / 수정 / 삭제 액션
 * - Connection 객체에 대한 의존성 주입을 위한 준비
 *   → 인터페이스 형태의 속성 구성(DataSource)
 *   → setter 메소드 정의
=====================================================*/

package com.test.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

public class BeeDAO implements IBeeDAO
{
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	@Override
	public ArrayList<Bee> list() throws SQLException
	{
		ArrayList<Bee> result = new ArrayList<Bee>();
		
		Connection conn = dataSource.getConnection();
		String sql = "SELECT BEE_ID, TYPE_ID, TYPENAME"
				+ ", TITLE, CONTENT, BEETIME"
				+ ", WEATHER, LOCATION"
				+ ", MIN, MAX, FEE, BDATE"
				+ ", CLUBMEM_ID, WRITER, NICKNAME, REQCNT"
				+ " FROM BEEVIEW"
				+ " ORDER BY TO_NUMBER(BEE_ID) DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			Bee bee = new Bee();
			
			bee.setBeeId(rs.getString("BEE_ID"));
			bee.setTypeId(rs.getString("TYPE_ID"));
			bee.setTypeName(rs.getString("TYPENAME"));
			bee.setTitle(rs.getString("TITLE"));
			bee.setContent(rs.getString("CONTENT"));
			bee.setBeeTime(rs.getString("BEETIME"));
			bee.setWeather(rs.getString("WEATHER"));
			bee.setLocation(rs.getString("LOCATION"));
			bee.setMin(rs.getInt("MIN"));
			bee.setMax(rs.getInt("MAX"));
			bee.setFee(rs.getInt("FEE"));
			bee.setBeeDate(rs.getString("BDATE"));
			bee.setClubmemId("CLUBMEM_ID");
			bee.setWriter(rs.getString("WRITER"));
			bee.setNickName(rs.getString("NICKNAME"));
			bee.setReqCnt(rs.getInt("REQCNT"));
			
			result.add(bee);
		}
		rs.close();
		pstmt.close();
		conn.close();

		return result;
	}

	@Override
	public Bee showBee(String beeId) throws SQLException
	{
		Bee result = new Bee();
		
		Connection conn = dataSource.getConnection();
		String sql = "SELECT BEE_ID, TYPE_ID, TYPENAME, TITLE, CONTENT"
				+ ", BEETIME, WEATHER, LOCATION, MIN, MAX, FEE, BDATE, CLUBMEM_ID, WRITER, NICKNAME, REQCNT"
				+ " FROM BEEVIEW"
				+ " WHERE BEE_ID = ?";
				
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, beeId);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next())
		{
			result.setBeeId(rs.getString("BEE_ID"));
			result.setTypeId(rs.getString("TYPE_ID"));
			result.setTypeName(rs.getString("TYPENAME"));
			result.setTitle(rs.getString("TITLE"));
			result.setContent(rs.getString("CONTENT"));
			result.setBeeTime(rs.getString("BEETIME"));
			result.setWeather(rs.getString("WEATHER"));
			result.setLocation(rs.getString("LOCATION"));
			result.setMin(rs.getInt("MIN"));
			result.setMax(rs.getInt("MAX"));
			result.setFee(rs.getInt("FEE"));
			result.setBeeDate(rs.getString("BDATE"));
			result.setClubmemId("CLUBMEM_ID");
			result.setWriter(rs.getString("WRITER"));
			result.setNickName(rs.getString("NICKNAME"));
			result.setReqCnt(rs.getInt("REQCNT"));
		}
		rs.close();
		pstmt.close();
		conn.close();

		return result;
	}

	@Override
	public int add(Bee bee) throws SQLException
	{
		// TODO Auto-generated method stub
		//INSERT INTO BEE(BEE_ID, TYPE_ID, TITLE, CLUBMEM_ID, CONTENT, BEE_TIME, WEATHER, LOCATION, MIN, MAX, FEE, BDATE)
        //VALUES(BEESEQ.NEXTVAL, '1', V_TITLE, 'CM1', V_CONTENT, V_BEE_TIME, NULL, '0', 3, NULL, V_FEE, V_BDATE);
		  int result = 0;
	      
	      Connection conn = dataSource.getConnection();
	      
	      String sql = "INSERT INTO BEE(BEE_ID, TYPE_ID, TITLE, CLUBMEM_ID"
	     		+ ", CONTENT, BEE_TIME, WEATHER, LOCATION, MIN, MAX"
	     		+ ", FEE, BDATE)" 
	     		+ " VALUES(BEESEQ.NEXTVAL, ?, ?, ?, ?, TO_DATE(? , 'YYYY-MM-DD HH24:MI:SS'), NULL, ?, ?, ?, ?, SYSDATE)";
	   
	      
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      pstmt.setString(1, bee.getTypeId());
	      pstmt.setString(2, bee.getTitle());
	      pstmt.setString(3, bee.getClubmemId());
	      pstmt.setString(4, bee.getContent());
	      pstmt.setString(5, bee.getBeeTime());
	      pstmt.setString(6, bee.getLocation());
	      pstmt.setInt(7, bee.getMin());
	      pstmt.setInt(8, bee.getMax());
	      pstmt.setInt(9, bee.getFee());
	      
	      result = pstmt.executeUpdate();
	      
	      pstmt.close();
	      conn.close();
	      
	      return result;
		
	}

	@Override
	public int remove(String beeId) throws SQLException
	{
		int result = 0;
	      
	      Connection conn = dataSource.getConnection();
	      
	      // String으로 들어가면 오라클에서 EMPLOYEEID='2' 이렇게 들어가는거기 때문에...
	      String sql = "DELETE FROM BEE WHERE BEE_ID = ?";
	      PreparedStatement pstmt = conn.prepareStatement(sql);
	      
	      pstmt.setString(1, beeId);
	      
	      result = pstmt.executeUpdate();
	      
	      pstmt.close();
	      conn.close();
	      
	      return result;
	}

	@Override
	public int modify(Bee bee) throws SQLException
	{
		int result = 0;
	      
	    Connection conn = dataSource.getConnection();
	      
	    String sql = "UPDATE BEE"
	    		+ " SET TYPE_ID = ?, TITLE = ?"
	    		+ ", CONTENT = ?, BEE_TIME = TO_DATE(? , 'YYYY-MM-DD HH24:MI:SS')"
	    		+ ", LOCATION = ?, MIN = ? , MAX = ? , FEE=?"
	    		+ " WHERE BEE_ID = ?";
	   
	      
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, bee.getTypeId());
	    pstmt.setString(2, bee.getTitle());
	    pstmt.setString(3, bee.getContent());
	    pstmt.setString(4, bee.getBeeTime());
	    pstmt.setString(5, bee.getLocation());
	    pstmt.setInt(6, bee.getMin());
	    pstmt.setInt(7, bee.getMax());
	    pstmt.setInt(8, bee.getFee());
	    pstmt.setString(9, bee.getBeeId());
	      
	    result = pstmt.executeUpdate();
	      
	    pstmt.close();
	    conn.close();
	      
	    return result;
	}
	
	
}
