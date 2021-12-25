/*===============================
	MemberInfo.java
	- 회원 정보 DTO
================================*/

package com.test.mvc;

public class MemberInfo
{
	// 주요 속성 구성
	
	private String memberId, memberName, ssn, email, tel, pwd	//ssn 의 경우 나중에 코드로 앞자리 뒷자리 구별!
	            , nickname, url, regionId1, regionId2, regionId3, category1, category2, category3, category4, category5, mid, userId;

	// getter / setter 구성
	public String getMemberId()
	{
		return memberId;
	}

	public void setMemberId(String memberId)
	{
		this.memberId = memberId;
	}

	public String getMemberName()
	{
		return memberName;
	}

	public void setMemberName(String memberName)
	{
		this.memberName = memberName;
	}

	public String getSsn()
	{
		return ssn;
	}

	public void setSsn(String ssn)
	{
		this.ssn = ssn;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getNickname()
	{
		return nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getRegionId1()
	{
		return regionId1;
	}

	public void setRegionId1(String regionId1)
	{
		this.regionId1 = regionId1;
	}

	public String getRegionId2()
	{
		return regionId2;
	}

	public void setRegionId2(String regionId2)
	{
		this.regionId2 = regionId2;
	}

	public String getRegionId3()
	{
		return regionId3;
	}

	public void setRegionId3(String regionId3)
	{
		this.regionId3 = regionId3;
	}

	public String getCategory1()
	{
		return category1;
	}

	public void setCategory1(String category1)
	{
		this.category1 = category1;
	}

	public String getCategory2()
	{
		return category2;
	}

	public void setCategory2(String category2)
	{
		this.category2 = category2;
	}

	public String getCategory3()
	{
		return category3;
	}

	public void setCategory3(String category3)
	{
		this.category3 = category3;
	}

	public String getCategory4()
	{
		return category4;
	}

	public void setCategory4(String category4)
	{
		this.category4 = category4;
	}

	public String getCategory5()
	{
		return category5;
	}

	public void setCategory5(String category5)
	{
		this.category5 = category5;
	}

	public String getMid()
	{
		return mid;
	}

	public void setMid(String mid)
	{
		this.mid = mid;
	}

	public String getUserId()
	{
		return userId;
	}

	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	
	
	
}
