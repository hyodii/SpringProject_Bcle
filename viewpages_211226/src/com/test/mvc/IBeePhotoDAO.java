/*================================
 * IBeePhotoDAO.java
 * - 인터페이스
================================*/


package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBeePhotoDAO
{
	public int add(BeePhoto dto) throws SQLException;
	
	public ArrayList<String> beePic(String beeId) throws SQLException;
	
	public int count(String beeId) throws SQLException;
}
