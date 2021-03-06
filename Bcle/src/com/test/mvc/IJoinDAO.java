/* =========================================
	IJoinDAO.java
	- 회원가입시 필요한 모든 DAO 인터페이스
===========================================*/

package com.test.mvc;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IJoinDAO
{
	public ArrayList<Region> regionLList() throws SQLException;
	public ArrayList<Region> regionSList(String region_l_id) throws SQLException;
	public ArrayList<Category> categoryLList() throws SQLException;
	public ArrayList<Category> categorySList(String category_l_id) throws SQLException;
}
