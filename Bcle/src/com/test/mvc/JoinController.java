/*==========================
 * JoinController.java
 * - 사용자 정의 컨트롤러
==========================*/

package com.test.mvc;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sun.org.apache.xpath.internal.operations.Mult;


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
		
		// 세션처리 -----------------------------------------
		
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) // -- 로그인이 되어 있지 않은 상황
		{
			mav.setViewName("redirect:loginpage.action");
			return mav;
		}
		// ----------------------------------------- 세션처리
		
		
		// 파일 업로드의 정보
		String path = "upload/image";
		String savePath = request.getServletContext().getRealPath(path);
		int maxSize = 1024 * 1024 * 1024; // 1G 이하
		String encodingType = "UTF-8";
			
		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, encodingType,
			        new DefaultFileRenamePolicy());
		
		// 세션값 id 수신 --MEMBERINFO의 주키(ID)임
		String id = (String)session.getAttribute("id");
		// System.out.println(id+"입니다");

		
		// Join.jsp로부터 데이터 수신. -- ★multi에서 데이터 가져와야함
		// 16개
		String url = multi.getFilesystemName("url"); // --★ check!
		String name = multi.getParameter("name");
		String userId = multi.getParameter("userId");
		String email = multi.getParameter("email");
		String password = multi.getParameter("password");
		String ssn = multi.getParameter("ssn");
		String tel = multi.getParameter("tel");
		String nickName = multi.getParameter("nickName");
		String region_S_Id1 = multi.getParameter("region_S_Id1");
		String region_S_Id2 = multi.getParameter("region_S_Id2");
		String region_S_Id3 = multi.getParameter("region_S_Id3");
		String category_L_Id1 = multi.getParameter("category_L_Id1");
		String category_L_Id2 = multi.getParameter("category_L_Id2");
		String category_L_Id3 = multi.getParameter("category_L_Id3");
		String category_L_Id4 = multi.getParameter("category_L_Id4");
		String category_L_Id5 = multi.getParameter("category_L_Id5");
		
		try
		{
			MemberInfo member = new MemberInfo();
			
			member.setUrl(url);
			member.setName(name);
			member.setUserId(userId);
			member.setEmail(email);
			member.setPwd(password);
			member.setSsn(ssn);
			member.setTel(tel);
			member.setNickname(nickName);
			member.setRegionId1(region_S_Id1);
			member.setRegionId2(region_S_Id2);
			member.setRegionId3(region_S_Id3);
			member.setCategoryId1(category_L_Id1);
			member.setCategoryId2(category_L_Id2);
			member.setCategoryId3(category_L_Id3);
			member.setCategoryId4(category_L_Id4);
			member.setCategoryId5(category_L_Id5);
			
			dao.memberInfoAdd(member);
			dao.search(userId);
			
			mav.addObject("userId", userId);
			mav.addObject("nickName", nickName);
			
			
			mav.setViewName("/WEB-INF/view/JoinConfirm.jsp");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}     
		
		return mav;
	}

}
