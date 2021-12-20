/*===============================
	Member.java
	- 회원 DTO
================================*/

package com.test.mvc;

public class Member
{
	// 주요 속성 구성
	private String mid, bDate, loginDate, categorysId;

	// getter / setter 구성
	public String getMid()
	{
		return mid;
	}

	public void setMid(String mid)
	{
		this.mid = mid;
	}

	public String getbDate()
	{
		return bDate;
	}

	public void setbDate(String bDate)
	{
		this.bDate = bDate;
	}

	public String getLoginDate()
	{
		return loginDate;
	}

	public void setLoginDate(String loginDate)
	{
		this.loginDate = loginDate;
	}

	public String getCategorysId()
	{
		return categorysId;
	}

	public void setCategorysId(String categorysId)
	{
		this.categorysId = categorysId;
	}
	
}
