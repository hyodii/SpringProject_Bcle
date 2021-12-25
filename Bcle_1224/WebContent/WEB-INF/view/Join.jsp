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
<title>Join.jsp</title>

<link rel="stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<style type="text/css">
/* .outer {
  display: flex;
  align-items: center; 
  flex-direction: row; 
  justify-content: center; 
}
.inner {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%,-50%);
} */

.outer
{
	border: 1px solid #ccc;
	border-radius: 5px;
	width: 100vh;
	padding: 50px;
	margin: 5vh 50vh;
}


</style>
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">


function emailSend()
{
   if(!isValidEmail($("#email").val()))
   {
      $("#email").val("");
      $("#e_msg").html('이메일 형식에 맞지 않습니다.');
      $("#e_msg").css("display","inline");
      return;
   }
   else
   {
      $("#e_msg").html('');
   
   }
      
}


$(document).ready(function()   // 페이지가 로드됐을 때 제이쿼리 실행?
{
	// 지역 같은값 중복 방지
	$("#region_S_Id2").change(function()
	{
		if( $("#region_S_Id2").val() == $("#region_S_Id1").val())
		{
			alert("이미 선택하신 지역 입니다.");
			$('#region_S_Id2').val('');
			return false;
		}
	});
	
	$("#region_S_Id3").change(function()
	{
		if( $("#region_S_Id3").val() == $("#region_S_Id1").val() || $("#region_S_Id3").val() == $("#region_S_Id2").val())
		{
			alert("이미 선택하신 지역 입니다.");
			$('#region_S_Id3').val('');
			return false;
		}
	});
	/*
	// 카테고리 같은값 중복 방지
	$("#category_L_Id2").change(function()
	{
		//alert("이미 선택하신 카테고리 입니다.");
		if( $("#category_S_Id2").val() == $("#category_S_Id1").val())
		{
			alert("이미 선택하신 카테고리 입니다.");
			$('#category_L_Id2').val('');
			return false;
		}
	});
	
	$("#category_L_Id3").change(function()
	{
		if( $("#category_S_Id3").val() == $("#category_S_Id2").val() || $("#category_S_Id3").val() == $("#category_S_Id1").val())
		{
			alert("이미 선택하신 카테고리 입니다.");
			$('#category_L_Id3').val('');
			return false;
		}
	});
	
	$("#category_L_Id4").change(function()
	{
		if( $("#category_S_Id4").val() == $("#category_S_Id3").val() || $("#category_S_Id4").val() == $("#category_S_Id2").val()
				|| $("#category_S_Id4").val() == $("#category_S_Id1").val())
		{
			alert("이미 선택하신 카테고리 입니다.");
			$('#category_L_Id4').val('');
			return false;
		}
	});
	
	$("#category_L_Id5").change(function()
	{
		if( $("#category_S_Id5").val() == $("#category_S_Id4").val() || $("#category_S_Id5").val() == $("#category_S_Id3").val()
				|| $("#category_S_Id5").val() == $("#category_S_Id2").val() || $("#category_S_Id5").val() == $("#category_S_Id1").val())
		{
			alert("이미 선택하신 카테고리 입니다.");
			$('#category_L_Id5').val('');
			return false;
		}
	});
	*/
	
	$("#ssn2").focusout(function()
    {
    let ssn = $("#ssn1").val()+$("#ssn2").val();
    
    //alert(ssn);
    
    $.ajax({
       url : "ssncheck.action"
       ,type : "POST"
       ,data : {ssn:ssn}
       ,dataType:"json"
       ,success:function(result)
       {
          //alert("testtest");
          if(result.checkSsn==0)
          {
             alert("사용중인 계정입니다.");
             //$("#ssn1").val("");
             //$("#ssn2").val("");
          }
          
       }
       , error:function(e)
       {
          alert(e.responseText);
       }
    })
    
   })
    
    //var result = "";
    //alert("test");
    $("#pwd").focusout(function()
    {
       $("#p_msg1").html('');
       if($("#pwd").val()=="")
       {
          $("#p_msg1").html('');
       }
       else if(!isPassword($("#pwd").val()) )
       {   
          $("#p_msg1").html('특수문자을 포함한 숫자, 영어 포함 8~16자를 입력해야 합니다.');
          $("#p_msg1").css("display", "inline");
          $("#pwd").val("");
       }
       
       
       
    });
    
    $("#pwd2").focusout(function()
    {
       //alert("test");
       //alert($("#pwd").val() + ":" + $("#pwd2").val());
       $("#p_msg1").html('');
       if($("#pwd2").val()=="")
       {
          $("#p_msg2").html('');
       }
       else if($("#pwd").val()==$("#pwd2").val()&&$("#pwd"))
       {
             
          $("#p_msg2").html('비밀번호가 일치합니다.');
          $("#p_msg2").css("display", "inline");
       }
       
       else
       {
          
          $("#p_msg2").html('비밀번호가 일치하지 않습니다.');
          $("#p_msg2").css("display", "inline");
          $("#pwd2").val("");
          //$("#pwd2").val()="";
       }
    });
    
    $("#tel1").focusout(function()
    {
       
       $("#t_msg").html('');
       if($("#tel1").val()=="")
       {
          $("#t_msg2").html('');
       }
       else if(!isValidPhone($("#tel1").val()) )
       {
          $("#t_msg").html("잘못된 연락처 형식입니다. '-' 포함해서 입력해주세요.");
          $("#t_msg").css("display", "inline");
          $("#tel1").val("");
       }
    });
    
    $("#ssn2").focusout(function()
    {   
       $("#s_msg").html('');
       if(!isValidResidentNO($("#ssn1").val(),$("#ssn2").val()))
       {   
          $("#s_msg").html("잘못된 주민번호입니다.");
          $("#s_msg").css("display", "inline");
          $("#ssn2").val("");
          $("#ssn1").val("");
       }
    });

	
	
	//각 상황별 alert 창 → required로 했는데 클리어하지가 않아서, 각 상황에 맞게 알림창을 띄우기로했다.
	$("#submitBtn").click(function()
	{
	   if ($("#file").val().length == 0)
	   {
	      alert("사진을 등록해주세요.");
	      $("#file").focus();
	      return false;
	   }
	   if ($("#name").val().length == 0)
	   {
	      alert("이름을 입력해주세요.");
	      $("#name").focus();
	      return false;
	   }
	   if ($("#userId").val().length == 0)
	   {
	      alert("아이디를 입력해주세요.");
	      $("#userId").focus();
	      return false;
	   }
	   if ($("#email").val().length == 0)
	   {
	      alert("이메일을 입력해주세요.");
	      $("#email").focus();
	      return false;
	   }
	   if ($("#pwd").val().length == 0)
	   {
	      alert("비밀번호를 입력해주세요.");
	      $("#pwd").focus();
	      return false;
	   }
	   if ($("#pwd2").val().length == 0)
	   {
	      alert("비밀번호를 다시 입력해주세요.");
	      $("#pwd2").focus();
	      return false;
	   }
	   if ($("#ssn").val().length == 0)
	   {
	      alert("주민번호 앞자리를 입력해주세요.");
	      $("#ssn").focus();
	      return false;
	   }
	   if ($("#ssn2").val().length == 0)
	   {
	      alert("주민번호 뒷자리를 입력해주세요.");
	      $("#ssn2").focus();
	      return false;
	   }
	   if ($("#tel").val().length == 0)
	   {
	      alert("연락처를 입력하세요.");
	      $("#tel").focus();
	      return false;
	   }
	   if ($("#nickName").val().length == 0)
	   {
	      alert("닉네임을 입력하세요.");
	      $("#nickName").focus();
	      return false;
	   }
	   
	   if ($("#region_S_Id1").val().length == 0)
	   {
	      alert("지역은 1개까지 필수 입력사항입니다.");
	      $("#region_S_Id1").focus();
	      return false;
	   }
	   
	   if ($("#category_L_Id1").val().length == 0)
	   {
	      alert("카테고리는 1개까지 필수 입력사항입니다.");
	      $("#category_L_Id1").focus();
	      return false;
	   }
	   
	   
	   $("#joinForm").submit();
	});
	
	
	
	// 아이디 중복 검사
	//alert("test");
	$('.input_id').keyup(function()
	{
		let userId = $('.input_id').val();	
		
		//alert(userId);
		
		$.ajax({
			url : "checkid.action"
			, type : "POST"
			, data : {userId : userId}
			, dataType : "json"		// check~!!!
			, success : function(result)
			{
				if(result.checkId == 0){
					//alert(result.checkId);
					//alert("사용할 수 없는 아이디");
					$("#checkId").html('사용할 수 없는 아이디입니다.');
					$("#checkId").css('color', 'red');
					$('#userId').val('');	// 사용할 수 없으면 빈칸으로 만들기
				}
				else
				{
					//alert(result.checkId);
					//alert("사용할 수 있는 아이디");
					$("#checkId").html('사용할 수 있는 아이디입니다.');
					$("#checkId").css('color', 'green');
				}
			}
			, error : function(e)
			{
				alert(e.responseText);
			}
		});
	});
	
	
	// 닉네임 중복 검사
	$('.input_nickname').keyup(function()
	{
		let nickname = $('.input_nickname').val();	
		
		
		$.ajax({
			url : "checknickname.action"
			, type : "POST"
			, data : {nickname : nickname}
			, dataType : "json"		
			, success : function(result)
			{
				if(result.checkNickName == 0){
					$("#checkNickName").html('사용할 수 없는 닉네임입니다.');
					$("#checkNickName").css('color', 'red');
					$('.input_nickname').val('');
				}
				else
				{
					$("#checkNickName").html('사용할 수 있는 닉네임입니다.');
					$("#checkNickName").css('color', 'green');
				}
			}
			, error : function(e)
			{
				alert(e.responseText);
			}
		});
	});
	
	
	// 이름 한글만 되도록 하는 정규식 유효성 검사
	$('#name').keypress(function onlyHangul() 
	{
		if((event.keyCode < 12592) || (event.keyCode > 12687)) 
		{
			if(navigator.appName=="Netscape")
			{
				event.preventDefault();
				alert("한글만 입력할 수 있습니다!!");
			}
			else
				event.returnValue = false;
		}
	});
	
	
	
	// 지역 대분류 → 소분류 선택 - 1
	$("#region_L_Id1").change(function()
	{
	   //alert('변경');
	   //alert($("#region_L_Id").val());
	   
	   $.ajax(
	   {
	      type : "POST"
	      ,url : "ajaxjoinregion.action"
	      ,data : {region_L_Id : $("#region_L_Id1").val()}
	      ,dataType : "json"
	      ,success : function(result)
	      {
	         //alert(result);
	         $("#region_S_Id1").children().remove();
	         $("#region_S_Id1").append("<option value=\"\">선택</option>");
	         
	         for(var i=0; i<result.length; i++)
	         {
	            $("#region_S_Id1").append("<option value=\""+result[i].region_s_id+"\">"+result[i].local+"</option>");
	         }
	      }
	      ,error : function(e)
	      {
	         alert(e.responseText);
	      }
	   
	    });
	
	});
	
	// 지역 대분류 → 소분류 선택 - 2
	$("#region_L_Id2").change(function()
	{
	   //alert('변경');
	   //alert($("#region_L_Id").val());
	   
	   $.ajax(
	   {
	      type : "POST"
	      ,url : "ajaxjoinregion.action"
	      ,data : {region_L_Id : $("#region_L_Id2").val()}
	      ,dataType : "json"
	      ,success : function(result)
	      {
	         //alert(result);
	         $("#region_S_Id2").children().remove();
	         $("#region_S_Id2").append("<option value=\"\">선택</option>");
	         
	         for(var i=0; i<result.length; i++)
	         {
	            $("#region_S_Id2").append("<option value=\""+result[i].region_s_id+"\">"+result[i].local+"</option>");
	         }
	      }
	      ,error : function(e)
	      {
	         alert(e.responseText);
	      }
	   
	    });
	
	});
	
	// 지역 대분류 → 소분류 선택 - 3
	$("#region_L_Id3").change(function()
	{
	   //alert('변경');
	   //alert($("#region_L_Id").val());
	   
	   $.ajax(
	   {
	      type : "POST"
	      ,url : "ajaxjoinregion.action"
	      ,data : {region_L_Id : $("#region_L_Id3").val()}
	      ,dataType : "json"
	      ,success : function(result)
	      {
	         //alert(result);
	         $("#region_S_Id3").children().remove();
	         $("#region_S_Id3").append("<option value=\"\">선택</option>");
	         
	         for(var i=0; i<result.length; i++)
	         {
	            $("#region_S_Id3").append("<option value=\""+result[i].region_s_id+"\">"+result[i].local+"</option>");
	         }
	      }
	      ,error : function(e)
	      {
	         alert(e.responseText);
	      }
	   
	    });
	
	});
	
	
	// 소분류 지역 버튼 클릭 이벤트 등록 및 지역에 값 넣기 액션 처리 - 1
	$("#region_S_Id1").click(function()
	{	
		 $("#region_S_Id1").append("<option value=\"\">전체</option>");
				
		// 여기서의 this는 #소분류   이거아님!
		var regionS = $("select[name=region_S_Id1] option:selected").text();
		
		/* // 위에 담은 변수를 대입
		$("#regionS1").val(regionS);
		$("#regionS1").css('background-color', 'skyblue');
		$("#regionS1").css('color', 'white'); */
	});
	
	// 소분류 지역 버튼 클릭 이벤트 등록 및 지역에 값 넣기 액션 처리 - 2
	$("#region_S_Id2").click(function()
	{	
		 $("#region_S_Id2").append("<option value=\"\">전체</option>");
				
		// 여기서의 this는 #소분류   이거아님!
		var regionS = $("select[name=region_S_Id2] option:selected").text();
		
		/* // 위에 담은 변수를 대입
		$("#regionS2").val(regionS);
		$("#regionS2").css('background-color', 'skyblue');
		$("#regionS2").css('color', 'white'); */
		
	});
	
	// 소분류 지역 버튼 클릭 이벤트 등록 및 지역에 값 넣기 액션 처리 - 3
	$("#region_S_Id3").click(function()
	{	
		 $("#region_S_Id3").append("<option value=\"\">전체</option>");
				
		// 여기서의 this는 #소분류   이거아님!
		var regionS = $("select[name=region_S_Id3] option:selected").text();
		
		/* // 위에 담은 변수를 대입
		$("#regionS3").val(regionS);
		$("#regionS3").css('background-color', 'skyblue');
		$("#regionS3").css('color', 'white'); */
		
	});
	  
			
	
	// 카테고리 대분류만 선택 - 1
	$("#category_L_Id1").click(function()
	{
		var category1 = $("select[name=category_L_Id1] option:selected").text();
		/* // 위에 담은 변수를 대입
		$("#category1").val(category1);
		$("#category1").css('background-color', 'green');
		$("#category1").css('color', 'white'); */
		
	});
	
	// 카테고리 대분류만 선택 - 2
	$("#category_L_Id2").click(function()
	{
		var category2 = $("select[name=category_L_Id2] option:selected").text();
		/* // 위에 담은 변수를 대입
		$("#category2").val(category2);
		$("#category2").css('background-color', 'green');
		$("#category2").css('color', 'white'); */
		
	});
	
	// 카테고리 대분류만 선택 - 3
	$("#category_L_Id3").click(function()
	{
		var category3 = $("select[name=category_L_Id3] option:selected").text();
		/* // 위에 담은 변수를 대입
		$("#category3").val(category3);
		$("#category3").css('background-color', 'green');
		$("#category3").css('color', 'white'); */
		
	});
	
	// 카테고리 대분류만 선택 - 4
	$("#category_L_Id4").click(function()
	{
		var category4 = $("select[name=category_L_Id4] option:selected").text();
		/* // 위에 담은 변수를 대입
		$("#category4").val(category4);
		$("#category4").css('background-color', 'green');
		$("#category4").css('color', 'white'); */
		
	});
	
	
	// 카테고리 대분류만 선택 - 5
	$("#category_L_Id5").click(function()
	{
		var category5 = $("select[name=category_L_Id5] option:selected").text();
		/* // 위에 담은 변수를 대입
		$("#category5").val(category5);
		$("#category5").css('background-color', 'green');
		$("#category5").css('color', 'white'); */
		
	});
	

});
</script>

</head>
<body>
<!-- 
 - 회원가입하기 페이지
 -->
<div>
<!-- nav 영역 -->
<div>
	<c:import url="subHeader.jsp"></c:import>
</div>

<div class="subheader">
		<p>B:CLE</p>
		<p class="title">회원가입 하기</p>
	</div>

<div class="outer">
	<!-- <div class="inner"> -->
		<div class="row register-form">
		<form action="join.action" method="post" id="joinForm" enctype="multipart/form-data">
			<p id="err" style="color: red; font-size: small;">* 는 필수 입력사항 입니다.</p><br>
			<div class="form-group col-md-12 col-sm-12">  
				프로필 사진*<br>
				<input type="file" id="file" value="등록" required="required">
			</div>
			<br>
			<div class="form-group col-md-6 col-sm-6">
				<label for="name">이름*</label>
				<input type="text" id="name" placeholder="이름을 입력하세요." required="required" class="form-control"/>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">이름을 입력해주세요.</span><br> -->
			</div>
			<div class="id form-group col-md-6 col-sm-6">
				<label for="userId">아이디*
					<input type="text" id="userId" placeholder="아이디를 입력하세요." required="required" class="input_id form-control"/>
					<!-- <input type="button" value="중복확인" id="check"> -->
					<!-- <span id="err" style="display: none; color: red; font-size: small;">아이디를 입력해주세요.</span><br> -->
					<span id=checkId  style="font-size: small;"></span><br>
				</label>
			</div>
			<div class="form-group col-md-6 col-sm-6">
				<label for="email">이메일*</label>
				<input type="email" id="email" placeholder="이메일을 입력하세요." required="required" class="form-control"/>
				<span id="e_msg" style="display: none; color: red; font-size: small;"></span><br>
	            <button id="emailCheck" onclick="emailSend()">인증코드 보내기</button><br>
	            <input type="text" id="certificationNumber" placeholder="인증코드를 입력하세요." class="form-control">
	            <button id="certificationBtn" onclick="emailCertification()">인증하기</button>
	            <span id="err" style="display: none; color: red; font-size: small;">인증코드가 일치하지 않습니다.</span><br>
			</div>
			<!-- 여기서부터 해야함 -->
			<div class="form-group col-md-6 col-sm-6">
				<label for="pwd">비밀번호*</label>
				<input type="password" id="pwd" placeholder="패스워드를 입력하세요." required="required" class="form-control"/>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">비밀번호를 입력해주세요.</span><br> -->
			</div>
			<div class="form-group col-md-6 col-sm-6">
				<label for="pwd2">비밀번호 재확인*</label>
				<input type="password" id="pwd2" placeholder="패스워드를 다시 입력하세요." required="required" class="form-control"/>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">비밀번호를 한번 더입력해주세요.</span><br> -->
			</div>
			<div class="form-group col-md-12 col-sm-12">
				<label for="ssn">주민번호*</label><br>
				<!-- <input type="text" id="ssn" required="required" class="form-control" placeholder="000000-0000000 형식으로 입력해주세요."> -->
				<input type="text" id="ssn" required="required" style="height: 30px; border:1px solid #ccc;"> - <input type="text" id="ssn2" required="required" style="height: 30px; border:1px solid #ccc;">
				<input type="button" value="본인인증"><br>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">주민번호를 입력해주세요.</span><br> -->
			</div>
			<div class="form-group col-md-12 col-sm-12">
				<label for="tel">연락처*</label>
				<input type="tel" id="tel" required="required" class="form-control" placeholder="010-0000-0000 형식으로 입력해주세요.">
				<!-- <input type="tel" id="tel1" required="required" style="width: 100px"> - <input type="tel" id="tel2" required="required" style="width: 100px"> - <input type="tel" id="tel3" required="required" style="width: 100px"><br> -->
				<!-- <span id="err" style="display: none; color: red; font-size: small;">전화번호를 입력해주세요.</span><br> -->
			</div>
			<div class="form-group col-md-6 col-sm-6">
				<label for="nickName">닉네임*</label>
				<input type="text" id="nickName" placeholder="ex) 행복한비클" required="required" class="input_nickname form-control">
				<!-- <input type="button" value="중복확인"> -->
				<!-- <input type="button" value="랜덤생성"> -->
				<!-- <span id="err" style="display: none; color: red; font-size: small;">닉네임을 입력해주세요.</span><br> -->
				<span id=checkNickName  style="font-size: small;"></span><br>
			</div>
			<br>
			<div class="form-group col-md-6 col-sm-6">
				<label for="nickName">첫 번째 지역설정</label>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">지역은 최소 1개 설정해야합니다.</span><br> -->
				시*
				<select name="region_L_Id1" id="region_L_Id1" required="required" class="form-control">
					<c:forEach var="region" items="${regionLList }">
                       <option value="${region.region_l_id }">${region.city }</option>
                    </c:forEach>
				</select>
				군·구*
				<select name="region_S_Id1" id="region_S_Id1" required="required" class="form-control">
					<option value="">군·구 단위</option>
				</select><br>
				<!-- <input type="text" id="regionS1" placeholder="지역1" required="required"> -->
			</div>
			<div class="form-group col-md-6 col-sm-6">
				<label for="nickName">두 번째 지역설정</label>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">지역은 최소 1개 설정해야합니다.</span><br> -->
				시
				<select name="region_L_Id2" id="region_L_Id2" required="required" class="form-control">
					<c:forEach var="region" items="${regionLList }">
                       <option value="${region.region_l_id }">${region.city }</option>
                    </c:forEach>
				</select>
				군·구
				<select name="region_S_Id2" id="region_S_Id2" required="required" class="form-control">
					<option value="">군·구 단위</option>
				</select><br>
				<!-- <input type="text" id="regionS2" placeholder="지역2"> -->
			</div>
			<div class="form-group col-md-6 col-sm-6">
				<label for="nickName">세 번째 지역설정</label>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">지역은 최소 1개 설정해야합니다.</span><br> -->
				시
				<select name="region_L_Id3" id="region_L_Id3" required="required" class="form-control">
					<c:forEach var="region" items="${regionLList }">
                       <option value="${region.region_l_id }">${region.city }</option>
                    </c:forEach>
				</select>
				군·구
				<select name="region_S_Id3" id="region_S_Id3" required="required" class="form-control">
					<option value="">군·구 단위</option>
				</select><br>
				<!-- <input type="text" id="regionS3" placeholder="지역3"> -->
			</div>
			<br>
			<div class="form-group col-md-6 col-sm-6">
				<label for="category">첫 번째 관심카테고리*</label>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">관심카테고리는 최소 1개 설정해야합니다.</span><br> -->
				<select name="category_L_Id1" id="category_L_Id1" required="required" class="form-control">
					<option value="">카테고리 선택</option>
					<c:forEach var="category" items="${categoryLList }">
                       <option value="${category.category_l_id }">${category.l_cat }</option>
                    </c:forEach>
				</select><br>
				<!-- <input type="text" id="category1" placeholder="카테고리1" required="required"> -->
			</div>
			<div class="form-group col-md-6 col-sm-6">
				<label for="category">두 번째 관심카테고리</label>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">관심카테고리는 최소 1개 설정해야합니다.</span><br> -->
				<select name="category_L_Id2" id="category_L_Id2" required="required" class="form-control">
					<option value="">카테고리 선택</option>
					<c:forEach var="category" items="${categoryLList }">
                       <option value="${category.category_l_id }">${category.l_cat }</option>
                    </c:forEach>
				</select><br>
				<!-- <input type="text" id="category2" placeholder="카테고리2"> -->
			</div>
			<div class="form-group col-md-6 col-sm-6">
				<label for="category">세 번째 관심카테고리</label>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">관심카테고리는 최소 1개 설정해야합니다.</span><br> -->
				<select name="category_L_Id3" id="category_L_Id3" required="required" class="form-control">
					<option value="">카테고리 선택</option>
					<c:forEach var="category" items="${categoryLList }">
                       <option value="${category.category_l_id }">${category.l_cat }</option>
                    </c:forEach>
				</select><br>
				<!-- <input type="text" id="category3" placeholder="카테고리3"> -->
			</div>
			<div class="form-group col-md-6 col-sm-6">
				<label for="category">네 번째 관심카테고리</label>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">관심카테고리는 최소 1개 설정해야합니다.</span><br> -->
				<select name="category_L_Id4" id="category_L_Id4" required="required" class="form-control">
					<option value="">카테고리 선택</option>
					<c:forEach var="category" items="${categoryLList }">
                       <option value="${category.category_l_id }">${category.l_cat }</option>
                    </c:forEach>
				</select><br>
				<!-- <input type="text" id="category4" placeholder="카테고리4"> -->
			</div>
			<div class="form-group col-md-6 col-sm-6">
				<label for="category">다섯 번째 관심카테고리</label>
				<!-- <span id="err" style="display: none; color: red; font-size: small;">관심카테고리는 최소 1개 설정해야합니다.</span><br> -->
				<select name="category_L_Id5" id="category_L_Id5" required="required" class="form-control">
					<option value="">카테고리 선택</option>
					<c:forEach var="category" items="${categoryLList }">
                       <option value="${category.category_l_id }">${category.l_cat }</option>
                    </c:forEach>
				</select><br>
				<!-- <input type="text" id="category5" placeholder="카테고리5"> -->
			</div>
			
			<div class="form-group col-md-12 col-sm-12" style="text-align: center;">
				<!-- <span id="err" style="display: none; color: red; font-size: small;">회원가입의 항목들을 모두 입력해주세요.</span><br> -->
				<input type="button" value="가입하기" id="submitBtn" class="btn btn-warning">
				<!-- <input type="reset" value="모두 지우기" class="btn btn-warning"> -->
				<input type="button" value="취소" class="btn btn-warning"
				onclick="javascript:location.href='<%=cp%>/loginpage.action'">
			</div>
		</form>
		</div>
	<!-- </div> -->
	
</div>

	<div>
		<c:import url="footer.jsp"></c:import>
	</div>

</div>

</body>
</html>