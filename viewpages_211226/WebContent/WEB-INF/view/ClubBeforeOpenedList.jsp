<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="pageObject" tagdir="/WEB-INF/tags"%>
<%
   request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ClubBeforeOpenedList.jsp</title>

<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="<%=cp%>/js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=cp%>/js/ajax.js"></script>

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css">

<style>
.box {
    width: 30px;
    height: 30px; 
    border-radius: 70%;
    overflow: hidden;
}
.profile {
    width: 100%;
    height: 100%;
    object-fit: cover;
}
</style>
<script type="text/javascript">
	
	$(document).ready(function()
	{
		
		//카테고리 대분류(category_L_Id)가 변경되었을 경우 수행해야 할 코드 처리
		$("#category_L_Id").change(function()
		{
			//lert($("#category_L_Id").val());
			
			// Ajax 요청 및 응답 처리
			$.ajax(
			{
				type : "POST"
				,url : "ajaxcategory.action"
				,data : {category_L_Id : $("#category_L_Id").val()}
				,dataType : "json" //{key : vlaue}
				,success : function(result)
				{
					$("#category_S_Id").children().remove();
					$("#category_S_Id").append("<option value=\"\">소분류</option>");
					
					for(var i=0; i<result.length; i++)
					{
						$("#category_S_Id").append("<option value=\""+result[i].category_s_id+"\">"+result[i].s_cat+"</option>");
					}
					
				}
				,error : function(e)
				{
					alert(e.responseText);
				}
			});
		});
		
		//지역 대분류(region_L_Id)가 변경되었을 경우 수행해야 할 코드 처리 
		$("#region_L_Id").change(function()
		{
			//alert('변경');
			//alert($("#region_L_Id").val());
			
			$.ajax(
			{
				type : "POST"
				,url : "ajaxregion.action"
				,data : {region_L_Id : $("#region_L_Id").val()}
				,dataType : "json"
				,success : function(result)
				{
					$("#region_S_Id").children().remove();
					$("#region_S_Id").append("<option value=\"\">군/구</option>");
					
					for(var i=0; i<result.length; i++)
					{
						$("#region_S_Id").append("<option value=\""+result[i].region_s_id+"\">"+result[i].local+"</option>");
					}
				}
				,error : function(e)
				{
					alert(e.responseText);
				}
			
		 	});
	
		});
		
		  // 검색 submit -> clubprelistform.action
	      $("#searchBtn").click(function()
	      {
	    	  alert("확인");
	    	  $("#searchForm").submit();
	      });
		
	});
</script>
</head>
<body>
   <!-- 
ClubBeforeOpenedList.jsp
- 메인화면(로그인 전) 페이지 2 -⑤ 회원 모집 동아리 리스트
 -->

	<!-- nav 영역 -->
	<div>
		<c:import url="nav.jsp"></c:import>
	</div>

	<!-- 컨텐츠영역 -->
	<div>
		<h1>개설 예정 동아리 리스트</h1>
		<%--   <h1>${id}</h1> 로그인한 아이디가 뜬다 --%>
	</div>
	<div>
		<form action="clubprelistform.action" id="searchForm">
			<!-- 페이지 정보를 다시 그대로 보내준다. -->
		<%-- 	<input type="hidden" name="page" value="${pageObject.page}">
			<input type="hidden" name="perPageNum" value="${pageObject.perPageNum}"> --%>
			<div>
				카테고리 <select id="category_L_Id" name="category_L_Id">
					<option value=""  ${(param.category_L_Id == "")?"selected":""}>대분류</option>
					<c:forEach var="category" items="${categoryLList }">
						<option value="${category.category_l_id }"
						${(param.category_L_Id == category.category_l_id)?"selected":""}>${category.l_cat }</option>
					</c:forEach>
				</select> <select id="category_S_Id" name="category_S_Id">
					<option value=""  ${(param.category_S_Id == "")?"selected":""}>소분류</option>
				</select>
			</div>
			<div>
			지역 <select id="region_L_Id" name="region_L_Id">
					<option value=""  ${(param.region_L_Id == "")?"selected":""}>시</option>
					<c:forEach var="region" items="${regionLList }">
						<option value="${region.region_l_id }" 
						${(param.region_L_Id == region.region_l_id)?"selected":""}>${region.city }</option>
					</c:forEach>
				</select> <select id="region_S_Id" name="region_S_Id">
					<option value=""  ${(param.region_S_Id == "")?"selected":""}>군/구</option>
				</select>
			</div>
			<br>
			<div>
			<%-- 	<input type="text" value = "${param.order }"> --%>
				<select id="order" name="order">
					<!-- 동아리 정렬 방법 -->
					<option value="1"  ${(param.order == "1")?"selected":""}>최신순</option>
					<option value="2" ${(param.order == "2")?"selected":""}>등록순</option>
				</select> <input type="text" placeholder="동아리 검색" name="searchValue"
				value="${param.searchValue}" /> 
				<input type="button" value="검색" id="searchBtn" class="searchBtn">
			</div>

		</form>
	</div>

	<br>
	<br>

	<div class="row">
		<!-- 이미지 데이터가 있는 만큼 반복 처리  -->
		<c:forEach var="preclub" items="${preopenList}">
			<!-- 하나의 이미지 -->
			<div class="col-md-4">
				<!-- 한줄의 3분의 1 -->
				<div class="thumbnail">
					<!-- 겉 감싸주는 액자(?)클래스 -->
					<a href="preopenclubdetail.action?cid=${preclub.cid}"> <img
						src="${preclub.url}" alt="${preclub.title}" style="width: 50%;">
						<div class="caption">
							<!-- 이미지 밑의 글귀 -->
							<p>${preclub.title}</p>
							<div>D - ${preclub.day}</div>
						</div>
					</a>
				</div>
			</div>
		</c:forEach>
	</div>


	<!-- 페이지네이션 -->
	<div>
		<pageObject:pageNav listURI="clubprelistform.action" pageObject="${pageObject}" />
	</div>


	<!-- 풋터영역 -->
	<div>
		<c:import url="footer.jsp"></c:import>
	</div>



</body>
</html>