/*==========================
 * MainPageController.java
 * - 사용자 정의 컨트롤러
==========================*/

package com.test.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class MainPageController implements Controller
{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		
		//-- 세션 처리에 따른 추가 구성 --------------------------------------------------------
		
		// 로그인 여부만 확인 → 관리자인지 확인할 필요 없음.
		
		HttpSession session =  request.getSession();
		
		if (session.getAttribute("id")==null)		//-- 로그인을 하지 못한 상황
		{
			mav.setViewName("redirect:loginform.action");
			return mav;
		}
		
		
		//----------------------------------------------------------  세션 처리에 따른 추가 구성 
		
		
		try
		{
			mav.setViewName("MainPage.jsp");
			
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		return mav;
	}

}
