/*===============================
	MemberInfo.java
	- 회원 정보 DTO
================================*/

package com.test.mvc;

public class MemberInfo
{
	// 주요 속성 구성
	
	// MEMBERINFO 속성
	private String id, name, ssn, email, tel, pwd			// 회원ID, 이름, 주민번호, 이메일, 전화번호, 비밀번호
	            , nickname, url, regionId1,  mid, userId;	// 닉네임, 사진 url, 지역코드, 회원코드, 아이디
	
	// MEMBER 속성
	private String bdate, login_date, categoryId1;			// 가입일자, 마지막 로그인 날짜, 카테고리 소분류 코드 
	
	// ADD_REGION 속성
	private String add_region_id , regionId2, regionId3;	// 지역 선택 코드, 추가 지역코드2, 추가 지역코드3 (소분류)
	
	// ADD_CATEGORY 속성
	private String add_category_id, categoryId2, categoryId3, categoryId4, categoryId5;	//카테고리 선택 코드, 추가 카테고리코드2, 추가 카테고리코드3, 추가 카테고리코드4,추가 카테고리코드5
	
	// 지역 대분류 속성
	private String region_L_Id1, region_L_Id2, region_L_Id3;	// 지역 대분류 1 2 3
	
		
	// getter / setter 구성
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
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
	public String getBdate()
	{
		return bdate;
	}
	public void setBdate(String bdate)
	{
		this.bdate = bdate;
	}
	public String getLogin_date()
	{
		return login_date;
	}
	public void setLogin_date(String login_date)
	{
		this.login_date = login_date;
	}
	public String getCategoryId1()
	{
		return categoryId1;
	}
	public void setCategoryId1(String categoryId1)
	{
		this.categoryId1 = categoryId1;
	}
	public String getAdd_region_id()
	{
		return add_region_id;
	}
	public void setAdd_region_id(String add_region_id)
	{
		this.add_region_id = add_region_id;
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
	public String getAdd_category_id()
	{
		return add_category_id;
	}
	public void setAdd_category_id(String add_category_id)
	{
		this.add_category_id = add_category_id;
	}
	public String getCategoryId2()
	{
		return categoryId2;
	}
	public void setCategoryId2(String categoryId2)
	{
		this.categoryId2 = categoryId2;
	}
	public String getCategoryId3()
	{
		return categoryId3;
	}
	public void setCategoryId3(String categoryId3)
	{
		this.categoryId3 = categoryId3;
	}
	public String getCategoryId4()
	{
		return categoryId4;
	}
	public void setCategoryId4(String categoryId4)
	{
		this.categoryId4 = categoryId4;
	}
	public String getCategoryId5()
	{
		return categoryId5;
	}
	public void setCategoryId5(String categoryId5)
	{
		this.categoryId5 = categoryId5;
	}
	public String getRegion_L_Id1()
	{
		return region_L_Id1;
	}
	public void setRegion_L_Id1(String region_L_Id1)
	{
		this.region_L_Id1 = region_L_Id1;
	}
	public String getRegion_L_Id2()
	{
		return region_L_Id2;
	}
	public void setRegion_L_Id2(String region_L_Id2)
	{
		this.region_L_Id2 = region_L_Id2;
	}
	public String getRegion_L_Id3()
	{
		return region_L_Id3;
	}
	public void setRegion_L_Id3(String region_L_Id3)
	{
		this.region_L_Id3 = region_L_Id3;
	}
	

	
	
	
}
