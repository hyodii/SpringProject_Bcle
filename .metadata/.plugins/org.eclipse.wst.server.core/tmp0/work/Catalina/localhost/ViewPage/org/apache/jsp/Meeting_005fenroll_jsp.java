/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.54
 * Generated at: 2021-12-19 12:06:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Meeting_005fenroll_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1639549998000L));
    _jspx_dependants.put("jar:file:/C:/Bcle/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/ViewPage/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");
String cp = request.getContextPath();

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<title>B:CLE</title>\r\n");
      out.write("<!-- <link rel=\"stylesheet\" href=\"css/main.css\"> -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\r\n");
      out.write("<link\r\n");
      out.write("\thref=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"\r\n");
      out.write("\trel=\"stylesheet\"\r\n");
      out.write("\tintegrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"\r\n");
      out.write("\tcrossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("@import\r\n");
      out.write("\turl('https://fonts.googleapis.com/css?family=Exo+2|Noto+Sans+KR&display=swap')\r\n");
      out.write("\t;\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\tfont-family: 'Noto Sans KR', sans-serif;\r\n");
      out.write("\tfont-size: 14px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("\tmargin: 0px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".upper {\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tmargin: 5vh 25vh 0vh 25vh;\r\n");
      out.write("\tpadding-left: 5%;\r\n");
      out.write("\tpadding-right: 5%;\r\n");
      out.write("\tpadding-top: 5%;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".upper>* {\r\n");
      out.write("\tmargin-right: 5vh;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".intro {\r\n");
      out.write("\twidth: 40vh;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".bottom {\r\n");
      out.write("\tdisplay: flex;\r\n");
      out.write("\tpadding: 5%;\r\n");
      out.write("\tmargin: 0vh 25vh 0vh 25vh;\r\n");
      out.write("\tbackground-color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".photo {\r\n");
      out.write("\tmargin: 0vh 30vh 5vh 20vh;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".upper>select, .upper>input {\r\n");
      out.write("\tmargin-left: 1vh;\r\n");
      out.write("\tborder: 3px solid #D9D9D9;\r\n");
      out.write("\tborder-radius: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".left {\r\n");
      out.write("\tpadding-left: 5%;\r\n");
      out.write("\tpadding-right: 5%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".left>input {\r\n");
      out.write("\tborder: 3px solid #D9D9D9;\r\n");
      out.write("\tbackground: #D9D9D9;\r\n");
      out.write("\tborder-radius: 30px;\r\n");
      out.write("\tmargin-bottom: 5vh;\r\n");
      out.write("\tmargin-left: 2vh;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("section.main {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tposition: relative;\r\n");
      out.write("\tz-index: 1;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("section.main::after {\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\theight: 100%;\r\n");
      out.write("\tcontent: \"\";\r\n");
      out.write("\tbackground: url(images/hobby1.jpg) no-repeat center/cover;\r\n");
      out.write("\tposition: absolute;\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("\tleft: 0;\r\n");
      out.write("\tz-index: -1;\r\n");
      out.write("\topacity: 0.5;\r\n");
      out.write("\ttop: 0;\r\n");
      out.write("\tleft: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".main>h2 {\r\n");
      out.write("\tmargin-left: 25vh;\r\n");
      out.write("\tpadding-top: 3%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#min, #max {\r\n");
      out.write("\twidth: 8vh;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".bottom2{\r\n");
      out.write("margin: 0vh 25vh 10vh 25vh;\r\n");
      out.write("display:flex;\r\n");
      out.write("background-color:white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".right{\r\n");
      out.write("background-color:white;\r\n");
      out.write("width:92vh;\r\n");
      out.write("padding-left :5%;\r\n");
      out.write("padding-right :5%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".enroll {\r\n");
      out.write("\tmargin-top: -8vh;\r\n");
      out.write("\tpadding-bottom : 5%;\r\n");
      out.write("\tmargin-left: 45%;\r\n");
      out.write("\tmargin-right: auto;\r\n");
      out.write("}\r\n");
      out.write("/* 사진업로드 관련 */\r\n");
      out.write("#att_zone {\r\n");
      out.write("\twidth: 60vh;\r\n");
      out.write("\tmin-height: 150px;\r\n");
      out.write("\tpadding: 10px;\r\n");
      out.write("\tborder: 1px dotted #00f;\r\n");
      out.write("\tmargin-top:3vh;\r\n");
      out.write("\tmargin-bottom:3vh;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#att_zone:empty:before {\r\n");
      out.write("\tcontent: attr(data-placeholder);\r\n");
      out.write("\tcolor: #999;\r\n");
      out.write("\tfont-size: .9em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/* 날씨&지도 */\r\n");
      out.write(".weather{\r\n");
      out.write("display:flex;\r\n");
      out.write("margin : 5vh 0px 5vh 5vh;\r\n");
      out.write("height : 30%;\r\n");
      out.write("width : 50%;\r\n");
      out.write("}\r\n");
      out.write(".map{\r\n");
      out.write("margin : 0vh;\r\n");
      out.write("height : 30vh;\r\n");
      out.write("width : 30vh;\r\n");
      out.write("background-color : gray;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".weather__box1 {\r\n");
      out.write("    position: relative;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("/*         width : 50%; */\r\n");
      out.write("        height : 30%;\r\n");
      out.write("}\r\n");
      out.write(".weather__icon {\r\n");
      out.write("    width: 100px;\r\n");
      out.write("    height: 100px;\r\n");
      out.write("    margin: 0 auto;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("}\r\n");
      out.write(".weather__box2 {\r\n");
      out.write("    margin: 0px 1vw;\r\n");
      out.write("/*     width : 50%; */\r\n");
      out.write("    height : 30%\r\n");
      out.write("}\r\n");
      out.write(".weather__temperature {\r\n");
      out.write("    width: 50%;\r\n");
      out.write("    font-size: 50px;\r\n");
      out.write("    font-weight: 900;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    line-height: 100px;\r\n");
      out.write("    font-stretch: 50%;\r\n");
      out.write("    font-family: 'Nanum Pen Script', cursive;\r\n");
      out.write("    margin-bottom: -1vh;\r\n");
      out.write("}\r\n");
      out.write("/* .weather__location{\r\n");
      out.write("}\r\n");
      out.write(".weather__description{\r\n");
      out.write("} */\r\n");
      out.write(".weathercontents{\r\n");
      out.write("width : 10vh;\r\n");
      out.write("height : 20vh;\r\n");
      out.write("background-color : lightgray;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("<script type=\"text/javascript\" src=\"http://code.jquery.com/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(cp);
      out.write("/js/jquery-ui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.print(cp);
      out.write("/js/ajax.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(document).ready(function()   // 페이지가 로드됐을 때 제이쿼리 실행?\r\n");
      out.write("    {\r\n");
      out.write("    \t\r\n");
      out.write("        // 직원 추가 버튼이 클릭되었을 때 수행해야 할 코드 처리\r\n");
      out.write("        $(\"#submitBtn\").click(function()\r\n");
      out.write("        {\r\n");
      out.write("\t    \t//alert(\"test\");\r\n");
      out.write("\t    \t\r\n");
      out.write("\t    \t//alert(  $(\"#beeTime2\").val()  );\r\n");
      out.write("\t        \r\n");
      out.write("\t\t\t/*\t \r\n");
      out.write("\t\t\t\t// 테스트 \r\n");
      out.write("\t\t\t\t//alert($(\"#minBasicPay\").val());\t\t\t//--(X)\r\n");
      out.write("\t\t\t\t//alert($(\"#minBasicPay\").text());\t\t\t//--(○)\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t// 최소 기본급에 대한 유효성 검사\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t       */\r\n");
      out.write("\t\t\t\t// 폼 submit 액션 처리 수행\r\n");
      out.write("\t\t\t\t$(\"#beeForm\").submit();\r\n");
      out.write("\t\t  \r\n");
      out.write("\t        });\r\n");
      out.write("\t        \r\n");
      out.write("\t        \r\n");
      out.write("\t    });\r\n");
      out.write("\t   \r\n");
      out.write("\t   \r\n");
      out.write("\t         \r\n");
      out.write("</script>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fimport_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<section class=\"main\">\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"beeinsert.action\" method=\"post\" id=\"beeForm\">\r\n");
      out.write("\t\r\n");
      out.write("\t\t<h2>모임개설</h2>\r\n");
      out.write("\t\t<div class=\"upper\">\r\n");
      out.write("\t\t\t<select class=\"select\" id=\"typeId\" name=\"typeId\">\r\n");
      out.write("\t\t\t\t<option value=\"0\" selected>모임유형</option>\r\n");
      out.write("\t\t\t\t<option value=\"1\">정모</option>\r\n");
      out.write("\t\t\t\t<option value=\"2\">반짝모임</option>\r\n");
      out.write("\t\t\t</select> 모임 제목<input type=\"text\" id=\"title\" name=\"title\" required=\"required\"> 주최자 : 글작성자닉네임 받아오기\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"bottom\">\r\n");
      out.write("\t\t\t<div class=\"intro\">\r\n");
      out.write("\t\t\t\t<h3>모임소개</h3>\r\n");
      out.write("\t\t\t\t<textarea cols=\"50\" rows=\"10\" id=\"content\" name=\"content\" required=\"required\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t ");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"bottom2\">\r\n");
      out.write("\t\t\t\t<div class=\"left\">\r\n");
      out.write("\t\t\t\t\t<h3>자세히 알려주세요</h3>\r\n");
      out.write("\t\t\t\t\t<p>※회원들이 정확히 알고 참여할 수 있도록 구체적인 내용을 기재해주세요.</p>\r\n");
      out.write("\t\t\t\t\t<br></br> 참가비 <input type=\"text\" id=\"fee\" name=\"fee\" required=\"required\"> \r\n");
      out.write("\t\t\t\t\t<br> 모임일 <input type=\"date\" id=\"beeTime1\" name=\"beeTime1\" required=\"required\"> \r\n");
      out.write("\t\t\t\t\t<br> 모임시간<input type=\"time\" id=\"beeTime2\" name=\"beeTime2\" required=\"required\"><br>\r\n");
      out.write("\t\t\t\t\t모임장소<input type=\"text\" id=\"location\" name=\"location\" required=\"required\"><br> \r\n");
      out.write("\t\t\t\t\t인원<input type=\"number\" id=\"min\" name=\"min\" placeholder=\"최소인원\" required=\"required\"> - \r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"number\" id=\"max\" name=\"max\" placeholder=\"최대인원\" required=\"required\"><br>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t<div class=\"right\">\r\n");
      out.write("\t\t\t\t\t<section class=\"weather\">\r\n");
      out.write("\t\t\t\t\t\t<label for=\"weather\"></label>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"weather__box1\">\r\n");
      out.write("\t\t\t\t\t\t\t<img class=\"weather__icon\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"weather__description\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"weather__box2\">\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"weather__temperature\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"weather__location\"></div>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\t</section>\r\n");
      out.write("\t\t\t\t\t<section class=\"map\">지도연동</section>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t<div class=\"enroll\">\r\n");
      out.write("\t\t\t<button id=\"submitBtn\" type=\"button\" class=\"btn btn-warning\">등록</button>\r\n");
      out.write("\t\t\t<button type=\"button\" class=\"btn btn-secondary\">취소</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"right\"></div>\r\n");
      out.write("\r\n");
      out.write("\t<div></div>\r\n");
      out.write("\t");
      if (_jspx_meth_c_005fimport_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<!-- =============================== -->\r\n");
      out.write("\t<script src=\"https://unpkg.com/ionicons@5.0.0/dist/ionicons.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\tvar submit = document.getElementById('submitButton');\r\n");
      out.write("\tsubmit.onclick = showImage; //Submit 버튼 클릭시 이미지 보여주기\r\n");
      out.write("\r\n");
      out.write("\tfunction showImage()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar newImage = document.getElementById('image-show').lastElementChild;\r\n");
      out.write("\t\tnewImage.style.visibility = \"visible\";\r\n");
      out.write("\r\n");
      out.write("\t\tdocument.getElementById('image-upload').style.visibility = 'hidden';\r\n");
      out.write("\r\n");
      out.write("\t\tdocument.getElementById('fileName').textContent = null; //기존 파일 이름 지우기\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction loadFile(input)\r\n");
      out.write("\t{\r\n");
      out.write("\t\tvar file = input.files[0];\r\n");
      out.write("\r\n");
      out.write("\t\tvar name = document.getElementById('fileName');\r\n");
      out.write("\t\tname.textContent = file.name;\r\n");
      out.write("\r\n");
      out.write("\t\tvar newImage = document.createElement(\"img\");\r\n");
      out.write("\t\tnewImage.setAttribute(\"class\", 'img');\r\n");
      out.write("\r\n");
      out.write("\t\tnewImage.src = URL.createObjectURL(file);\r\n");
      out.write("\r\n");
      out.write("\t\tnewImage.style.width = \"50%\";\r\n");
      out.write("\t\tnewImage.style.height = \"30%\";\r\n");
      out.write("\t\tnewImage.style.visibility = \"hidden\"; //버튼을 누르기 전까지는 이미지 숨기기\r\n");
      out.write("\t\tnewImage.style.objectFit = \"contain\";\r\n");
      out.write("\r\n");
      out.write("\t\tvar container = document.getElementById('image-show');\r\n");
      out.write("\t\tcontainer.appendChild(newImage);\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t//날씨\r\n");
      out.write("\tconst API_KEY = \"64c29b1d88f4e14a4e891b37448daadc\";\r\n");
      out.write("\tconst iconSelect = document.querySelector(\".weather__icon\")\r\n");
      out.write("\tconst Weather__description = document.querySelector(\".weather__description\")\r\n");
      out.write("\tconst weather__temperature = document.querySelector(\".weather__temperature\")\r\n");
      out.write("\tconst Weather__location = document.querySelector(\".weather__location\")\r\n");
      out.write("\tconst WeatherShowing = document.querySelector(\"section.weather\")\r\n");
      out.write("\r\n");
      out.write("\tfunction saveCoord(coordObj) {\r\n");
      out.write("    sessionStorage.setItem(\"coords\", JSON.stringify(coordObj))\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction handleGeoSuccess(position) {\r\n");
      out.write("    const latitude = position.coords.latitude;\r\n");
      out.write("    const longitude = position.coords.longitude;\r\n");
      out.write("    const coordObj = {\r\n");
      out.write("        latitude\r\n");
      out.write("        , longitude\r\n");
      out.write("    };\r\n");
      out.write("    saveCoord(coordObj);\r\n");
      out.write("    getWeather(latitude, longitude);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction handleGeoError() {\r\n");
      out.write("    iconSelect.setAttribute(\"src\", \"icons/unknown.png\")\r\n");
      out.write("    Weather__description.innerText = `???`;\r\n");
      out.write("    weather__temperature.innerText = \"-℃\"\r\n");
      out.write("    Weather__location.innerText = \"위치\";\r\n");
      out.write("    Weather__humidity.innerText = \"위치모름\"\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("function getGeolocation() {\r\n");
      out.write("    navigator.geolocation.getCurrentPosition(handleGeoSuccess, handleGeoError, {\r\n");
      out.write("        enableHighAccuracy: true\r\n");
      out.write("    });\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction getWeather(lat, lon) {\r\n");
      out.write("    let WEATHER_URL = `http://api.openweathermap.org/data/2.5/weather?lat=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lat}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&lon=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lon}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&appid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${API_KEY}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&units=metric&lang={kr}`\r\n");
      out.write("\r\n");
      out.write("    if (location.protocol === 'http:') {\r\n");
      out.write("        WEATHER_URL = `http://api.openweathermap.org/data/2.5/weather?lat=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lat}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&lon=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lon}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&appid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${API_KEY}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&units=metric&lang={kr}`\r\n");
      out.write("    } else {\r\n");
      out.write("        WEATHER_URL = `https://api.openweathermap.org/data/2.5/weather?lat=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lat}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&lon=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lon}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&appid=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${API_KEY}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&units=metric&lang={kr}`\r\n");
      out.write("    }\r\n");
      out.write("    fetch(WEATHER_URL)\r\n");
      out.write("        .then(function (response) {\r\n");
      out.write("            return response.json();\r\n");
      out.write("        })\r\n");
      out.write("        .then(function (json) {\r\n");
      out.write("            const description = json.weather[0].description;\r\n");
      out.write("            const icon = json.weather[0].icon;\r\n");
      out.write("            const temperature = json.main.temp;\r\n");
      out.write("            const currentLocation = json.name;\r\n");
      out.write("            const errorCode = json.cod;\r\n");
      out.write("            if (errorCode === \"401\") {\r\n");
      out.write("                iconSelect.setAttribute(\"src\", \"icons/unknown.png\")\r\n");
      out.write("                Weather__description.innerText = `???`;\r\n");
      out.write("                weather__temperature.innerText = \"-℃\"\r\n");
      out.write("                Weather__location.innerText = \"위치\";\r\n");
      out.write("                Weather__humidity.innerText = \"API 불러오기 실패\"\r\n");
      out.write("            } else {\r\n");
      out.write("                iconSelect.setAttribute(\"src\", `icons/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${icon}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(".png`);\r\n");
      out.write("                Weather__description.innerText = `");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${description}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("`;\r\n");
      out.write("                weather__temperature.innerText = `");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${temperature.toFixed(1)}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("℃`;\r\n");
      out.write("                Weather__location.innerText = `");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${currentLocation}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("`;\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function loadCoord() {\r\n");
      out.write("    const loadedCoords = sessionStorage.getItem(\"coords\");\r\n");
      out.write("    if (loadedCoords === null) {\r\n");
      out.write("        getGeolocation();\r\n");
      out.write("    } else {\r\n");
      out.write("        const parsedCoords = JSON.parse(loadedCoords);\r\n");
      out.write("        getWeather(parsedCoords.latitude, parsedCoords.longitude);\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("WeatherShowing.addEventListener(\"click\", loadCoord);\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("/* 사진업로드 */\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("( /* att_zone : 이미지들이 들어갈 위치 id, btn : file tag id */\r\n");
      out.write("  imageView = function imageView(att_zone, btn){\r\n");
      out.write("\r\n");
      out.write("    var attZone = document.getElementById(att_zone);\r\n");
      out.write("    var btnAtt = document.getElementById(btn)\r\n");
      out.write("    var sel_files = [];\r\n");
      out.write("    \r\n");
      out.write("    // 이미지와 체크 박스를 감싸고 있는 div 속성\r\n");
      out.write("    var div_style = 'display:inline-block;position:relative;'\r\n");
      out.write("                  + 'width:150px;height:120px;margin:5px;border:1px solid #00f;z-index:1';\r\n");
      out.write("    // 미리보기 이미지 속성\r\n");
      out.write("    var img_style = 'width:100%;height:100%;z-index:none';\r\n");
      out.write("    // 이미지안에 표시되는 체크박스의 속성\r\n");
      out.write("    var chk_style = 'width:30px;height:30px;position:absolute;font-size:24px;'\r\n");
      out.write("                  + 'right:0px;bottom:0px;z-index:999;background-color:rgba(255,255,255,0.1);color:#f00';\r\n");
      out.write("  \r\n");
      out.write("    btnAtt.onchange = function(e){\r\n");
      out.write("      var files = e.target.files;\r\n");
      out.write("      var fileArr = Array.prototype.slice.call(files)\r\n");
      out.write("      for(f of fileArr){\r\n");
      out.write("        imageLoader(f);\r\n");
      out.write("      }\r\n");
      out.write("    }  \r\n");
      out.write("    \r\n");
      out.write("  \r\n");
      out.write("    // 탐색기에서 드래그앤 드롭 사용\r\n");
      out.write("    attZone.addEventListener('dragenter', function(e){\r\n");
      out.write("      e.preventDefault();\r\n");
      out.write("      e.stopPropagation();\r\n");
      out.write("    }, false)\r\n");
      out.write("    \r\n");
      out.write("    attZone.addEventListener('dragover', function(e){\r\n");
      out.write("      e.preventDefault();\r\n");
      out.write("      e.stopPropagation();\r\n");
      out.write("      \r\n");
      out.write("    }, false)\r\n");
      out.write("  \r\n");
      out.write("    attZone.addEventListener('drop', function(e){\r\n");
      out.write("      var files = {};\r\n");
      out.write("      e.preventDefault();\r\n");
      out.write("      e.stopPropagation();\r\n");
      out.write("      var dt = e.dataTransfer;\r\n");
      out.write("      files = dt.files;\r\n");
      out.write("      for(f of files){\r\n");
      out.write("        imageLoader(f);\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("    }, false)\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    /*첨부된 이미리즐을 배열에 넣고 미리보기 */\r\n");
      out.write("    imageLoader = function(file){\r\n");
      out.write("      sel_files.push(file);\r\n");
      out.write("      var reader = new FileReader();\r\n");
      out.write("      reader.onload = function(ee){\r\n");
      out.write("        let img = document.createElement('img')\r\n");
      out.write("        img.setAttribute('style', img_style)\r\n");
      out.write("        img.src = ee.target.result;\r\n");
      out.write("        attZone.appendChild(makeDiv(img, file));\r\n");
      out.write("      }\r\n");
      out.write("      \r\n");
      out.write("      reader.readAsDataURL(file);\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    /*첨부된 파일이 있는 경우 checkbox와 함께 attZone에 추가할 div를 만들어 반환 */\r\n");
      out.write("    makeDiv = function(img, file){\r\n");
      out.write("      var div = document.createElement('div')\r\n");
      out.write("      div.setAttribute('style', div_style)\r\n");
      out.write("      \r\n");
      out.write("      var btn = document.createElement('input')\r\n");
      out.write("      btn.setAttribute('type', 'button')\r\n");
      out.write("      btn.setAttribute('value', 'x')\r\n");
      out.write("      btn.setAttribute('delFile', file.name);\r\n");
      out.write("      btn.setAttribute('style', chk_style);\r\n");
      out.write("      btn.onclick = function(ev){\r\n");
      out.write("        var ele = ev.srcElement;\r\n");
      out.write("        var delFile = ele.getAttribute('delFile');\r\n");
      out.write("        for(var i=0 ;i<sel_files.length; i++){\r\n");
      out.write("          if(delFile== sel_files[i].name){\r\n");
      out.write("            sel_files.splice(i, 1);      \r\n");
      out.write("          }\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        dt = new DataTransfer();\r\n");
      out.write("        for(f in sel_files) {\r\n");
      out.write("          var file = sel_files[f];\r\n");
      out.write("          dt.items.add(file);\r\n");
      out.write("        }\r\n");
      out.write("        btnAtt.files = dt.files;\r\n");
      out.write("        var p = ele.parentNode;\r\n");
      out.write("        attZone.removeChild(p)\r\n");
      out.write("      }\r\n");
      out.write("      div.appendChild(img)\r\n");
      out.write("      div.appendChild(btn)\r\n");
      out.write("      return div\r\n");
      out.write("    }\r\n");
      out.write("  }\r\n");
      out.write(")('att_zone', 'btnAtt')\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fimport_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f0 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    boolean _jspx_th_c_005fimport_005f0_reused = false;
    try {
      _jspx_th_c_005fimport_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fimport_005f0.setParent(null);
      // /Meeting_enroll.jsp(235,2) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fimport_005f0.setUrl("subHeader.jsp");
      int[] _jspx_push_body_count_c_005fimport_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fimport_005f0 = _jspx_th_c_005fimport_005f0.doStartTag();
        if (_jspx_th_c_005fimport_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fimport_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fimport_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fimport_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f0);
      _jspx_th_c_005fimport_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fimport_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fimport_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fimport_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:import
    org.apache.taglibs.standard.tag.rt.core.ImportTag _jspx_th_c_005fimport_005f1 = (org.apache.taglibs.standard.tag.rt.core.ImportTag) _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.ImportTag.class);
    boolean _jspx_th_c_005fimport_005f1_reused = false;
    try {
      _jspx_th_c_005fimport_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fimport_005f1.setParent(null);
      // /Meeting_enroll.jsp(319,1) name = url type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fimport_005f1.setUrl("footer.jsp");
      int[] _jspx_push_body_count_c_005fimport_005f1 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fimport_005f1 = _jspx_th_c_005fimport_005f1.doStartTag();
        if (_jspx_th_c_005fimport_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fimport_005f1[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fimport_005f1.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fimport_005f1.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fimport_0026_005furl_005fnobody.reuse(_jspx_th_c_005fimport_005f1);
      _jspx_th_c_005fimport_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fimport_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fimport_005f1_reused);
    }
    return false;
  }
}
