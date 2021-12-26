/*================================
 * IReqBeeDAO.java
 * - 인터페이스
================================*/


package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IReqBeeDAO
{
	public ArrayList<ReqBee> reqList(String beeId) throws SQLException;
	
	public int add(ReqBee dto) throws SQLException;
	public int count(String beeId) throws SQLException;
	
}
