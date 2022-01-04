package com.bcle.mybatiscontroller;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bcle.DAO.IMemberInfoDAO;

@Controller
public class MyInfoController
{
	// SqlSession 을 활용하여 mybatis 객체 의존성 (자동) 주입~!!!
	//@Autowired
	//private SqlSession sqlSession;
	
	@RequestMapping(value = "/myinfo.action", method = RequestMethod.GET)
	public String studentList(Model model)
	{
		//String result = null;
		
		//@SuppressWarnings("unused")
		//IMemberInfoDAO dao = sqlSession.getMapper(IMemberInfoDAO.class);
		
		//model.addAttribute("count", dao.count());
		//model.addAttribute("list", dao.list());
		
		return "/WEB-INF/view/MyInfo.jsp";
	}
	
	@RequestMapping(value = "/myclub.action", method = RequestMethod.GET)
	public String myClubPage(Model model)
	{
		//String result = null;
		
		//@SuppressWarnings("unused")
		//IMemberInfoDAO dao = sqlSession.getMapper(IMemberInfoDAO.class);
		
		//model.addAttribute("count", dao.count());
		//model.addAttribute("list", dao.list());
		
		return "/WEB-INF/view/MyClub.jsp";
	}
		
		
}

