<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyClub.jsp</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="<%=cp%>/js/jquery-ui.js"></script>
<script type="text/javascript" src="<%=cp%>/js/ajax.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<script type="text/javascript">
   $(document).ready(function()
   {
      //카테고리 대분류(category_L_Id)가 변경되었을 경우 수행해야 할 코드 처리
      $("#status").change(function()
      {
    	  alert("test");
         //lert($("#category_L_Id").val());

         // Ajax 요청 및 응답 처리
         $.ajax(
         {
            type : "POST"
            ,url : "ajaxcategory.action"
            ,data : {status : $("#status").val()}
            ,dataType : "json" //{key : vlaue}
            ,success : function(result)
            {
               $("#clublist").remove();
               $("#clublist").append("<p> value=\"\"><a href='#'>전체</a></p>");
               
               for(var i=0; i<result.length; i++)
               {
            	   $("#clublist").append("<p><a href='#'>"+result[i].title+"</a></p>");
               } 
            }
            ,error : function(e)
            {
               alert(e.responseText);
            }
         });
      });
      
      
   });
</script>
<style>
/*   .container {
	display: flex;
} */
</style>
</head>
<body>
<!-- 
MyClub.jsp
- 마이페이지 - 나의 동아리 보기
 -->

<div>
	<!-- 네브 영역 -->
	<div>
		<c:import url="nav.jsp"></c:import>
	</div>


	<!-- 메뉴 영역 -->
	<div>
		<!-- 마이페이지 사이드탭 아직 미완성 -->
		<%-- <c:import url="mainSideTab.jsp"></c:import> --%>
	</div>

<!-- ※ table,div 스타일 영역 구분 위해서 임의로 설정해둔거임. 무시하면 됨. ※-->
	<!-- 콘텐츠 영역 -->
	<div id="content" style="margin-left: 30vh; margin-right: 20vh;"><!-- 이 스타일만 유효 -->
		<h1>[ 나의 동아리 ]</h1>
		<hr>

		<div class="container">
			<div class="row">
				<div class="col-lg-2 col-md-3 col-sm-6">
					<select id="status">
						<option selected="selected">활동중</option>
						<option>활동 종료</option>
					</select>
					<div id="clublist">
						<p>- 전체</p>
						<p><a>- A동아리</a></p>
						<p><a>- B동아리</a></p>
					</div>
				</div>
				<div class="col-lg-10 col-md-9 col-sm-6">달력영역
					<table style="display:block; /* width:350px; */ height:300px;  border:1px #000000 solid;">
						
					</table>				
				</div>
			</div>
		</div>
		 
		<div style="display:block; width:600px; height:250px;  border:1px blue solid;">
			<div>
				<select>
						<option selected="selected">전체</option>
						<option>운영하는 동아리</option>
						<option>운영했던 동아리</option>
						<option>가입한 동아리</option>
						<option>가입했던 동아리</option>
						<option>가입신청 동아리</option>
						<option>개설 동의 동아리</option>
				</select>
			</div>
			<div >
				<div class="container">
					<div>
						<a href="" >
							<img src="" alt="" style="display:block; width:150px; height:100px;  border:1px #000000 solid;"/>														
							<p>동아리제목1</p>
						</a>					
					</div>
					<div>
						<a href="">
							<img src="" alt="" style="display:block; width:150px; height:100px;  border:1px #000000 solid;"/>
							<p>동아리제목2</p>
						</a>					
					</div>
					<div>
						<a href="" >
							<img src="" alt="" style="display:block; width:150px; height:100px;  border:1px #000000 solid;"/>
							<p>동아리제목3</p>
						</a>					
					</div>
				</div>
				<a href="">더 보기</a>
			</div>
		</div>
		
		<div style="display:block; width:600px; height:350px;  border:1px green solid;">
			<p>내 동아리 결산</p>
			<div>
				<select>
						<option selected="selected">▼동아리선택</option>
						<option>내 동아리1</option>
						<option>내 동아리2</option>
						<option>내 동아리3</option>						
				</select>
				현재◎ 1개월○ 3개월○ 6개월○
			</div>
			<div style="display:block; width:500px; height:250px;  border:1px pink solid;">
				<p>정모수</p>
				<p>나의 정모 참여율</p>
				<p>회원수/회원증가율</p>
				<p>정모평가개수</p>
				<p>인 당 평균회비</p>
				<p>내가 받은 평가</p>
				<p>총지출</p>
				<p>내가 작성한 게시글</p>
				<p>내가 작성한 댓글</p>
			</div>
		</div>
		
	</div>
	<!-- 풋터영역 -->
      <div>
         <c:import url="footer.jsp"></c:import>
      </div> 
</div>
 

</body>
</html>