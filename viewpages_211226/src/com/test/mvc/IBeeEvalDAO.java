/*================================
 * IBeeDAO.java
 * - 인터페이스
================================*/


package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBeeEvalDAO
{
	public ArrayList<BeeEval> list(String beeId) throws SQLException;
	
	public int add(BeeEval dto) throws SQLException;
}
