/*==========================
 * JoinController.java
 * - 사용자 정의 컨트롤러
==========================*/

package com.test.mvc;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class JoinController implements Controller
{
	private IMemberInfoDAO dao;
	

	public void setDao(IMemberInfoDAO dao)
	{
		this.dao = dao;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		// ID, NAME, SSN, EMAIL, TEL, PWD, NICKNAME, URL, REGION_S_ID, MID, USERID
		String name = request.getParameter("name");
		String userId = request.getParameter("userId");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String ssn = request.getParameter("ssn");
		String tel = request.getParameter("tel");
		String nickName = request.getParameter("nickName");
		String region_S_Id1 = request.getParameter("region_S_Id1");
		String region_S_Id2 = request.getParameter("region_S_Id2");
		String region_S_Id3 = request.getParameter("region_S_Id3");
		String category_L_Id1 = request.getParameter("category_L_Id1");
		String category_L_Id2 = request.getParameter("category_L_Id2");
		String category_L_Id3 = request.getParameter("category_L_Id3");
		String category_L_Id4 = request.getParameter("category_L_Id4");
		String category_L_Id5 = request.getParameter("category_L_Id5");
		
		MemberInfo member = new MemberInfo();
		
		member.setMemberName(name);
		member.setUserId(userId);
		member.setEmail(email);
		member.setPwd(password);
		member.setSsn(ssn);
		member.setTel(tel);
		member.setNickname(nickName);
		member.setRegionId1(region_S_Id1);
		member.setRegionId2(region_S_Id2);
		member.setRegionId3(region_S_Id3);
		member.setCategory1(category_L_Id1);
		member.setCategory2(category_L_Id2);
		member.setCategory3(category_L_Id3);
		member.setCategory4(category_L_Id4);
		member.setCategory5(category_L_Id5);
		
		dao.add(member);
		dao.search(userId);
		
		mav.addObject("userId", userId);
		mav.addObject("nickName", nickName);
		
		
		mav.setViewName("/WEB-INF/view/JoinConfirm.jsp");
		         
		
		return mav;
	}

}
