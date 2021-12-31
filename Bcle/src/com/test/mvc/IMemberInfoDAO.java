/* ===============================
	IMemberInfoDAO.java
	- 인터페이스
=================================*/

package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IMemberInfoDAO
{
	public ArrayList<MemberInfo> list() throws SQLException;
	
	public int remove(String employeeId) throws SQLException;
	public int modify(MemberInfo memberInfo) throws SQLException;		// 찾는걸 찾아서 다 수정하니까!!! MemberInfo memberInfo
	public MemberInfo search(String userId) throws SQLException;	// 아이디를 가지고있는 모든 정보를 찾아야하기 때문에 MemberInfo
	
	// 가입할 때 4개의 테이블에 insert
	public int join(MemberInfo memberInfo) throws SQLException;
	public int memberInfoAdd(MemberInfo memberInfo) throws SQLException;
	public int memberAdd(MemberInfo memberInfo) throws SQLException;
	public int addCategoryAdd(String mid, String category_s_id) throws SQLException;
	public int addregionAdd(String id, String region_s_id) throws SQLException;
	
	
	public int checkId(String userId) throws SQLException;
	public int checkNickName(String nickname) throws SQLException;
	public int CheckSsn(String ssn) throws SQLException;
	
	// 로그인 메소드
	public String login(String id, String pw) throws SQLException;
	public String logAdmin(String id, String pw) throws SQLException;

	// mid 찾기
	public String findMid() throws SQLException;
	// id 찾기
	public String findId(String ssn) throws SQLException;
	
}
